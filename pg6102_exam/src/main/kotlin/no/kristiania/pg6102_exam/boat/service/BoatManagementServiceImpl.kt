package no.kristiania.pg6102_exam.boat.service

import no.kristiania.pg6102_exam.boat.dao.BoatDao
import no.kristiania.pg6102_exam.boat.entity.Boat
import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import no.kristiania.pg6102_exam.boat.dto.UpdateBoatResponse
import no.kristiania.pg6102_exam.boat.transformer.AddBoatRequestTransformer
import no.kristiania.pg6102_exam.boat.transformer.toBoatResponse
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.entity.Trip

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BoatManagementServiceImpl(private val boatDao: BoatDao,
                                private val addBoatRequestTransformer: AddBoatRequestTransformer) : BoatManagementService {

    override fun findById(id: Long): BoatResponse? = this.findBoatById(id).toBoatResponse()

    override fun findAll(pageable: Pageable): Page<BoatResponse> = this.boatDao.findAll(pageable).map(Boat::toBoatResponse)

    override fun save(addBoatRequest: AddBoatRequest): BoatResponse {
        return this.saveOrUpdate(
                addBoatRequestTransformer.transform(addBoatRequest)
        )
    }

    override fun update(updateBoatResponse: UpdateBoatResponse): BoatResponse {
        val person = this.findBoatById(updateBoatResponse.id) ?: throw IllegalStateException("${updateBoatResponse.id} not found")

        return this.saveOrUpdate(person.apply {
            this.name = updateBoatResponse.name
            this.builder = updateBoatResponse.builder
            this.name = updateBoatResponse.name
            this.crewMembers = updateBoatResponse.crewMembers
        })
    }

    override fun deleteAll() {
        boatDao.deleteAll()
    }

    override fun deleteById(id: Long) {
        this.boatDao.deleteById(id)
    }

    private fun findBoatById(id: Long): Boat? = this.boatDao.findByIdOrNull(id)

    private fun saveOrUpdate(boat: Boat): BoatResponse = this.boatDao.save(boat).toBoatResponse()
}