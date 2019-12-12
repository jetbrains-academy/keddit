Fragments could be used to represent different parts of the user experience. For example, an application can use one fragment to show a list of posts and another fragment to display a post itself. 

\
Each of the fragments has its own set of lifecycle callback methods and handle their own user input events. Thus, instead of using one activity to select a post and another activity to read it, the user can select a post and read it all within the same activity.

\
You should design each fragment as a modular and reusable activity component. One of the good practices would be to avoid directly manipulating one fragment from another fragment. 

\
This is especially important because a modular fragment allows you to change your fragment combinations for different screen sizes. When designing your application to support both tablets and handsets, you can reuse your fragments in different layout configurations to optimize the user experience based on the available screen space. 

Task
---
Complete the ``PostFragment.kt`` by adding the `return` statement.

<div class="hint">
  Look at the NewsFragment.kt and add the similar retuen statement, but with post_fragment layout.
</div>