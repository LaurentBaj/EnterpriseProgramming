package no.kristiania.pg6102_exam.boat.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}