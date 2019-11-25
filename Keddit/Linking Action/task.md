To provide the application possibility to perform the action you have created, let's add the listener for it to the `NewsFragment`.

\
You should modify the `OnViewCreated` method, setting the `onClickListener` to the `view` passed as the argument. The listener should find the NAvController of the `Navigation` object and navigate to the action specified in the `nav_graph.xml` (`action_newsFragment_to_postFragment`).



\
**Task:** invoke the `setOnClickListener` of the `view` parameter passed in the `OnViewCreated` method  of the `NewsFragment` and implement the listener to navigate according to the action created in the previous tasks.

<div class="hint">
  Hints can be added anywhere in task text: type "hint" and press Tab.
</div>