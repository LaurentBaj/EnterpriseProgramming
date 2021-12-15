package no.kristiania.pg6102_exam.person.service

import no.kristiania.pg6102_exam.person.dao.PersonDao
import no.kristiania.pg6102_exam.person.domain.Person
import no.kristiania.pg6102_exam.person.dto.AddPersonRequest
import no.kristiania.pg6102_exam.person.dto.PersonResponse
import no.kristiania.pg6102_exam.person.dto.UpdatePersonRequest
import no.kristiania.pg6102_exam.person.transformer.AddPersonRequestTransformer
import no.kristiania.pg6102_exam.person.transformer.toPersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(private val personDao: PersonDao,
                                  private val addPersonRequestTransformer: AddPersonRequestTransformer) : PersonManagementService {

    override fun findById(id: Long): PersonResponse? = this.findPersonById(id).toPersonResponse()

    override fun findAll(pageable: Pageable): Page<PersonResponse> = this.personDao.findAll(pageable).map(Person::toPersonResponse)

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return this.saveOrUpdate(
                addPersonRequestTransformer.transform(addPersonRequest)
        )
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = this.findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")

        return this.saveOrUpdate(person.apply {
            this.name = updatePersonRequest.name
            this.lastName = updatePersonRequest.lastName
        })
    }

    override fun deleteAll() {
        personDao.deleteAll()
    }

    override fun deleteById(id: Long) {
        this.personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = this.personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = this.personDao.save(person).toPersonResponse()
}