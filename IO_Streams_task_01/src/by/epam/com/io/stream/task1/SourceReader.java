package by.epam.com.io.stream.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SourceReader {
	private String path;

	public SourceReader(String path) {
		this.path = path;
	}
	
	public Map<String, Integer> readSourceFile() {
		Map<String, Integer> mapKeywordsCounter = new HashMap<String,Integer>();
				
		FileReader reader = null;
	
		
		try {
			String line;
			reader = new FileReader(path);
			 BufferedReader buff = new BufferedReader(reader);
			while((line=buff.readLine())!=null) {
				mapKeywordsCounter.put(line,0);
			}
			buff.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return mapKeywordsCounter;
	}

}
