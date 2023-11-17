package com.jfaf.elpuntuador.model.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game")
data class GameDaoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val state: Int,
    val date: String
)