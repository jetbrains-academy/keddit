Lists Functions & Lambdas
-------------------------

A method that will be used later to save the news when the app is in the middle of an Orientation Change event was created to show you how easy is to work with list to filter and map (transform) every item from a list to another one.

In your code you have a method called “getNews” which returns a List of RedditNewsItems. In order to filter and transform our items (a list of ViewType) you are going to do this:


```kotlin
fun getNews(): List<RedditNewsItem> {
    return items
            .filter { condition for list elements to include, refer to an item using keyword "it"}
            .map { condition for list elements to map, refer to an item using keyword "it" }
}
```      
Filter
------

Every list has some useful functions like “filter”, in this case, which allow us to iterate a list and filter (exclude) items that don’t apply certain condition. In our items list we have
```kotlin
ViewTypes
```      
so we could have News items or Loading items, with this filter function we make sure to return only those that are News items.

Task:
-----

Modify the
```kotlin
getNews
```      
function in
```kotlin
NewsAdapter.kt
```      
to filter items which
```kotlin
getViewType()
```      
method returns to be the same value as "AdapterConstants.NEWS"

  
You should filter the list using the condition
```kotlin
it.getViewType() == AdapterConstants.NEWS
```      
  