package com.jfaf.elpuntuador

import android.app.Application
import androidx.room.Room
import com.jfaf.elpuntuador.model.data.database.PuntuadorDataBase
import com.jfaf.elpuntuador.model.data.repositories.PuntuadorRepository
import com.jfaf.elpuntuador.model.data.usecases.PuntuadorUseCase
import com.jfaf.elpuntuador.ui.screens.main.PlayerViewViewModel
import com.jfaf.elpuntuador.ui.screens.newgame.NewGameViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

fun Application.initDi() {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initDi)
        modules(appModule/*, dataModule, useCaseModule*/)
    }
}

private val appModule = module{
    single {
        Room.databaseBuilder(
            get(),
            PuntuadorDataBase::class.java,
            "puntuador.db"
        ).build()
    }
    single { get<PuntuadorDataBase>().gameDao() }
    factory { PuntuadorRepository(get()) }
    factory { PuntuadorUseCase(get()) }

    viewModel { NewGameViewModel(get()) }
    viewModel { PlayerViewViewModel(get()) }
}

/*
private val dataModule = module{

}

private val useCaseModule = module{

}*/
