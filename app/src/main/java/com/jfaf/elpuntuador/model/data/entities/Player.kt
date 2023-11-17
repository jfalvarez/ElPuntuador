package com.jfaf.elpuntuador.model.data.entities

import android.os.Parcel
import android.os.Parcelable

data class Player (
    val id: Int,
    var name: String,
    var score: Int,
    var isSelected: Boolean = false
): Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString()?:"",
        score = parcel.readInt(),
        isSelected = parcel.readBoolean()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(score)
        parcel.writeBoolean(isSelected)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }

    fun toEntity() = PlayerDaoEntity(id, name, "")
}