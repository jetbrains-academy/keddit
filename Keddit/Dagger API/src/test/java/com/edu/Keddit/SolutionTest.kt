package com.edu.Keddit

import com.edu.Keddit.api.RedditApi
import com.edu.Keddit.di.AppModule
import com.edu.Keddit.di.NetworkModule
import com.edu.Keddit.di.news.DaggerNewsComponent
import com.edu.Keddit.di.news.NewsComponent
import com.edu.Keddit.di.news.NewsModule
import com.edu.Keddit.features.news.NewsFragment
import com.edu.Keddit.features.news.NewsManager
import dagger.Component
import dagger.Module
import dagger.Provides
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import javax.inject.Singleton

class SolutionTest {
    var testKedditApp: TestKedditApp? = null
    var newsFragment: NewsFragment? = null

    @Before
    fun setup() {
        testKedditApp = TestKedditApp()
        newsFragment = NewsFragment()
    }

    /*Checking if NewsComponent is Provided by dagger builder*/
    @Test
    fun testNewsComponentIsNotNull() {
        var actualResult = DaggerNewsComponent.builder().build()
        Assert.assertNotNull("Check out the implementation of NewsComponent", actualResult)
    }

    /*Checking if NewsComponent has @Singleton annotation*/
    @Test
    fun testNewsComponentIsSingleton() {
        var actualResult = NewsComponent::class.java.getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that NewsComponent is annotated with \"@Singleton\"", actualResult)
    }

    /*Checking if NewsComponent has @Component annotation*/
    @Test
    fun testNewsComponentIsComponent() {
        var actualResult = NewsComponent::class.java.getAnnotation(Component::class.java)
        Assert.assertNotNull("Check out that NewsComponent is annotated with \"@Component\"", actualResult)
    }

    /*Checking if NewsManager is injected inside NewsFragment*/
    @Test
    fun testNewsManagerInjectsToNewsFragment() {
        testKedditApp!!.initTestComponent()
        testKedditApp!!.getTestNewsComponent().inject(newsFragment!!)
        var actualResult = newsFragment!!.newsManager
        Assert.assertNotNull("Check out that NewsManager injects into NewsFragment", actualResult)
    }

    /*Checking NewsModule for @Singleton annotation*/
    @Test
    fun testNewsManagerIsSingleton() {
        var actualResult = NewsManager::class.java.getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that NewsManager is annotated with \"@Singleton\"", actualResult)
    }

    /*Checking NewsModule for @Module annotation*/
    @Test
    fun testNewsModuleIsModule() {
        var actualResult = NewsModule::class.java.getAnnotation(Module::class.java)
        Assert.assertNotNull("Check out that NewsModule is annotated with \"@Module\"", actualResult)
    }

    /*Checking NewsModule's provideNewsAPi() for @Provides annotation*/
    @Test
    fun testNewsModuleProvideNewsAPIProvides() {
        var actualResult = NewsModule::class.java.getDeclaredMethod("provideNewsAPI", RedditApi::class.java).getAnnotation(Provides::class.java)
        Assert.assertNotNull("Check out that NewsModule's method provideNewsAPI() is annotated with \"@Provides\"", actualResult)
    }

    /*Checking NewsModule's provideNewsAPi() for @Singleton annotation*/
    @Test
    fun testNewsModuleProvideNewsAPISingleton() {
        var actualResult = NewsModule::class.java.getDeclaredMethod("provideNewsAPI", RedditApi::class.java).getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that NewsModule's method provideNewsAPI() is annotated with \"Singleton\"", actualResult)
    }

    /*Checking NewsModule's provideRedditAPi() for @Provides annotation*/
    @Test
    fun testNewsModuleProvideRedditAPIProvides() {
        var actualResult = NewsModule::class.java.getDeclaredMethod("provideRedditApi", Retrofit::class.java).getAnnotation(Provides::class.java)
        Assert.assertNotNull("Check out that NewsModule's method provideRedditApi() is annotated with \"@Provides\"", actualResult)
    }

    /*Checking NewsModule's provideRedditAPi() for @Singleton annotation*/
    @Test
    fun testNewsModuleProvideRedditAPISingleton() {
        var actualResult = NewsModule::class.java.getDeclaredMethod("provideRedditApi", Retrofit::class.java).getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that NewsModule's method provideRedditApi() is annotated with \"@Singleton\"", actualResult)
    }

    /*Checking NewsModule's provides api into the NewsManager constructor*/
    @Test
    fun testNewsModuleProvidesApi() {
        var testNewsManager = TestNewsManager()
        testKedditApp!!.initTestComponent()
        testKedditApp!!.getTestNewsComponent().injectManager(testNewsManager)
        var actualResult = testNewsManager.returnApi()
        Assert.assertNotNull("Checkout that constructor of NewsManager is injected with an api", actualResult)
    }

    /*Checking that NewsModule provides Singleton API*/
    @Test
    fun testNewsModuleProvidesSingletonApi() {
        var testNewsManager = TestNewsManager()
        var otherTestNewsManager = TestNewsManager()
        testKedditApp!!.initTestComponent()

        testKedditApp!!.getTestNewsComponent().injectManager(otherTestNewsManager)
        var expectedResult = otherTestNewsManager.returnApi()

        testKedditApp!!.getTestNewsComponent().injectManager(testNewsManager)
        var actualResult = testNewsManager.returnApi()

        Assert.assertEquals("Checkout the NewsModule implementation", expectedResult, actualResult)
    }

    /*Checking AppModule's provideApplication() for @Provides annotation*/
    @Test
    fun testAppModuleProvideContextProvides() {
        var actualResult = AppModule::class.java.getDeclaredMethod("provideContext").getAnnotation(Provides::class.java)
        Assert.assertNotNull("Check out that AppModule's method provideContext() is annotated with \"@Provides\"", actualResult)
    }

    /*Checking AppModule's provideApplication() for @Provides annotation*/
    @Test
    fun testAppModuleProvideContextSingleton() {
        var actualResult = AppModule::class.java.getDeclaredMethod("provideContext").getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that AppModule's method provideContext() is annotated with \"@Singleton\"", actualResult)
    }

    /*Checking AppModule's provideApplication() for @Provides annotation*/
    @Test
    fun testAppModuleProvideApplicationProvides() {
        var actualResult = AppModule::class.java.getDeclaredMethod("provideApplication").getAnnotation(Provides::class.java)
        Assert.assertNotNull("Check out that AppModule's method provideApplication() is annotated with \"@Provides\"", actualResult)
    }

    /*Checking AppModule's provideApplication() for @Singleton annotation*/
    @Test
    fun testAppModuleProvideApplicationSingleton() {
        var actualResult = AppModule::class.java.getDeclaredMethod("provideApplication").getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that AppModule's method provideApplication() is annotated with \"@Singleton\"", actualResult)
    }

    /*Checking NetworkModule's provideRetrofit() for @Provides annotation*/
    @Test
    fun testNetworkModuleProvideRetrofitProvides() {
        var actualResult = NetworkModule::class.java.getDeclaredMethod("provideRetrofit").getAnnotation(Provides::class.java)
        Assert.assertNotNull("Check out that NetworkModule's method provideRetrofit() is annotated with \"@Provides\"", actualResult)
    }

    /*Checking NetworkModule's provideRetrofit() for @Singleton annotation*/
    @Test
    fun testNetworkModuleProvideRetrofitSingleton() {
        var actualResult = NetworkModule::class.java.getDeclaredMethod("provideRetrofit").getAnnotation(Singleton::class.java)
        Assert.assertNotNull("Check out that NetworkModule's method provideRetrofit() is annotated with \"@Singleton\"", actualResult)
    }

}




