package com.edu.keddit

import com.edu.keddit.di.NetworkModule
import com.edu.keddit.di.news.NewsModule
import com.edu.keddit.features.news.NewsFragment
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