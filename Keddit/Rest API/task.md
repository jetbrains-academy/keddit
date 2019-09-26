Rest API
--------

It is time to move `Retrofit` initialization into a new class called `RestAPI.kt`.

In Kotlin classes you are able to initialize your class in a body block with the `init` keyword. Use it to initialize your `RedditApi`:


```kotlin
private val redditApi: RedditApi

init {
    ...
    }
}
```      
* `init` block: Kotlin class initializer block.
* `.addConverterFactory(MoshiConverterFactory.create())`: setting the `Moshi` converter.
* `RedditApi::class.java`: this syntax allows you to get the Java `Class` instance corresponding to the given `KClass` instance. A `KClass` is an interface that represents a class and provides introspection capabilities.

getNews:
--------

And also a function to consume the API and request the news is provided:


```kotlin
fun getNews(after: String, limit: String): Call<RedditNewsResponse>{
    ...
}
```      
Task:
-----

Complete the initialization block of `RedditApi` and the `getNews` function in `RestAPI.kt` - it should return the result of `getTop` method of the `redditApi` class with `after` and `limit` as the parameters.

  
See the previous task (API interface) for the realisation of the method in the placeholder in `RedditAPi.kt`. Try modifying it according to the API.

<div class='hint'>You should use keyword init in the first placeholder in RestAPI.kt.</div>
<div class='hint'>You should return invocation of getTop method of redditApi with parameters after and limit in the second placeholder in RestAPI.kt.</div>
