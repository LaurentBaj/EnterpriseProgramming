package no.kristiania.pg6100_exam.boat.service

import no.kristiania.pg6100_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6100_exam.boat.dto.BoatResponse
import no.kristiania.pg6100_exam.boat.dto.UpdateBoatResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface BoatManagementService {
    fun findById(id: Long): BoatResponse?
    fun findAll(pageable: Pageable): Page<BoatResponse>
    fun save(addBoatRequest: AddBoatRequest): BoatResponse
    fun update(updateBoatResponse: UpdateBoatResponse): BoatResponse
    fun deleteAll()
    fun deleteById(id: Long)
}


// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/tree/develop/src/main/kotlin/com/z/springkotlinz/service