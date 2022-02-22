package by.epam.com.io.stream.task1;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Main {

	public static void main(String[] args) {
		Map<String, Integer> mapKeywordsCounter = new HashMap<String,Integer>();
		List<String> strFromFile= new ArrayList<String>();
		String file1="resources/javakeywords.txt";
		String file2="resources/sample.java";
		String file3="resources/result.txt";
	
		SourceReader source =null;
		TextFileReader textReader=null;
		TextFileWriter textWriter=null;
		
		KeyWordsParser parser =new KeyWordsParser();
		
		
		
		source=new SourceReader(file1);
		mapKeywordsCounter=source.readSourceFile();
		KeyWordsCount counter=new KeyWordsCount(mapKeywordsCounter);
		parser.setCounter(counter);
		
		textReader=new TextFileReader(file2);
		strFromFile=textReader.take();
		
		try {
			mapKeywordsCounter=parser.parse(strFromFile);
		} catch (KeyWordsParserException e) {
			
			e.printStackTrace();
		}
		
		textWriter=new TextFileWriter(file3, counter);
		textWriter.save();
		
		Set<String> keySet = mapKeywordsCounter.keySet();
		for (Iterator<String> it = keySet.iterator(); it.hasNext();){
			String key = it.next();
			System.out.println(key + " - " + mapKeywordsCounter.get(key));
		}
		
		System.out.println(mapKeywordsCounter.size());

		
	}

}
