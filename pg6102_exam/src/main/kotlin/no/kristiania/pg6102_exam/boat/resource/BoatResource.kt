package no.kristiania.pg6102_exam.boat.resource

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import no.kristiania.pg6102_exam.boat.dto.UpdateBoatResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface BoatResource {
    fun findById(id: Long): ResponseEntity<BoatResponse>?
    fun findAll(pageable: Pageable): ResponseEntity<Page<BoatResponse>>
    fun save(addBoatRequest: AddBoatRequest): ResponseEntity<BoatResponse>
    fun update(updateBoatResponse: UpdateBoatResponse): ResponseEntity<BoatResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
    fun deleteAll(): Unit
}