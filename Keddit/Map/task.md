Map
---

Another great function is “map” to transform the items from a list. In this case, you cast a
```kotlin
ViewType
```      
object to a
```kotlin
RedditNewsItem
```      
but you could also create and return new objects.

Lambdas
-------


```kotlin
.map { condition to transform mapped items, use "it" keyword to reffer to the item transformed}
```      
Map is not another think than a function that receives as first parameter a function but Kotlin makes it great, because it allows you to exclude parenthesis and define a code block next to the function name, at the end this code block will be the first parameter required by the function and the code block is the famous Lambda expression, a function that is not declared but passed immediately as an expression

It is good starting point to see this kind of examples on how to use this great features. Later in this tutorial there will be more talk about this.

Task:
-----

Map the items after filtering in the
```kotlin
getNews()
```      
function in NewsAdapter.kt to return a list of
```kotlin
RedditNewItem
```      
.

  
You should map the result as follows
```kotlin
{is as RedditNewsItem}
```      
  
