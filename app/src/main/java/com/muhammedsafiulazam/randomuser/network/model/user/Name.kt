package com.muhammedsafiulazam.randomuser.network.model.user

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name (
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "first") val first: String?,
    @field:Json(name = "last") val last: String?
) : Parcelable