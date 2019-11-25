One of the core parts of the Navigation component is the navigation host. The navigation host is an empty container where destinations are swapped in and out as a user navigates through your app.

\
A navigation host must derive from `NavHost`. The Navigation component's default `NavHost` implementation, `NavHostFragment`, handles swapping fragment destinations.


\
Here you will create a host variable inside the `mainActivity.kt` and replace the `activity_base_content` with the `host` created.

\
**Task:** create a NavHost by invoking `create(R.navigation.nav_graph)` method of `NavHostFragment` inside the `onCreate` method of the `MainActivity`. Replace the `base_activity_content` of the `fragmentSupportManager` and invoke `setPrimaryNavigationTarget` to the `host`. The invocation should be surrounded by `begintransaction()` and `commit()` invocations. 


\
You can get more information in [the official documentation](https://developer.android.com/guide/navigation/navigation-getting-started#add-navhost)

<div class="hint">
  Hints can be added anywhere in task text: type "hint" and press Tab.
</div>