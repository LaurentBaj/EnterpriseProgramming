package no.kristiania.pg6102_exam.person.service

import no.kristiania.pg6102_exam.person.dto.AddPersonRequest
import no.kristiania.pg6102_exam.person.dto.PersonResponse
import no.kristiania.pg6102_exam.person.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PersonManagementService {
    fun findById(id: Long): PersonResponse?
    fun findAll(pageable: Pageable): Page<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteAll(): Unit 
    fun deleteById(id: Long)
}