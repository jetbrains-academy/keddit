API Interface
-------------

A Kotlin file called RedditApi was created and it looks like this:


```kotlin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
interface  RedditApi {
    ...
    : Call<RedditNewsResponse>;
}
```      
You should define here a synchronous API that will receive the “after” and “limit” query string. The return type is `Call<RedditNewsResponse>`, this `Call` class will allow you to execute the request and know if the request was successful or not, also to extract the response data with the given generic type, in this case, the new defined Kotlin class `RedditNewsResponse`.

Task:
-----

Complete the interface in `RedditApi.kt` by providing `String` values for `after` and `limit`.

  
<div class='hint'>Insert the name of `after` query parameter in the first placeholder. Do not forget the quotes.</div>
<div class='hint'>Insert the name of `before` query parameter in the second placeholder. Do not forget the quotes.</div>
