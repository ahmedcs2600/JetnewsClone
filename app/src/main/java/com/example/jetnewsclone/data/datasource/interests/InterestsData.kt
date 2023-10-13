package com.example.jetnewsclone.data.datasource.interests


val topics by lazy {
    linkedMapOf(
        "Android" to listOf("Jetpack Compose", "Kotlin", "Jetpack"),
        "Programming" to
            listOf("Kotlin", "Declarative UIs", "Java", "Unidirectional Data Flow", "C++")
        ,
        "Technology" to listOf("Pixel", "Google")
    )
}

val people by lazy {
    listOf(
        "Kobalt Toral",
        "K'Kola Uvarek",
        "Kris Vriloc",
        "Grala Valdyr",
        "Kruel Valaxar",
        "L'Elij Venonn",
        "Kraag Solazarn",
        "Tava Targesh",
        "Kemarrin Muuda"
    )
}

val publications by lazy {
    listOf(
        "Kotlin Vibe",
        "Compose Mix",
        "Compose Breakdown",
        "Android Pursue",
        "Kotlin Watchman",
        "Jetpack Ark",
        "Composeshack",
        "Jetpack Point",
        "Compose Tribune"
    )
}