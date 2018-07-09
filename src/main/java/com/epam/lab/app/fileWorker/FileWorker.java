package com.epam.lab.app.fileWorker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileWorker {
	private static final Logger logger = LogManager.getLogger(FileWorker.class);
	private FileReader reader;

	public FileWorker() {
		reader = null;
	}

	public void createFIle(String fileName) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("src/main/resources/" + fileName, "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void openFile(String filePath) {
		try {
			reader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			logger.info(e.getMessage());
		}
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileReader getReader() {
		return reader;
	}
}
