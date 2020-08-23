package com.example.marvelsdk.characters.data

import com.google.gson.annotations.SerializedName

data class MarvelCharacterThumbnail (
    var path: String? = null,
    @SerializedName("extension") var imageExtension: String? = null
)