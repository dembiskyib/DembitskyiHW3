package com.epam.lab.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.epam.lab.app.fileWorker.FileWorker;

public class Task3_5 {
	private Properties properties;
	{
		properties = new Properties();
		try {
			properties.load(new FileInputStream(
					Task3_5.class.getClassLoader().getResource("config.properties").getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Rule
	public final TestWatcherFailLogger testWatcherFailLogger = new TestWatcherFailLogger();
	private static FileWorker fileWorker;

	@BeforeClass
	public static void init() {
		fileWorker = new FileWorker();
	}

	@Test
	public void testFileCreation() throws IOException {
		fileWorker.createFIle(properties.getProperty("fileNameCreate"));
		File f = new File(properties.getProperty("fileFolderPath") + properties.getProperty("fileNameCreate"));
		assertTrue(f.exists());
	}

	@Test
	public void testFileReadingFileExists() throws IOException {
		fileWorker.openFile(properties.getProperty("fileFolderPath") + properties.getProperty("fileNameCreate"));
		assertNotNull(fileWorker.getReader());
	}

	@Test
	public void testFileReadingFileNotExists() throws IOException {
		fileWorker.openFile(properties.getProperty("fileFolderPath") + properties.getProperty("fileNameRead"));
		assertNotNull(fileWorker.getReader());
	}

	@AfterClass
	public static void close() {
		fileWorker.close();
	}

}
