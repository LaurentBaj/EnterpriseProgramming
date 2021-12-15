package no.kristiania.pg6102_exam.boat.service

import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import no.kristiania.pg6102_exam.boat.dto.UpdateBoatResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BoatManagementService {
    fun findById(id: Long): BoatResponse?
    fun findAll(pageable: Pageable): Page<BoatResponse>
    fun save(addBoatRequest: AddBoatRequest): BoatResponse
    fun update(updateBoatResponse: UpdateBoatResponse): BoatResponse
    fun deleteAll(): Unit 
    fun deleteById(id: Long)
}