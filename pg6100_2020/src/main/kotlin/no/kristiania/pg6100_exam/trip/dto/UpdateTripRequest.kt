package no.kristiania.pg6100_exam.trip.dto


// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/dto/UpdatePersonRequest.kt

class UpdateTripRequest (val id: Long, val departurePort: String, val destinationPort: String)