An action is a logical connection between destinations. Actions are represented in the navigation graph as arrows. Actions usually connect one destination to another, though you can also create global actions that take you to a specific destination from anywhere in your app.


\
**Task:** Here you should add the `action` field to the `news_fragment` inside the `nav_graph.xml`. It should contain `id` and `destination` fields. The destination field is meant to be the id of the point the action takes you to - in our case it would be the **Post Fragment**.

\
You can read more about actions in the [official documentation](https://developer.android.com/guide/navigation/navigation-getting-started#connect).

