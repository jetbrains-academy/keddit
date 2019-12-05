Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer. The Navigation component also ensures a consistent and predictable user experience by adhering to an established set of principles.

\
The Navigation component consists of three key parts that are described below:
* Navigation graph: An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called destinations, as well as the possible paths that a user can take through your app.
* `NavHost`: An empty container that displays destinations from your navigation graph. The Navigation component contains a default NavHost implementation, NavHostFragment, that displays fragment destinations.
* `NavController`: An object that manages app navigation within a `NavHost`. The `NavController` orchestrates the swapping of destination content in the NavHost as users move throughout your app.


\
**Task:** check out the `nav_graph.xml` file and fill up the placeholder with a path to the `PostFragment.kt` in the app hierarchy.

\
[Navigation Overview](https://developer.android.com/guide/navigation?gclid=CjwKCAiAws7uBRAkEiwAMlbZjgmzNWcCEEkAlXO58gcoejHiLU8WHu9lktt6IJ3nZDbI56C3mZ8rSBoCoEIQAvD_BwE)
