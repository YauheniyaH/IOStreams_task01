package by.epam.com.io.stream.task1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class TextFileWriter {

	private String path;
	private KeyWordsCount counter;

	public TextFileWriter(String path, KeyWordsCount counter) {
		this.counter = counter;
		this.path = path;
	}

	public boolean save() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(this.path, false);

			Set<String> keySet = counter.getMap().keySet();
			for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
				String key = it.next();
				if (counter.getMap().get(key) != 0) {
					writer.write(key + " - " + counter.getMap().get(key) + "\n");
				}
			}

			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return true;
	}
}
