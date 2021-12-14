package no.kristiania.pg6102_exam.transformer

import no.kristiania.pg6102_exam.domain.Person
import no.kristiania.pg6102_exam.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse {
    return PersonResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.name}"
    )
}