package com.rodriguesalex.marvelsdk.characters.data

import com.google.gson.annotations.SerializedName

data class MarvelCharacterThumbnail(
    var path: String? = null,
    @SerializedName("extension") val imageExtension: String? = null
)
