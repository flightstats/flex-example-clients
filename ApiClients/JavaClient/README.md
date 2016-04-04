Requirements:
1) Java 8 (uses Java 8 time libraries)
2) Gradle 2.12 (untested with older version)

Getting Started:
* Edit JavaClient/src/test/java/com/flightstats/flex/FlexCredentials.java, add your appId and appKey
* run "gradle clean build"

This will run a basic test query with your credentials. If that works, you're ready to start exploring the other tests.

Explore: 
There are test clients for every API available. However, which tests will work depends on which APIs your
credentials are allowed to access. To run a specific test, comment in the relevant @Test line. For example, in 
FlightStatusClientTest, you can test querying a departing flight by commenting in the @Test line:
    // @Test
    public void testFlightStatusByArrival() {
        ...
    }

NOTE: Some tests, such as testFlightStatusById(), require a flight history id which must be manually entered in the test.


 

