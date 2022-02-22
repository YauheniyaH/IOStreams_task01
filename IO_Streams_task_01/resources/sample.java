package by.epam.com.read.write.file.calc.updated;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberReader {
	
	private String path;
	private NumberParser parser;
	
	public NumberReader(String path) {
		this.path = path;
	}
	
	public NumberReader(String path, NumberParser parser) {
		this.path = path;
		this.parser = parser;
	}
	
	public NumberParser getParser() {
		return parser;
	}

	public void setParser(NumberParser parser) {
		this.parser = parser;
	}

	public List<Data> take() throws NumberParserException {
		
		FileReader reader = null;
		List<Data> result = new ArrayList<Data>();
		List<String> strFromFile = new ArrayList<String>();
		
		try {
			String line;
			reader = new FileReader(path);
			 BufferedReader buff = new BufferedReader(reader);
			while((line=buff.readLine())!=null) {
				strFromFile.add(line);
			}
			buff.close();
			
			
			// read strings
			Data newData = parser.parse(strFromFile.get(0).toString());
			
			for (int i=0; i<strFromFile.size();i++) {
				newData = parser.parse(strFromFile.get(i));
				result.add(newData);
			}
			
		
	
			throw new NumberParserException(e);
		}catch(DataParserException e) {
			throw new NumberParserException(e);
		}/*finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new NumberParserException(e);
				}
			}		
		}*/	
		
		
		return result;
		
	}
	
}
