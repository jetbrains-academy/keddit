Update NewsAdapter to receive News
----------------------------------

Time to modify your NewsAdapter to receive a list of[mocked](https://en.wikipedia.org/wiki/Mock_object)news to be shown with your news and loading delegated adapters:

Range
-----

Kotlin allows you to create in an easy way a range of numbers (Int, Long and Char types) by using an expression like this: “1..10”, this will return an
```kotlin
IntRange
```      
(as we are using Ints in this example),
```kotlin
IntRange
```      
extends from
```kotlin
IntProgression
```      
and this implements
```kotlin
Iterable
```      
. Thanks to this is that we can iterate over the range that we have, in this case from 1 to 10 to create our mock data:


```kotlin
for (i in 1..10) {
    ...
}
```      
You can control the steps in the range and make it decremental like “10 downTo 1”. More about this you can[find it here.](https://kotlinlang.org/docs/reference/ranges.html)

mutableListOf
-------------

This is a Kotlin function which returns a
```kotlin
MutableList
```      
, a list that can be modified and in this case is to store locally the mocked news for the adapter:


```kotlin
val news = mutableListOf<T>()
```      
Task:
-----

Modify
```kotlin
onActivityCreated
```      
function of NewsFragment.kt: declare value news as a mutable list of RedditNewsItem and iterate from 1 to 10 to fill the list up.

  
You should create value news and pass a constructor of the mutable list of
```kotlin
RedditNewsItems
```      
to it.You should iterate over i from 1 to 10.  
