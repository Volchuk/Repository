import java.util.ArrayList;
import java.util.Iterator;
public class test3 {

	public static void main(String[] args) {
		// iterators
		
		ArrayList <Object> list = new ArrayList <Object>();
		list.add(3);
		list.add(6);
		list.add(11);
		list.add(13);
		Iterator<Object> itr = list.iterator();
		while(itr.hasNext()){
			Object obj = itr.next();
			System.out.println(obj.toString());
		}

	}

}