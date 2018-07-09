package com.epam.lab.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestWatcherFailLogger extends TestWatcher {
	private static final Logger logger = LogManager.getLogger(TestWatcherFailLogger.class);

	@Override
	protected void failed(Throwable e, Description description) {
		logger.error(description + " error");
	}
}
