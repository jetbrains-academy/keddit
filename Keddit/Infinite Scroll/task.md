Infinite Scroll
---------------

Let's take advantages of this new concept and create your infinite scroll behaviour.

The `RecyclerView` allows you to set a `Scroll Listener` so this `InfiniteScrollListener` was created and the signature of this class was defined in this way:


```kotlin
class InfiniteScrollListener(
        val func: ...,
        val layoutManager: ...)
                 : RecyclerView.OnScrollListener() {...}
```      
It needs to receive a function parameter that will be invoked every time the user gets to the end of the `RecyclerView` (see line 36 for more details). In fact, it will be called before to reach the end of the list, you can set a threshold that will make your function to be invoked a few items before and in this way you provide a better experience and not making the user to see all the time the loader that more news were requested.

The function that is going to be passed as parameter is a function that requests more news and update the `NewsAdapter` with the new received news:


```kotlin
news_list.addOnScrollListener(
    InfiniteScrollListener({ requestNews() }, linearLayout)
    )
```      

`requestNews()` is a function that you already have in your code, it was updated to use pagination and request the next available news from Reddit.

As you may notice, `requestNews()` is not passed but inside a lambda expression. This is because the compiler will not take it as a function parameter but as a function that needs to be executed and use the return type of this function as the value passed to the `InfiniteScrollListener`. As the return type of `requestNews` is `Unit`, it doesn’t match the `InfiniteScrollListener` parameter expected which is `()->Unit`, so this code will not compile except if you put this into the lambda expression that match perfectly the required parameter.

Task:
-----

Complete the `InfiniteScrollListener` declaration by filling up types for the `func` and `layoutManager` (you should choose the linear one). Check out the res of the code for the scroll listener.

Complete the `OnActivityCreated` method in `NewsFragment.kt` by adding the `InfiniteScrollListener` to the `news_list` with the `requestNews` and `linearLayout` as the parameters.

  
<div class='hint'>You should declare a lambda function taking no parameters () and returning Unit in the first placeholder in InfiniteScrollListener.kt.</div>
<div class='hint'>The variable in the second placeholder in InfiniteScrollListener.kt should has type LinearLayoutManager.</div>
<div class='hint'>You should pass an InfiniteScrollListener constructor in the placeholder in NewsFragment with { requestNews() } and linearLayout as the parameters.</div>
