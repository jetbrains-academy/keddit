package com.edu.keddit

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestAppModule(val app: TestKedditApp) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
    @Provides
    @Singleton
    fun provideApplication(): TestKedditApp {
        return app
    }
}