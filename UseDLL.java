import java.util.ListIterator;
import java.util.*;

/* Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */

public class UseDLL {

public static void main(String args[]) throws Exception {
		
		DLL L = new DLL ();
		L.add(3);
		L.add(5);
		L.add(7);
		L.add(3);
		L.add(2);
		System.out.println("Printing List ");
		L.print();
	
		L.set(1, 8);
		L.print();
		System.out.println("AddAt : ");
		L.addAt(9, 1);
		L.print();
		System.out.println("Get: "+L.get(1).toString());
		System.out.println("size " + L.size());
		System.out.println("Find " + L.find(7).toString());
		L.print();
		System.out.println("Remove:");
		L.remove(8);
		L.print();

		
		DLL.ListIterator LIterator = L.listIterator();
	
		  do {
			int n = (int) LIterator.next();
			System.out.print( n + "\t" );

			} while (((DLL.ListIterator) LIterator).isNotLast());
	}
}
