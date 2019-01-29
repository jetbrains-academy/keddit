package com.edu.Keddit

import android.app.Application
import com.edu.Keddit.di.AppModule
import com.edu.Keddit.di.news.DaggerNewsComponent
import com.edu.Keddit.di.news.NewsComponent

/**
 *
 * @author juancho.
 */
class KedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }
}