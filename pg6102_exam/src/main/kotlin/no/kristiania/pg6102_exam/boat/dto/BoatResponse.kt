package no.kristiania.pg6102_exam.boat.dto

import no.kristiania.pg6102_exam.trip.entity.Trip

class BoatResponse(val id: Long, val builder: String, var crewMembers: Int = 0)