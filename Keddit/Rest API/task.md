Rest API
--------

It is time to move Retrofit initialization into a new class called “
```kotlin
RestAPI.kt
```      
”.

In Kotlin classes you are able to initialize your class in a body block with the init keyword. Use it to initialize your RedditApi:


```kotlin
private val redditApi: RedditApi

init {
    ...
    }
}
```      
1. 
```kotlin
init
```      
block: Kotlin class initializer block.
3. “
```kotlin
.addConverterFactory(MoshiConverterFactory.create())
```      
”: Setting the Moshi converter.
5. “
```kotlin
RedditApi::class.java
```      
”: This syntax allows you to get the Java Class instance corresponding to the given KClass instance. A KClass is an interface that represents a class and provides introspection capabilities.
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

Complete the initialization block of
```kotlin
RedditApi
```      
and the
```kotlin
getNews
```      
function in
```kotlin
RestAPI.kt
```      
- it should return the result of
```kotlin
getTop
```      
method of the
```kotlin
redditApi
```      
class with
```kotlin
after
```      
and
```kotlin
limit
```      
as the parameters.

  
See the previous task (API interface) for the realisation of the method in the placeholder in RedditAPi.kt. Try modifying it according to the API.You should use keyword
```kotlin
init
```      
in the first placeholder in RestAPI.kt.You should return invocation of
```kotlin
getTop
```      
method of
```kotlin
redditApi
```      
with parameters
```kotlin
after
```      
and
```kotlin
limit
```      
in the second placeholder in RestAPI.kt.  
