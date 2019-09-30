Default Values in Parameters
----------------------------

In Kotlin you are able to define default values in the parameters of a function (also in a class constructor). So you are going to add a default value for the `attachToRoot` parameter.


```kotlin
attachToRoot: Boolean = false
```      
In case you don’t specify the attachToRoot parameter it will take the default value, so you can call it in different ways:


```kotlin
container?.inflate(R.layout.news_fragment) // default: false
container?.inflate(R.layout.news_fragment, true)
```      
Task:
-----

Checkout the default value for the `attachToRoot` parameter in Extensions.kt, move on to the next task.

