Fragments could be used to represent different parts of the user experience. For example, an application can use one fragment to show a list of posts and another fragment to display a post itself. 

\
Each of the fragments has its own set of lifecycle callback methods and handle their own user input events. Thus, instead of using one activity to select a post and another activity to read it, the user can select a post and read it all within the same activity.

\
You should design each fragment as a modular and reusable activity component. One of the good practices would be to avoid directly manipulating one fragment from another fragment. 

\
This is especially important because a modular fragment allows you to change your fragment combinations for different screen sizes. When designing your application to support both tablets and handsets, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. 

Task
---
Complete the ``post_fragment.xml`` by adding the layout parameters. You can look them up at the ``news_fragment.xml``.
Also, ```complete the PostFragment.kt``` as well. For now it should return the same inflated container, as the ```NewsFragment```, but with the ```post_fragment``` layout. We will improve this in the following tasks.

<div class="hint">
  Look at the news_fragment.xml and add the similar android:layout_width and android:layout_height parameters.
</div>