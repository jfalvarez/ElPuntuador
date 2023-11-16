package com.jfaf.elpuntuador.model.data.usecases

import com.jfaf.elpuntuador.model.data.database.GameDaoEntity
import com.jfaf.elpuntuador.model.data.entities.Player
import com.jfaf.elpuntuador.model.data.entities.PlayerOnGame
import com.jfaf.elpuntuador.model.data.entities.ScoreDaoEntity
import com.jfaf.elpuntuador.model.data.entities.asPlayer
import com.jfaf.elpuntuador.model.data.repositories.PuntuadorRepository

class PuntuadorUseCase(
    private val repository: PuntuadorRepository
) {

    suspend fun getPlayers() = repository.getPlayers().map { it.asPlayer() }
    suspend fun getGames() = repository.getGames()
    suspend fun getStartedGame() = repository.getStartedGame()
    suspend fun insertPlayer(player: Player) = repository.insertPlayer(player.toEntity())
    suspend fun insertGame(game: GameDaoEntity){
        repository.updateGamesToFinished()
        repository.insertGame(game)
    }

    suspend fun createScore(selectedPlayers: List<Player>, startedGame: GameDaoEntity) {//= repository.insertScore(score)
        selectedPlayers.forEach{
            repository.insertScore(ScoreDaoEntity(
                gameID = startedGame.id,
                playerID = it.id,
                score = 0
            ))
        }

    }
    suspend fun getScoreByGameId(gameId: Int) = repository.getScoreByGameId(gameId)
    suspend fun getPlayersByGameId(gameId: Int) = repository.getPlayersbyGameId(gameId)
    suspend fun updateGame(game: GameDaoEntity) = repository.updateGame(game)
    suspend fun updateScore(gameID: Int, playerID: Int, newScore: Int) = repository.updateScore(gameID, playerID, newScore)

}