package com.edu.keddit

import com.edu.keddit.api.*
import org.mockito.Mockito
import retrofit2.Call

class NewsManagerTest {

    var apiMock = mock<NewsAPI>()
    var callMock = mock<Call<RedditNewsResponse>>()


}

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)