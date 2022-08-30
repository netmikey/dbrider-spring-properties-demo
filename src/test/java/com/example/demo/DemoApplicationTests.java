package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;

@SpringBootTest
// Use a test properties file to configure the spring context, this is only one
// of several ways to get properties into the Spring Context.
@TestPropertySource(locations = "classpath:test-application.properties")
// Initialize DB Rider and an example dataset
@DBRider
@DataSet("datasets/my-dataset.xml")
class DemoApplicationTests {

	/**
	 * Read the value from the Spring Context to make sure Spring loads it
	 * correctly. It is echoed in the `contextLoads` test.
	 */
	@Value("${my-case-insensitive-strategy}")
	private String strategy;

	/**
	 * This will load the Spring Context, start up HSQLDB, initialize a schema using
	 * FlywayDB and finally let DBRider try to insert the DataSet configured by the
	 * Class-Level annotation.
	 * <p>
	 * This will fail out of the box. See <code>dbunit.yml</code>.
	 */
	@Test
	void contextLoads() {
		System.out.println("${my-case-insensitive-strategy} is: " + strategy);
	}

}
