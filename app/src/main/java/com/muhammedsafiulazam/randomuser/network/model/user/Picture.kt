package com.muhammedsafiulazam.randomuser.network.model.user

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture constructor(
    @field:Json(name = "large") val large: String?,
    @field:Json(name = "medium") val medium: String?,
    @field:Json(name = "thumbnail") val thumbnail: String
) : Parcelable