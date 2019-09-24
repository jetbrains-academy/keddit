Testing Observables with TestSubscriber
---------------------------------------

A simple way to test your observables is by using the
```kotlin
TestSubscriber
```      
class provided by
```kotlin
RxJava
```      
. It allows you to run an
```kotlin
Observable
```      
and make some assertions:


```kotlin
var testSub = TestSubscriber...
newsManager.getNews("").subscribe(testSub)
testSub.assertNoErrors()
testSub.assertValueCount(1)
testSub.assertCompleted()
```      
A complete example of one unit test is like this:


```kotlin
@Test
fun testSuccess_basic() {
    // prepare
    val redditNewsResponse = RedditNewsResponse(RedditDataResponse(listOf(), null, null))
    val response = Response.success(redditNewsResponse)

    `when`(callMock.execute()).thenReturn(response)

    // call
    val newsManager = NewsManager(apiMock)
    newsManager.getNews("").subscribe(testSub)

    // assert
    testSub.assertNoErrors()
    testSub.assertValueCount(1)
    testSub.assertCompleted()
}
```      
Task:
-----

Complete the testSub variable declaration by passing RedditNews observable into it. Checkout and run the unit tests. Try to modify them.

You should declare a
```kotlin
TestSubscriber
```      
and pass
```kotlin
RedditNews
```      
as a type to it.  
