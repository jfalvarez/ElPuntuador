package com.jfaf.elpuntuador.model.data.entities

fun PlayerDaoEntity.asPlayer(): Player = Player(
    id = id,
    name = name,
    score = 0
)