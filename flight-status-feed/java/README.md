# Example Java Client for the Flight Status Feed 

Note that the Flex Flight Status Feed is not part of the general purpose Flex API and is only available to some partners.

The feed provides incremental updates to flight status data via "feed items" - small batches of updates that are usually delivered every several seconds. From a previously fetched item's URI, a client can iterate over the feed data forward or backwards in time to retrieve previous or subsequent items. The iteration pattern is designed to support concurrency, so that the client has control over the data rate when there is a large amount of available data to fetch. Iteration generally begins by finding the URI of the latest feed item, then iterating backwards in time or polling for future items. Return payloads are JSON only.

This module includes two example programs. They are both built atop some lower-level utilities:
* [FetchOneBatch](src/main/java/com/flightstats/flex/flightstatusfeed/client/FetchOneBatch.java) - a feed client that fetches that latest batch of feed items and prints the content to the console
* [FollowFeed](src/main/java/com/flightstats/flex/flightstatusfeed/client/FollowFeed.java) - a feed client that discovers the latest feed item, then polls for subsequent feed items forever, printing the items to the console. This client also contains example concurrent-retrieval logic.

Requirements:
* Java 8
* Gradle (tested with 2.3)

By default gradle builds and runs the FetchOnceBatch example. You can change the default behaviour by editing build.gradle and changing the value of mainClassName from FetchOneBatch to FollowFeed.

* gradle installDist
* build/install/flex-flight-status-feed-client/bin/flex-flight-status-feed-client YOUR_APP_ID YOUR_APP_KEY

