package com.jfaf.elpuntuador.model.data.repositories

import com.jfaf.elpuntuador.model.data.database.GameDaoEntity
import com.jfaf.elpuntuador.model.data.entities.PlayerDaoEntity
import com.jfaf.elpuntuador.model.data.database.PuntuadorDataBase
import com.jfaf.elpuntuador.model.data.entities.ScoreDaoEntity

class PuntuadorRepository(
    private val dataBase: PuntuadorDataBase
) {
    suspend fun getPlayers() = dataBase.gameDao().getPlayers()
    suspend fun getGames() = dataBase.gameDao().getGames()
    suspend fun getStartedGame() = dataBase.gameDao().getStartedGame()
    suspend fun getScoreByGameId(gameId: Int) = dataBase.gameDao().getScoresByGameId(gameId)
    suspend fun getPlayersbyGameId(gameId: Int) = dataBase.gameDao().getPlayersByGameID(gameId)
    suspend fun insertPlayer(player: PlayerDaoEntity) = dataBase.gameDao().insertarJugador(player)
    suspend fun insertGame(game: GameDaoEntity) = dataBase.gameDao().insertarPartida(game)
    suspend fun insertScore(score: ScoreDaoEntity) = dataBase.gameDao().insertarPuntuacion(score)
    suspend fun updateGamesToFinished() = dataBase.gameDao().updateGamesToFinished()
    suspend fun updateGame(game: GameDaoEntity) = dataBase.gameDao().updateGame(game)
    suspend fun updateScore(gameId: Int, playerID: Int, newScore: Int) = dataBase.gameDao().updateScore(gameId, playerID, newScore)
}