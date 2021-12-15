package no.kristiania.pg6102_exam.boat.transformer

import no.kristiania.pg6102_exam.boat.entity.Boat
import no.kristiania.pg6102_exam.boat.dto.BoatResponse

fun Boat?.toPersonResponse(): BoatResponse {
    return BoatResponse(
            id = this?.id ?: 1L,
            fullName = "${this?.builder}, ${this?.name}"
    )
}