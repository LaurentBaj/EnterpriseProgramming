package no.kristiania.pg6102_exam.trip.service

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.dto.UpdateTripResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TripManagementService {
    fun findById(id: Long): TripResponse?
    fun findAll(pageable: Pageable): Page<TripResponse>
    fun save(addTripRequest: AddTripRequest): TripResponse
    fun update(updateTripResponse: UpdateTripResponse): TripResponse
    fun deleteAll()
    fun deleteById(id: Long)
}