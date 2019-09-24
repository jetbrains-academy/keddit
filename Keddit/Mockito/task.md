Mockito
-------

Let’s talk about Unit Test in Keddit App. It’s a critical part of any app development to have a set of unit tests. So today you are going to add some unit tests to this App, those will be focused on the
```kotlin
NewsManager
```      
class, the one responsible to request, map the Reddit news and key place to be the principal cause of all the mayors problems regarding internet connectivity.

NewsAPI Interface
-----------------

Just to make unit test easier, a new interface for the News API was created so now you just can pass a mock of this interface. There is nothing crazy with this new interface so let’s jump to the next part.

NewsManager Unit Tests
----------------------

The project was configured through
```kotlin
build.gradle
```      
to create your unit tests for the
```kotlin
NewsManager
```      
.

Mockito Dependency
------------------

[Mockito](http://mockito.org/)is an incredible lib to make unit tests really awesome and you can use it in Kotlin!


```kotlin
testImplementation “org.mockito:mockito-core:1.+”
```      
If you try to mock a class that needs a generics definition, like trying to mock the Call<T> class from Retrofit, it will not work. But you can still make it work with a useful Extension Function:


```kotlin
inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)
```      
And you are ready to go!

Task:
-----

Finish the mock declaration in the NewsManagerTest.kt. Mock
```kotlin
NewsAPI
```      
and
```kotlin
Call<RedditNewsResponse>
```      
and pass it to the variable
```kotlin
apiMock
```      
and
```kotlin
callMock
```      
respectively.

You should declare a mock for the
```kotlin
NewsAPI
```      
and
```kotlin
Call<RedditNewsResponse>
```      
using the Extension Function
```kotlin
mock<classname>.
```      
.  
