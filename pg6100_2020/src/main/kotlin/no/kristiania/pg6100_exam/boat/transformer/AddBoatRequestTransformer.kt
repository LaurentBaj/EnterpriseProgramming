package no.kristiania.pg6100_exam.boat.transformer

import no.kristiania.pg6100_exam.boat.entity.Boat
import no.kristiania.pg6100_exam.boat.dto.AddBoatRequest
import no.kristiania.pg6100_exam.shared.Transformer
import org.springframework.stereotype.Component

@Component
class AddBoatRequestTransformer : Transformer<AddBoatRequest, Boat> {
    override fun transform(source: AddBoatRequest): Boat {
        return Boat(
                name = source.name,
                builder = source.builder,
                crewMembers = source.crewMembers
        )
    }
}


// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/tree/develop/src/main/kotlin/com/z/springkotlinz/transformer