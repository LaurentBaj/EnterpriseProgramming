package no.kristiania.pg6102_exam.boat.resource

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import no.kristiania.pg6102_exam.boat.dto.UpdateBoatResponse
import no.kristiania.pg6102_exam.boat.service.BoatManagementService
import no.kristiania.pg6102_exam.shared.URLs.BASE_BOAT_URL
import no.kristiania.pg6102_exam.trip.entity.Trip

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.transaction.Transactional


@RestController
@RequestMapping(value = [BASE_BOAT_URL])
class BoatResourceImpl(private val boatManagementService: BoatManagementService) : BoatResource {

    @GetMapping("/{id}")
    override fun findById(id: Long): ResponseEntity<BoatResponse>? {
        val boatResponse = this.boatManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(boatResponse)
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<BoatResponse>> = ResponseEntity.ok(this.boatManagementService.findAll(pageable))

    @PostMapping()
    override fun save(@RequestBody addBoatRequest: AddBoatRequest): ResponseEntity<BoatResponse> {
        val boatResponse = this.boatManagementService.save(addBoatRequest)
        return ResponseEntity
                .created(URI.create(BASE_BOAT_URL.plus("/${boatResponse.id}")))
                .body(boatResponse)
    }

    @PutMapping
    override fun update(@RequestBody updateBoatResponse: UpdateBoatResponse): ResponseEntity<BoatResponse> {
        return ResponseEntity.ok(this.boatManagementService.update(updateBoatResponse))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.boatManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    override fun deleteAll() {
        boatManagementService.deleteAll()
    }
}