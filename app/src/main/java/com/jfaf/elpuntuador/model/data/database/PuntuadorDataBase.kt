package com.jfaf.elpuntuador.model.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jfaf.elpuntuador.model.data.database.GameDao
import com.jfaf.elpuntuador.model.data.database.GameDaoEntity
import com.jfaf.elpuntuador.model.data.entities.PlayerDaoEntity
import com.jfaf.elpuntuador.model.data.entities.ScoreDaoEntity

@Database(
    entities = [GameDaoEntity::class, PlayerDaoEntity::class, ScoreDaoEntity::class],
    version = 1
)
abstract class PuntuadorDataBase: RoomDatabase() {
    abstract fun gameDao(): GameDao
}