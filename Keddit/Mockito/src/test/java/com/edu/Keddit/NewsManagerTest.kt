package com.edu.Keddit

import com.edu.Keddit.api.*
import com.edu.Keddit.commons.RedditNews
import com.edu.Keddit.features.news.NewsManager
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import retrofit2.Call
import retrofit2.Response
import rx.observers.TestSubscriber
import java.util.*

/**
 * Unit Tests for NewsManager
 *
 * @author juancho.
 */
class NewsManagerTest {

    //TODO: placeholder
    var testSub = TestSubscriber<RedditNews>()
    var apiMock = mock<NewsAPI>()
    var callMock = mock<Call<RedditNewsResponse>>()


}

//TODO: placeholder
inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)