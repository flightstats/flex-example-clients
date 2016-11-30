### Requirements
1. Java 8 (Java 8 specific functionality is used, prior versions will not work)
1. Gradle 2.12 (prior versions may work, but are untested)

### Getting Started
* Create JavaClient/src/test/java/com/flightstats/flex/flex.properties, add your appId and appKey. For example:
```
appId=this_is_my_app_id
appKey=this_is_my_app_key
```
* run "gradle clean build"

This will run a basic test query with your credentials. If that works, you're ready to start exploring the other tests.

### Explore 
There are test clients for nearly every API available. However, the tests are disabled by default since which tests will work depends on which APIs your credentials are allowed to access. To run a specific test, comment in the relevant @Test line. For example, in CurrentFlightStatusClientTest, you can test querying an arriving flight by commenting in the @Test line:

    // @Test
    public void testFlightStatusByArrival() {
        ...
    }

To run that specific test file, at the command line execute the test like so (the name is the test file name minus the "Test" suffix):

```gradle -Dtest.single=CurrentFlightStatusClient test```


#### A note on the com.flightstats.flex.domain objects. 
Not all APIs return the same set of fields for the same item (e.g. Codeshare) and, in some cases, a field name may be 
slightly different. The domain objects declare the superset of all the fields that could be returned from any flex invocation,
which means the object can then be shared by multiple APIs. 

Another option would be generating unique objects from the XSD schemas for each individual API. Either approach works. If you're
using a single API, generating API specific domain objects might be preferable. For this example project that covers many APIs,
it felt clearer to have one comprehensive declaration for each domain object.


