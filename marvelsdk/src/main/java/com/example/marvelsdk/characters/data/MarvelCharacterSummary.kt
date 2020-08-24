package com.example.marvelsdk.characters.data

import com.google.gson.annotations.SerializedName

data class MarvelCharacterSummary(
    @SerializedName("I") val identifier: Int? = null,
    @SerializedName("I") val someName: String? = null,
    val items: List<MarvelItem>? = null
)
