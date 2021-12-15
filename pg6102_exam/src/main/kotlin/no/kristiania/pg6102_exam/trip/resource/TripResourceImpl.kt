package no.kristiania.pg6102_exam.trip.resource

import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.dto.UpdateTripResponse
import no.kristiania.pg6102_exam.trip.resource.TripResourceImpl.Companion.BASE_TRIP_URL
import no.kristiania.pg6102_exam.trip.service.TripManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_TRIP_URL])
class TripResourceImpl(private val tripManagementService: TripManagementService) : TripResource {

    @GetMapping("/{id}")
    override fun findById(id: Long): ResponseEntity<TripResponse>? {
        val boatResponse = this.tripManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(boatResponse)
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<TripResponse>> = ResponseEntity.ok(this.tripManagementService.findAll(pageable))

    @PostMapping()
    override fun save(@RequestBody addTripRequest: AddTripRequest): ResponseEntity<TripResponse> {
        val boatResponse = this.tripManagementService.save(addTripRequest)
        return ResponseEntity
                .created(URI.create(BASE_TRIP_URL.plus("/${boatResponse.id}")))
                .body(boatResponse)
    }

    @PutMapping
    override fun update(@RequestBody updateTripResponse: UpdateTripResponse): ResponseEntity<TripResponse> {
        return ResponseEntity.ok(this.tripManagementService.update(updateTripResponse))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.tripManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    override fun deleteAll() {
        tripManagementService.deleteAll()
    }

    companion object {
        const val BASE_TRIP_URL: String = "/api/v1/boats"
    }
}