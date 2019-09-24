NewsManager: Call the Api!
--------------------------

You need to use default parameters to initialize your RestApi class


```kotlin
class NewsManager(private val api: RestAPI ...) {
     ...
}
```      
Also take a look at the
```kotlin
Observable
```      
definition update to call this Api and perform the request:


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
1. 
```kotlin
callResponse.execute()
```      
: This will execute the request synchronously.
3. 
```kotlin
response.body().data.children.map {…}
```      
: Here you use the List function “map” to transform every children into a RedditNewsItem.
5. 
```kotlin
it.data
```      
: “it” is a short way to access a single parameter from the lambda expression. This is only valid when you receive just one parameter, otherwise for more parameters you have to specify it, for example with two parameters it looks like this “x, y -> …”.
7. 
```kotlin
subscriber.onError()
```      
: a new
```kotlin
Throwable
```      
object is created with the
```kotlin
response.message()
```      
that we receive from the service.
Task:
-----

Complete
```kotlin
NewsManager
```      
declaration by passing the
```kotlin
RestApi()
```      
constructor as the default value for the api parameter

With this last changes you are now showing the first 10 news from Reddit in your app

  
You should pass a private value
```kotlin
api
```      
as a parameter. It should have type
```kotlin
RestAPI
```      
and the default value
```kotlin
RestAPI()
```      
  
