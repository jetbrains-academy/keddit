As we mentioned in the previous task, an application can use one fragment to show a list of posts and another fragment to display a post itself. 

\
In this task we will create another fragment for this purpose. Take a look at the `post_fragment.xml`:
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >
</RelativeLayout>
```

\
It specifies the type of the layout used in the fragment. `RelativeLayaout` is a very powerful utility for designing a user interface because it can eliminate nested view groups and keep your layout hierarchy flat, which improves performance. Inside the opening tag we also must provide the parameters for width and height of the Layout.

To learn more about the `RelativeLayout`, check out the [official documentation](https://developer.android.com/guide/topics/ui/layout/relative). 

Task
---
Complete the ``PostFragment.kt`` by adding the `return` statement.

<div class="hint">
  Look at the NewsFragment.kt and add the similar retuen statement, but with post_fragment layout.
</div>