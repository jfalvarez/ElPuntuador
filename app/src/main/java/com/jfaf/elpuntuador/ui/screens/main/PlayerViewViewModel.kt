package com.jfaf.elpuntuador.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfaf.elpuntuador.model.data.entities.Player
import com.jfaf.elpuntuador.model.data.entities.PlayerOnGame
import com.jfaf.elpuntuador.model.data.entities.ScoreDaoEntity
import com.jfaf.elpuntuador.model.data.usecases.PuntuadorUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlayerViewViewModel(
    private val puntuadorUseCase: PuntuadorUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val startedGame = puntuadorUseCase.getStartedGame()
            _state.value = state.value.copy(playerOnGame = puntuadorUseCase.getPlayersByGameId(startedGame.id))
        }
    }

    fun updateScore(newScore: Int, playerID: Int) = viewModelScope.launch {
        puntuadorUseCase.updateScore(state.value.playerOnGame[0].gameId, playerID, newScore)
    }


    data class UIState(
        val playerOnGame: List<PlayerOnGame> = emptyList()
//        val players: List<Player> = emptyList<Player>(),
//        val scores: List<ScoreDaoEntity> = emptyList(),
    )

}