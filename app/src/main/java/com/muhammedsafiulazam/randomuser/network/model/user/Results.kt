package com.muhammedsafiulazam.randomuser.network.model.user

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results constructor (
    @field:Json(name = "results") val results: List<User>?,
    @field:Json(name = "info") val info: Info?
) : Parcelable