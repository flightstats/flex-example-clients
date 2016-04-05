Requirements:
1) Java 8 (uses Java 8 time libraries)
2) Gradle 2.12 (untested with older version)

Getting Started:
* Create JavaClient/src/test/java/com/flightstats/flex/flex.properties, add your appId and appKey. For Example:
appId=this_is_my_app_id
appKey=this_is_my_app_key
* run "gradle clean build"

This will run a basic test query with your credentials. If that works, you're ready to start exploring the other tests.

Explore: 
There are test clients for every API available. However, which tests will work depends on which APIs your
credentials are allowed to access. To run a specific test, comment in the relevant @Test line. For example, in 
FlightStatusClientTest, you can test querying an arriving flight by commenting in the @Test line:
    // @Test
    public void testFlightStatusByArrival() {
        ...
    }

NOTE: Some tests, such as testFlightStatusById(), require a flight history id which must be manually entered in the test. 
The easiest way to find a flightHistoryId is from the output of another query, such as Flight Status By Arrival.


 

