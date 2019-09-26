Kotlin, RxJava & RxAndroid
--------------------------

Time to talk about RxJava in Kotlin. You are going to take advantages of both by providing a new layer to your App and decoupling your Main UI thread with your background tasks, in this case to request Reddit news from the server. For now the mock data will be OK to emulate a server request.

If this is the first time that you hear about RxJava, you should [read about this software](https://github.com/ReactiveX/RxJava/wiki).


RxJava is the implementation of Reactive Extensions, a library for composing asynchronous and event-based programs by using observable sequences. You should use the `Observable` class to avoid making server requests (or any long process execution) from your Main UI Thread, as such actions could freeze it and disrupt the user's ability to interact with the application.
\
\
You can move on to the nest task.

