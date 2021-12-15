package no.kristiania.pg6102_exam.trip.transformer

import no.kristiania.pg6102_exam.shared.Transformer
import no.kristiania.pg6102_exam.trip.dto.AddTripRequest
import no.kristiania.pg6102_exam.trip.entity.Trip
import org.springframework.stereotype.Component

@Component
class AddTripRequestTransformer : Transformer<AddTripRequest, Trip> {
    override fun transform(source: AddTripRequest): Trip {
        return Trip(
                name = source.name,
                builder = source.builder,
                crewMembers = source.crewMembers
        )
    }
}