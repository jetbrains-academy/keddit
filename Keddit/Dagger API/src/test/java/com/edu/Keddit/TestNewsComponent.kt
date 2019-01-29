package com.edu.Keddit

import com.edu.Keddit.di.AppModule
import com.edu.Keddit.di.NetworkModule
import com.edu.Keddit.di.news.NewsModule
import com.edu.Keddit.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        TestAppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface TestNewsComponent  {

    fun inject(newsFragment: NewsFragment)

    fun injectManager(newsManager: TestNewsManager)

}