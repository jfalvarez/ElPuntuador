package com.jfaf.elpuntuador.ui.screens.newgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jfaf.elpuntuador.model.data.database.GameDaoEntity
import com.jfaf.elpuntuador.model.data.entities.GameState
import com.jfaf.elpuntuador.model.data.entities.Player
import com.jfaf.elpuntuador.model.data.usecases.PuntuadorUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class NewGameViewModel(
    private val puntuadorUseCase: PuntuadorUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(players = puntuadorUseCase.getPlayers())
        }
    }

    fun insertPlayer(name: String) = viewModelScope.launch {
        puntuadorUseCase.insertPlayer(Player(0,name,0,false ))
        _state.value = state.value.copy(players = puntuadorUseCase.getPlayers())
    }

    fun createGame() = viewModelScope.launch {
        puntuadorUseCase.insertGame(GameDaoEntity(
            state = GameState.START.value,
            date = System.currentTimeMillis().toString(),
        ))
        val startedGame = puntuadorUseCase.getStartedGame()
        puntuadorUseCase.createScore(state.value.players.filter { it.isSelected }, startedGame)
        _state.value = state.value.copy(startedGameId = startedGame.id)
    }


    data class UIState(
        val players: List<Player> = emptyList<Player>(),
        val startedGameId: Int = -1
    )
}