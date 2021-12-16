package no.kristiania.pg6102_exam.trip.resource

import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.dto.UpdateTripResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface TripResource {
    fun findById(id: Long): ResponseEntity<TripResponse>?
    fun findAll(pageable: Pageable): ResponseEntity<Page<TripResponse>>
    fun save(addTripRequest: AddTripRequest): ResponseEntity<TripResponse>
    fun update(updateTripResponse: UpdateTripResponse): ResponseEntity<TripResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
    fun deleteAll()
}