Create your NewsFragment.kt
---------------------------

It is time to create `NewsFragment.kt` file, it will be responsible to show the latests news from the Reddit API and a `RecyclerView` to show the news.

Fragments
---------

Fragment is an entity providing a part of UI in an activity. Multiple fragments could be combined for creating a multi-pane UI. Fragment could be reused in multiple activities. Each of them have separate lifecycles, input events and could be added or removed from the activity in runtime.

To create a `Fragment` you should extend `Fragment` class and override its key methods. The method necessary to run a `Fragment` is `onCreateView()`.


Creating a private field to store the `RecyclerView` locally and assign it when inflating the view leads to this:


```kotlin
private var newsList: RecyclerView? = null

override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    val view = inflater.inflate(R.layout.news_fragment, container, false)
    newsList = view.findViewById(R.id.news_list) as RecyclerView?
    newsList?.setHasFixedSize(true) // use this setting to improve performance
    newsList?.layoutManager = LinearLayoutManager(context)

    return view
}
```      
This is a valid code and works but! it’s not a “Kotlin-ized” code so you are going to make it better. With this small piece of code you are going to incorporate some new concepts about the language:

Extension Functions (Utility class?)
------------------------------------

Extension functions allow you to extend the functionality of a class by adding new functions. The class doesn’t have to belongs to you (could it be a third party library) and also without requiring you to inherit the class.

As you will be able to add new functions to existing classes, e.g. the ViewGroup class. Also you are going to understand how it works and how to consume it from Java.

ViewGroup is a class from the Android SDK and in order to inflate it you have to do this:


```kotlin

inflater.inflate(R.layout.news_fragment, container, false)

```      
But this is not really an intuitive way to do this. This should be something that the `ViewGroup` should be able to do like this:


```kotlin
val view = container?.inflate(R.layout.news_fragment)
```      
It’s like the ViewGroup is able to inflate by itself! But how to do that? Let’s create your first Extention Function:

A file called “Extensions.kt” in the package “commons” was created. Checkout the code to see it.

Here you are going to add a new method to ViewGroup (check out the ViewGroup with a dot before the “inflate” method name) but you are not modifying the ViewGroup class but adding a new function. This function will be internally a static method but you will be calling it from an instance of a class with the dot-notation, in this case: `container.inflate(…)` and not `ViewGroup.inflate()`. This is because the compiler will be creating an `Util` class for you. If you want to use this Extension Function from Java you will be using it in this way:


```kotlin
// Java
ExtensionsKt.inflate(container, R.layout.news_fragment);
// Kotlin
container?.inflate(R.layout.news_fragment)
```      
In the Kotlin world it’s in a more convenient way. Remember adding the “?” mark just because in this example container could be a null object and this prevents getting a NullPointerException.

The name of the Utility class will be the same as the file’s name plus “Kt” suffix or you can override it with an specific annotation:


```kotlin
@file:JvmName("ExtensionsUtils")

package com.edu.keddit.commons

import ...

fun ViewGroup.inflate(layoutId: Int): View {
    ...
}
// Use it in this way in Java:
ExtensionsUtils.inflate(container, R.layout.news_fragment);
```      
More details about interoperability can be [found here](https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html).

Coming back to your function


```kotlin
fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}
```      
Inside the code block it’s like you are writing code as it is a real new method of the class (like a regular method) that’s why you can access to the instance of the class with the “this” keyword and access to the local variable “context”.

Great! This is your first Extension Function and you know a lot more about this concept. Code in the MainActivity was updated in this way:


```kotlin
// old code:
val view = inflater.inflate(R.layout.news_fragment, container, false)
```      
Task:
-----

Complete the return statement of `onCreateView()` method in `NewsFragment.kt` to use an inflate extension function in `Extensions.kt` for returning the value similar to the commented one (`val view`).
<div class='hint'>The method should return result of invocation of inflate method on the container variable, which could be nullable. You should pass R.layout.news_fragment as the parameter to the inflate.</div>
  
