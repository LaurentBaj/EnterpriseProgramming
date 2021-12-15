package no.kristiania.pg6102_exam.boat.entity

import javax.persistence.*

@Entity
data class Boat(

        @Id
        @SequenceGenerator(name = BOAT_SEQUENCE, sequenceName = BOAT_SEQUENCE, initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = BOAT_SEQUENCE)
        val id: Long = 1,
        var name: String = "",
        var builder: String? = null) {

    companion object {
        const val BOAT_SEQUENCE: String = "BOAT_SEQUENCE"
    }
}