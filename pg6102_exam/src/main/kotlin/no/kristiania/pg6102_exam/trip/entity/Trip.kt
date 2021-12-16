package no.kristiania.pg6102_exam.trip.entity

import javax.persistence.*

@Entity
data class Trip(

        @Id
        @SequenceGenerator(name = TRIP_SEQUENCE, sequenceName = TRIP_SEQUENCE, initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TRIP_SEQUENCE)
        val id: Long = 1,
        var departurePort: String = "",
        var destinationPort: String? = null) {

    companion object {
        const val TRIP_SEQUENCE: String = "TRIP_SEQUENCE"
    }
}