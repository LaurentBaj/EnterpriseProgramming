package no.kristiania.pg6100_exam.trip.service

import no.kristiania.pg6100_exam.trip.dto.AddTripRequest
import no.kristiania.pg6100_exam.trip.dto.TripResponse
import no.kristiania.pg6100_exam.trip.dto.UpdateTripRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TripManagementService {
    fun findById(id: Long): TripResponse?
    fun findAll(pageable: Pageable): Page<TripResponse>
    fun save(addTripRequest: AddTripRequest): TripResponse
    fun update(updateTripRequest: UpdateTripRequest): TripResponse
    fun deleteAll()
    fun deleteById(id: Long)
}

// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/tree/develop/src/main/kotlin/com/z/springkotlinz/service