package com.example.challengechap7.di.myapp

import android.app.Application
import com.example.challengechap7.BuildConfig
import com.example.challengechap7.di.module.NetworkModule
import com.example.challengechap7.di.module.RemoteMovieModule
import com.example.challengechap7.di.subcomponent.*
import com.example.challengechap7.di.viewmodel_module.AppModule

class MyApplication : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule(BuildConfig.BASE_URL))
            .remoteMovieModule(RemoteMovieModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createDetailSubComponent(): DetailSubComponent {
        return appComponent.detailSubComponent().create()
    }

    override fun createFavoriteSubComponent(): FavoriteSubComponent {
        return appComponent.favoriteSubComponent().create()
    }

    override fun createHomeSubComponent(): HomeSubComponent {
        return appComponent.homeSubComponent().create()
    }

    override fun createLoginSubComponent(): LoginSubComponent {
        return appComponent.loginSubComponent().create()
    }

    override fun createRegisterSubComponent(): RegisterSubComponent {
        return appComponent.registerSubComponent().create()
    }

    override fun createUpdateSubComponent(): UpdateSubComponent {
        return appComponent.updateSubComponent().create()
    }
}