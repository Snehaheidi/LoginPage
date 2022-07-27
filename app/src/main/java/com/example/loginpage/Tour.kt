package com.example.loginpage

import android.os.Parcel
import android.os.Parcelable

//Pojo Class --> like that
data class Tour(val image : Int , val name:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tour> {
        override fun createFromParcel(parcel: Parcel): Tour {
            return Tour(parcel)
        }

        override fun newArray(size: Int): Array<Tour?> {
            return arrayOfNulls(size)
        }
    }
}
