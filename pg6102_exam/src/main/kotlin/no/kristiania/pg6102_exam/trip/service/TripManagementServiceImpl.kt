package no.kristiania.pg6102_exam.trip.service


import no.kristiania.pg6102_exam.trip.dao.TripDao
import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.dto.UpdateTripRequest
import no.kristiania.pg6102_exam.trip.entity.Trip
import no.kristiania.pg6102_exam.trip.transformer.AddTripRequestTransformer
import no.kristiania.pg6102_exam.trip.transformer.toTripResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TripManagementServiceImpl(private val tripDao: TripDao,
                                private val addTripRequestTransformer: AddTripRequestTransformer) : TripManagementService {

    override fun findById(id: Long): TripResponse? = this.findTripById(id).toTripResponse()

    override fun findAll(pageable: Pageable): Page<TripResponse> = this.tripDao.findAll(pageable).map(Trip::toTripResponse)

    override fun save(addTripRequest: AddTripRequest): TripResponse {
        return this.saveOrUpdate(
                addTripRequestTransformer.transform(addTripRequest)
        )
    }

    override fun update(updateTripRequest: UpdateTripRequest): TripResponse {
        val trip = this.findTripById(updateTripRequest.id) ?: throw IllegalStateException("${updateTripRequest.id} not found")

        return this.saveOrUpdate(trip.apply {
            this.departurePort = updateTripRequest.departurePort
            this.destinationPort = updateTripRequest.destinationPort
        })
    }

    override fun deleteAll() {
        tripDao.deleteAll()
    }

    override fun deleteById(id: Long) {
        this.tripDao.deleteById(id)
    }

    private fun findTripById(id: Long): Trip? = this.tripDao.findByIdOrNull(id)

    private fun saveOrUpdate(trip: Trip): TripResponse = this.tripDao.save(trip).toTripResponse()
}