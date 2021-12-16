package no.kristiania.pg6102_exam.boat.transformer

import no.kristiania.pg6102_exam.boat.dto.BoatResponse
import no.kristiania.pg6102_exam.boat.entity.Boat

fun Boat?.toBoatResponse(): BoatResponse {
    return BoatResponse(
            id = this?.id ?: 1L,
            name = this!!.name,
            builder = "${this?.builder}",
            crewMembers = this!!.crewMembers
    )
}