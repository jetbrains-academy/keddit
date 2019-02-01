package com.edu.keddit.di

import android.content.Context
import com.edu.keddit.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: KedditApp) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app;
    }
    @Provides
    @Singleton
    fun provideApplication(): KedditApp {
        return app;
    }
}