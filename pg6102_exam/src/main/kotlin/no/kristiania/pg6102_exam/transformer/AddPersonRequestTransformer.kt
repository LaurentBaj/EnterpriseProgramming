package no.kristiania.pg6102_exam.transformer

import no.kristiania.pg6102_exam.domain.Person
import no.kristiania.pg6102_exam.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer : Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(
                name = source.name,
                lastName = source.lastName
        )
    }
}