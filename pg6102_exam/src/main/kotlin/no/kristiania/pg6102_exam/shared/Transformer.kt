package no.kristiania.pg6102_exam.shared

interface Transformer <A, B> {
    fun transform(source: A): B
}