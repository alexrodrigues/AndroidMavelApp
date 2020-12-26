package com.rodriguesalex.marvelapp.home.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeCharacterVO(
    val id: String,
    val name: String,
    val description: String,
    val urlImage: String
): Parcelable
