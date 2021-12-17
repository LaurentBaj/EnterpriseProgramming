package no.kristiania.pg6102_exam.trip.resource

import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.dto.UpdateTripRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface TripResource {
    fun findById(id: Long): ResponseEntity<TripResponse>?
    fun findAll(pageable: Pageable): ResponseEntity<Page<TripResponse>>
    fun save(addTripRequest: AddTripRequest): ResponseEntity<TripResponse>
    fun update(updateTripRequest: UpdateTripRequest): ResponseEntity<TripResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
    fun deleteAll()
}


// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/resource/PersonResource.kt