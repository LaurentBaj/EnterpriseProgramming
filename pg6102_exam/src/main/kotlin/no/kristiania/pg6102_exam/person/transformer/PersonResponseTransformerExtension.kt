package no.kristiania.pg6102_exam.person.transformer

import no.kristiania.pg6102_exam.person.domain.Person
import no.kristiania.pg6102_exam.person.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.name}"
    )
}