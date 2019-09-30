NewsManager: Call the Api!
--------------------------

You need to use default parameters to initialize your RestApi class


```kotlin
class NewsManager(private val api: RestAPI ...) {
     ...
}
```      
Also take a look at the `Observable` definition update to call this Api and perform the request:


```kotlin
subscriber ->
val callResponse = api.getNews("", limit)
val response = callResponse.execute()

if (response.isSuccessful) {
    val news = response.body().data.children.map {
        val item = it.data
        RedditNewsItem(item.author, item.title, item.num_comments,
                item.created, item.thumbnail, item.url)
    }
    subscriber.onNext(news)
    subscriber.onCompleted()
} else {
    subscriber.onError(Throwable(response.message()))
}
```      
* `callResponse.execute()`: this will execute the request synchronously.
* `response.body().data.children.map {…}`: here you use the `List` function `map` to transform every child into a `RedditNewsItem`.
* `it.data`: `it` is a short way to access a single parameter from the lambda expression. This is only valid when you receive just one parameter, otherwise for more parameters you have to specify it, for example with two parameters it looks like this “x, y -> …”.
* `subscriber.onError()`: a new `Throwable` object is created with the `response.message()` that we receive from the service.

Task:
-----

Complete `NewsManager` declaration by passing the `RestApi()` constructor as the default value for the api parameter.

With this last changes you are now showing the first 10 news from Reddit in your app

  
<div class='hint'>You should pass a private value api as a parameter. It should have type RestAPI and the default value RestAPI().</div>
