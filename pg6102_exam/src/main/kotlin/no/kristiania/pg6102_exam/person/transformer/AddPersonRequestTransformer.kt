package no.kristiania.pg6102_exam.person.transformer

import no.kristiania.pg6102_exam.person.domain.Person
import no.kristiania.pg6102_exam.person.dto.AddPersonRequest
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