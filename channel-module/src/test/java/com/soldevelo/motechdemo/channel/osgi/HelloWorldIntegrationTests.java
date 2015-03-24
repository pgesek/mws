package com.soldevelo.motechdemo.channel.osgi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * HelloWorld bundle integration tests suite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        HelloWorldWebIT.class
})
public class HelloWorldIntegrationTests {
}
