package com.edu.Keddit.di.news


import com.edu.Keddit.di.AppModule
import com.edu.Keddit.di.NetworkModule
import com.edu.Keddit.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 *
 * @author juancho.
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}