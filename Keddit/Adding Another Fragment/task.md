Fragments could be used to provide different representations for separated parts of the user experience. For example, an application can use one fragment to show a list of posts and another fragment to display a post itself. Each fragment has its own set of lifecycle callback methods and handle their own user input events. Thus, instead of using one activity to select an article and another activity to read the article, the user can select an article and read it all within the same activity.

You should design each fragment as a modular and reusable activity component. That is, because each fragment defines its own layout and its own behavior with its own lifecycle callbacks, you can include one fragment in multiple activities, so you should design for reuse and avoid directly manipulating one fragment from another fragment. This is especially important because a modular fragment allows you to change your fragment combinations for different screen sizes. When designing your application to support both tablets and handsets, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. For example, on a handset, it might be necessary to separate fragments to provide a single-pane UI when more than one cannot fit within the same activity.

Task
---
Complete the ``post_fragment.xml`` by adding the layout parameters. You can look them up at the ``news_fragment.xml``.

<div class="hint">
  Look at the news_fragment.xml and add the similar android:layout_width and android:layout_height parameters.
</div>