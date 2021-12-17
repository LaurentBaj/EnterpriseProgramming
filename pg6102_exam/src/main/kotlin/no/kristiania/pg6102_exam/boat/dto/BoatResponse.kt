package no.kristiania.pg6102_exam.boat.dto


class BoatResponse(val id: Long, var name: String, var builder: String, var crewMembers: Int = 0)



// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/dto/PersonResponse.kt