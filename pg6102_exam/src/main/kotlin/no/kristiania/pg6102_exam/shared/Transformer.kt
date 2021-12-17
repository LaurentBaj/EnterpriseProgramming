package no.kristiania.pg6102_exam.shared

interface Transformer <A, B> {
    fun transform(source: A): B
}


// Adapted from: https://github.com/MarianoLopez/SpringKotlinBuildingRestApiTutorial/blob/develop/src/main/kotlin/com/z/springkotlinz/transformer/Transformer.kt