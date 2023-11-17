package com.jfaf.elpuntuador.model.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Players")
data class PlayerDaoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val thumbnail: String
)