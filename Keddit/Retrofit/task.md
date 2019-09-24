Retrofit
--------


> Is a type-safe HTTP client for Android and JavaRetrofit is an incredible easy to use library that turns your HTTP API into a Java (Kotlin) interface. You are going to use it to consume the Reddit API.

Dependency
----------

To use it, you need to add the Retrofit dependency into the
```kotlin
build.gradle
```      
(already done in this task):


```kotlin
implementation "com.squareup.retrofit2:retrofit:2.0.0"
```      
JSON Converter
--------------

Also you need to indicate to Retrofit which converter it should use to convert a JSON response into a Java (Kotlin) class, Moshi will be used here as it has better performance than Gson:


```kotlin
implementation "com.squareup.retrofit2:converter-moshi:2.0.0"
```      
[Here you have a great video from Jake Warthon](https://www.youtube.com/watch?v=WvyScM_S88c)explaining about Moshi and why Moshi works better than others with Retrofit.

In summary, Moshi knows about Okio and its API, so it takes advantages of Okio buffers and read and write content directly into this buffer without requiring it to allocate extra memory for this process (to convert the response data stream into Java code and viceversa). In same way, Moshi is like a higher level API of Okio API so you are in fact just adding a simpler API on top of Okio.

  
