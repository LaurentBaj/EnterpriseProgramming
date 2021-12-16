package no.kristiania.pg6102_exam.boat.dto

import no.kristiania.pg6102_exam.trip.entity.Trip

class BoatResponse(val id: Long, var name: String, var builder: String, var crewMembers: Int = 0)