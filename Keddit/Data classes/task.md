News Item with Data Classes
---------------------------

While creating your News delegate adapter and configuring the `NewsAdapter` to receive a list of news, you need your UI object to represent each news. In Java it is normally to create a class like this:


```kotlin
public class RedditNewsItem {

    private String author;
    private String title;

    public MyNews(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
```      
Again, Kotlin has come to help you with a class type called “data class” which brings you a lot of benefits and for the same example it looks like this:


```kotlin
data class RedditNewsItem(var author: String, var title: String)
```      
With this simple line you are doing the same as the previous Java code, it means that author and title has their own getters and setters and it requires a constructor with this two elements. But you still receive more benefits: if you take this data class, you receive for free:

* `equals/hashCode` pair.
* `toString()` with all the properties included.
* `copy()` method to make easily a copy of your object.
* other useful methods, you can see more in the [official page.](https://kotlinlang.org/docs/reference/data-classes.html)

Task:
-----

Complete a data class declaration for RedditNewsItem in the Models.kt. It should has following properties to use in your NewsAdapter: author (String), title (String), numComments(int), created (Long), thumbnail (String), url (String).

  
<div class='hint'>You should add the data keyword to implement the data class.</div>
<div class='hint'>List the parameters like this: val first_parameter_name: parameter type, val second_parameter_name: parameter type.</div>
