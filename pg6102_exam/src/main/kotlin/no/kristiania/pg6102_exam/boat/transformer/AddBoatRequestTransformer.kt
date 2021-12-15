package no.kristiania.pg6102_exam.boat.transformer

import no.kristiania.pg6102_exam.boat.entity.Boat
import no.kristiania.pg6102_exam.boat.dto.AddBoatRequest
import org.springframework.stereotype.Component

@Component
class AddBoatRequestTransformer : Transformer<AddBoatRequest, Boat> {
    override fun transform(source: AddBoatRequest): Boat {
        return Boat(
                name = source.name,
                builder = source.builder
        )
    }
}