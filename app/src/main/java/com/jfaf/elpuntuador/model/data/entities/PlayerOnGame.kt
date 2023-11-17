package com.jfaf.elpuntuador.model.data.entities

data class PlayerOnGame (
    val playerId: Int,
    val gameId: Int,
    val name: String,
    val thumbnail: String,
    val score: Int
)