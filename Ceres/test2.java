import java.util.*;
public class test2 {
	public static void main(String[] args) {
		//create hash map
		Map <String, Integer> myMap = new TreeMap<String, Integer>();
		myMap.put("q", new Integer(10));
		myMap.put("b", new Integer(9));
		myMap.put("c", new Integer(5));
		myMap.put("q", new Integer(5));
		myMap.put("q", new Integer(7));
		
		System.out.println(myMap);
			if (myMap.containsKey("q")){
			System.out.println(myMap.get("q"));
		}
			
			/*<Map.Entry<K, V>> is type (generic)
			entrySet() returns Set view of key - value pairs
			entrySet() helps to iterate through accessing both key and value at one time
			not looking through key and than searching for value*/
			Iterator<Map.Entry<String, Integer>> itr = myMap.entrySet().iterator();
			while(itr.hasNext()){
				Map.Entry<String, Integer> newMap = itr.next();
				System.out.println(newMap.getKey()+" : "+newMap.getValue());
				itr.remove();
				myMap.put("q", new Integer(7));
			}
			System.out.println(myMap);
	}
	
}