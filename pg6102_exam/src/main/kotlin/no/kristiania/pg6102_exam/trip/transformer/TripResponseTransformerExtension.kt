package no.kristiania.pg6102_exam.trip.transformer

import no.kristiania.pg6102_exam.trip.dto.TripResponse
import no.kristiania.pg6102_exam.trip.entity.Trip

fun Trip?.toTripResponse(): TripResponse {
    return TripResponse(
            id = this?.id ?: 1L,
            builder = "${this?.builder}, ${this?.name}",
            crewMembers = this!!.crewMembers
    )
}