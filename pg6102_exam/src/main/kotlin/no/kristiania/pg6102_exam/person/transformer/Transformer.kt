package no.kristiania.pg6102_exam.person.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}