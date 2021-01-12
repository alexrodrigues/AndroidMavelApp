package com.rodriguesalex.marvelapp.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDetailsVO(
    val series: List<String>,
    val comics: List<String>,
    val stories: List<String>
): Parcelable