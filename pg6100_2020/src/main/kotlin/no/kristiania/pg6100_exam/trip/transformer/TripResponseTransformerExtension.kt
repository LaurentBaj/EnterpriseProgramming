package no.kristiania.pg6100_exam.trip.transformer

import no.kristiania.pg6100_exam.trip.dto.TripResponse
import no.kristiania.pg6100_exam.trip.entity.Trip

fun Trip?.toTripResponse(): TripResponse {
    return TripResponse(
            id = this?.id ?: 1L,
            departurePort = "${this?.departurePort}",
            destinationPort = "${this?.destinationPort}"
    )
}

// Adapted from https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/transformer/PersonResponseTransformerExtension.kt