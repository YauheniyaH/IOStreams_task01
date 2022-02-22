package by.epam.com.io.stream.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

	private String path;
	private KeyWordsParser parser;

	public TextFileReader(String path) {
		this.path = path;
	}

	public TextFileReader(String path, KeyWordsParser parser) {
		this.path = path;
		this.parser = parser;
	}

	public KeyWordsParser getParser() {
		return parser;
	}

	public void setParser(KeyWordsParser parser) {
		this.parser = parser;
	}

	public List<String> take() {

		FileReader reader = null;
		// List<Data> result = new ArrayList<Data>();
		List<String> strFromFile = new ArrayList<String>();

		try {
			String line;
			reader = new FileReader(path);
			BufferedReader buff = new BufferedReader(reader);
			while ((line = buff.readLine()) != null) {
				strFromFile.add(line);
			}
			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return strFromFile;

	}

}
