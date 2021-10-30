package com.example.intentputdataclass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String,
    var age: Int,
    var job: String
): Parcelable
{
    override fun toString(): String {
        return "name:$name, age:$age, job:$job"
    }
}
