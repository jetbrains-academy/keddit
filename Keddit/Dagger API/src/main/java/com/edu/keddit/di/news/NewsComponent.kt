package com.edu.keddit.di.news


import com.edu.keddit.di.AppModule
import com.edu.keddit.di.NetworkModule
import com.edu.keddit.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}