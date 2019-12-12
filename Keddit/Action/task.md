An action is a logical connection between destinations. Actions are represented in the navigation graph as arrows. Actions usually connect one destination to another, though you can also create global actions that take you to a specific destination from anywhere in your app.

\
In our application we have only two destinations: `NewsFragment` for listing the posts and `PostFragment` for viewing the content of one of them. 

\
Take a look at the `action` field to the `news_fragment` inside the `nav_graph.xml`.
```xml
<action
        android:id="@+id/action_newsFragment_to_postFragment"
        app:destination="@id/postFragment" />
```
\
It contains `id` field, which would be referred to in the application code and `destination` field, which describes the final point of the navigation action.


\
You can read more about actions in the [official documentation](https://developer.android.com/guide/navigation/navigation-getting-started#connect).

\
You can move on to the next task.

