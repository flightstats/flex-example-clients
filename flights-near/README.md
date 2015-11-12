
This is an example of how to use the Flights Near API for a coordinate space (ie "Big Box") larger than what the API allows.

There are three test programs:
* BigBoxSimpleMain - fetches the coordinate space and prints the responses to stdout
* BigBoxPerfTestMain - fetches the coordinate space with varying degrees of concurrency and prints the results
* BigBoxOnceEvery20sMain - tries to fetch the coordinate space once every 20 seconds, to show the benefit of HTTPS Keep-Alive


To run the examples:
* Install Java 8 and Gradle
* edit build.gradle to enter your Flex credentials and choose a test
* execute: gradle run
