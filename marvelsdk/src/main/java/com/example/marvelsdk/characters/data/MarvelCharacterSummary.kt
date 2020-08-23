package com.example.marvelsdk.characters.data

import com.google.gson.annotations.SerializedName

data class MarvelCharacterSummary (
    @SerializedName("I") val identifier: Int? = null,
    @SerializedName("I") var someName: String? = null,
    var items: List<MarvelItem>? = null
)