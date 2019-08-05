package com.muhammedsafiulazam.randomuser.network.model.user

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User constructor (
    @field:Json(name = "gender") val gender: String?,
    @field:Json(name = "name") val name: Name?,
    @field:Json(name = "picture") val picture: Picture?,
    @field:Json(name = "email") val email: String?,
    @field:Json(name = "phone") val phone: String?
) : Parcelable {
    companion object {
        const val GENDER_MALE = "male"
        const val GENDER_FEMALE = "female"
    }
}