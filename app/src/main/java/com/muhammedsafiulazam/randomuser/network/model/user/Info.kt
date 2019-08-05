package com.muhammedsafiulazam.randomuser.network.model.user

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Info constructor (
    @field:Json(name = "seed") val seed: String?,
    @field:Json(name = "results") val results: Int?,
    @field:Json(name = "page") val page: Int?,
    @field:Json(name = "version") var version: String?
) : Parcelable