package no.kristiania.pg6102_exam.transformer

interface Transformer <A, B> {
    fun transform(source: A): B
}