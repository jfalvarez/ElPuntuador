package com.jfaf.elpuntuador.model.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jfaf.elpuntuador.model.data.entities.GameState
import com.jfaf.elpuntuador.model.data.entities.PlayerDaoEntity
import com.jfaf.elpuntuador.model.data.entities.PlayerOnGame
import com.jfaf.elpuntuador.model.data.entities.ScoreDaoEntity


@Dao
interface GameDao {
    @Insert
    suspend fun insertarJugador(jugador: PlayerDaoEntity)

    @Insert
    suspend fun insertarPartida(partida: GameDaoEntity)

    @Insert
    suspend fun insertarPuntuacion(puntuacion: ScoreDaoEntity)

    @Update
    suspend fun updateGame(game: GameDaoEntity)

    @Query("UPDATE game SET state = :gameState")
    suspend fun updateGamesToFinished(gameState: Int = GameState.END.value)

    @Query("Update Score set score = :newScore where playerID = :playerID and gameID = :gameId")
    suspend fun updateScore(gameId: Int, playerID: Int, newScore: Int)

    @Query("SELECT * FROM Players")
    suspend fun getPlayers(): List<PlayerDaoEntity>

    @Query("SELECT * FROM game")
    suspend fun getGames(): List<GameDaoEntity>

    @Query("SELECT * FROM game where state = :gameState")
    suspend fun getStartedGame(gameState: Int = GameState.START.value): GameDaoEntity

    @Query("SELECT * FROM Score where gameID = :gameId")
    suspend fun getScoresByGameId(gameId: Int): List<ScoreDaoEntity>

    @Query("SELECT Players.id as playerId, Score.gameID as gameId, Players.name,Players.thumbnail, Score.score  FROM Score inner join Players on Score.playerID = Players.id where gameID = :gameID")
    suspend fun getPlayersByGameID(gameID: Int): List<PlayerOnGame>


}