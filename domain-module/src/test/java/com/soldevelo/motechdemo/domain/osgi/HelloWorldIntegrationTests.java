package com.soldevelo.motechdemo.domain.osgi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * HelloWorld bundle integration tests suite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloWorldRecordServiceIT.class
})
public class HelloWorldIntegrationTests {
}
