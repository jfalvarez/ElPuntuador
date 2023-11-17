package com.jfaf.elpuntuador.model.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import com.jfaf.elpuntuador.model.data.database.GameDaoEntity

@Entity(
    tableName = "Score",
    foreignKeys = [
        ForeignKey(
            entity = GameDaoEntity::class,
            parentColumns = ["id"],
            childColumns = ["gameID"],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = PlayerDaoEntity::class,
            parentColumns = ["id"],
            childColumns = ["playerID"],
            onDelete = CASCADE
        )
    ],
)
data class ScoreDaoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val gameID: Int,
    val playerID: Int,
    val score: Int
)
