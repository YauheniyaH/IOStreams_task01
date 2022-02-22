package by.epam.com.io.stream.task1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyWordsParser {
	private KeyWordsCount counter;
	
	

	public KeyWordsCount getCounter() {
		return counter;
	}



	public void setCounter(KeyWordsCount counter) {
		this.counter = counter;
	}



	public Map<String, Integer> parse(List<String> list) throws KeyWordsParserException{
		Map<String, Integer> keyWords = new HashMap<String, Integer>();
		keyWords = counter.getMap();

		Set<String> keySet = keyWords.keySet();
		for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
			String key = it.next();
			for (String str : list) {
				

				Pattern pattern = Pattern.compile(key);
				Matcher matcher = pattern.matcher(str);
				if (matcher.find()) {
					counter.countInc(key);
				}

			}

		}

		return counter.getMap();

	}

}
