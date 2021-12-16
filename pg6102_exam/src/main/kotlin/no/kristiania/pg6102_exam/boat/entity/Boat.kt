package no.kristiania.pg6102_exam.boat.entity

import no.kristiania.pg6102_exam.trip.entity.Trip
import javax.persistence.*

@Entity
data class Boat(

        @Id
        @SequenceGenerator(name = BOAT_SEQUENCE, sequenceName = BOAT_SEQUENCE, initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BOAT_SEQUENCE)
        val id: Long = 1,
        var name: String = "",
        var builder: String? = null,
        var crewMembers: Int = 0,

        @ManyToOne
        var trip: Trip? = null
        ) {

    companion object {
        const val BOAT_SEQUENCE: String = "BOAT_SEQUENCE"
    }
}