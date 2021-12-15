package no.kristiania.pg6102_exam.trip.dto

class UpdateTripResponse (val id: Long, val name: String, val builder: String? = null, var crewMembers:Int = 0)