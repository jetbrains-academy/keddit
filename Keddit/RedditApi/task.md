Reddit API
----------

Let’s review a little bit the API that we are going to consume from Reddit. The idea is to request the Reddit’s TOP news to be shown in the App.

Request URL
-----------

The URL that we are going to consume is the following:


```kotlin
www.reddit.com/top.json?limit=10
```      
JSON Response
-------------

As you can see the returned response is in JSON format. A better way to analyse the content is using a Json parser like Json Editor Online (http://www.jsoneditoronline.org/) which is an excellent online tool.

Here there are 3 things that we will care about it:

* children: Is the news’ list paginated by 10 items (as we requested in the query string) and each children has details about the news (name, image, author, etc).
* after: It allows you to perform pagination with this Reddit API. “after” will bring you the next 10 items by calling: “/top.json?after=t3\_4cdt7v”.
* before: The same as “after” but to navigate back.
\
\
You can move onto the next task.

