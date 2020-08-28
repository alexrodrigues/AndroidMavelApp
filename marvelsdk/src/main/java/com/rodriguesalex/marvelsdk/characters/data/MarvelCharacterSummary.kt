package com.rodriguesalex.marvelsdk.characters.data

import com.google.gson.annotations.SerializedName

data class MarvelCharacterSummary(
    @SerializedName("I") val identifier: Int? = null,
    @SerializedName("S") val someName: String? = null,
    val items: List<MarvelItem>? = null
)
