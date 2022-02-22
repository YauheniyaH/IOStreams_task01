package by.epam.com.io.stream.task1;

import java.util.HashMap;
import java.util.Map;

public class KeyWordsCount {
	private Map <String, Integer> map;
	
	
	
	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public KeyWordsCount() {
		this.map=new HashMap<String, Integer>();
		
	}
	
	public KeyWordsCount(Map <String, Integer> c) {
		this.map=c;
		
	}
	
	public void add (String str) {
		this.map.put(str, 0);
	}
	
	public void countInc (String str) {
		int temp;
		temp=this.getMap().get(str);
		temp=temp+1;
		this.getMap().put(str, temp);
	}

}
