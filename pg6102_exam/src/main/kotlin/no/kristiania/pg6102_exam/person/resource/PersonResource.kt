package no.kristiania.pg6102_exam.person.resource

import no.kristiania.pg6102_exam.person.dto.AddPersonRequest
import no.kristiania.pg6102_exam.person.dto.PersonResponse
import no.kristiania.pg6102_exam.person.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface PersonResource {
    fun findById(id: Long): ResponseEntity<PersonResponse>?
    fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
    fun deleteAll(): Unit
}