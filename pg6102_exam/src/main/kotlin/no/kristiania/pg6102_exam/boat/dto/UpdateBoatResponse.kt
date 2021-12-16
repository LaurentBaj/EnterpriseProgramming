package no.kristiania.pg6102_exam.boat.dto


class UpdateBoatResponse (val id: Long, val name: String, val builder: String? = null, var crewMembers:Int = 0)