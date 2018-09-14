package com.edu.Keddit.di

import android.content.Context
import com.edu.Keddit.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 *
 * @author juancho.
 */
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