API Model: Kotlin Classes
-------------------------

You need to create some classes in order to convert your Json response into Kotlin classes. If you do this in Java you will end up creating big Java files with getters and setters to do this but as you are using Kotlin you can take advantage of this and represent all these classes really easily.


```kotlin
class RedditNewsResponse(val data: RedditDataResponse)

class RedditDataResponse(
        // Should contain values "children "(List of RedditChildrenResponse), "after" (nullable String) and "before" (also a nullable String).
)

class RedditChildrenResponse(val data: RedditNewsDataResponse)

class RedditNewsDataResponse(
        // Should include values "author" (String), "title" (String), "num_comments" (Int), "created" (Long), "thumbnail" (String), and "url" (also a String).
)
```      
Task:
-----

Complete the model in `ApiModels.kt` in api package according to the comments in the code examples above.

Here is mapping for the previous model reviewed with Kotlin classes and with this 4 classes the model is ready!

  
<div class='hint'>You should pass the value parameter `data` of type `RedditDataResponse` in the first placeholder.</div>
<div class='hint'>You should pass the value parameter `children` in the second placeholder. It is a list of `RedditChildrenResponse`. Also pass the parameters `after` and `before`, having nullable and non-nullable `String` types respectively.</div>
<div class='hint'>Pass all the needed parameters in the third placeholder, divided by commas. Don't forget to state their types.</div>
