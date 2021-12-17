package no.kristiania.pg6102_exam.boat.dto

// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/dto/AddPersonRequest.kt

class AddBoatRequest (val name: String, val builder: String? = null, var crewMembers:Int = 0)