package no.kristiania.pg6102_exam.boat.resource

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import no.kristiania.pg6102_exam.boat.dto.UpdateBoatResponse
import no.kristiania.pg6102_exam.boat.resource.BoatResourceImpl.Companion.BASE_PERSON_URL
import no.kristiania.pg6102_exam.boat.service.BoatManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class BoatResourceImpl(private val boatManagementService: BoatManagementService) : BoatResource {

    @GetMapping("/{id}")
    override fun findById(id: Long): ResponseEntity<BoatResponse>? {
        val personResponse = this.boatManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personResponse)
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<BoatResponse>> = ResponseEntity.ok(this.boatManagementService.findAll(pageable))

    @PostMapping()
    override fun save(@RequestBody addBoatRequest: AddBoatRequest): ResponseEntity<BoatResponse> {
        val personResponse = this.boatManagementService.save(addBoatRequest)
        return ResponseEntity
                .created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}")))
                .body(personResponse)
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

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/person"
    }
}