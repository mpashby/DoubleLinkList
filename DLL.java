/* Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */

import java.util.*;
import java.util.Iterator;

public class DLL<T> implements  Iterable {
	DNode<T> head;
	int size;

	public DLL() {
		head = null;
		size = 0;
	}
	public boolean isEmpty() {  // determines if list is empty or not
		if (head == null) {
			return true;
		}
		return false; 
	}
	
	public int size() {   // returns size of list
		DNode<T> temp = head;
		if (isEmpty()) {
			return 0;
		}
		return sizeAux(temp, 1);
	}
	
	public int sizeAux(DNode<T> temp, int count) {  // Aux function to return size
		if (temp.getNext() == head) {
			return count;
		} else  {
			return sizeAux(temp.getNext(), count+1);
		}
	}
	
	public void add(Object newData) {  // adds object onto end of the list
		if (isEmpty()) {              // when empty, new obj is head
			this.head = new DNode <T> ((T) newData);
			head.setPrev(head);   // next and previous of head is itself
			head.setNext(head);
		} 
		else  {
			DNode <T> newNode = new DNode <T> ((T) newData);  // places obj at end of list
			DNode <T> temp = head;
			newNode.setPrev(head.getPrev());
			newNode.setNext(head);
			head.setPrev(newNode);
			DNode<T> newNext = get(size - 1);
			newNext.setNext(newNode);
		}
		size ++;
	}
	
	public void remove(T newData) {   // remove element from list  
		if (isEmpty()) {
			throw new IllegalStateException("Empty");  // empty list
		}
		DNode<T> lose = find(newData);
		DNode<T> prev = lose.getPrev();
		DNode<T> next = lose.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
	}
	
	public void addAt(Object newData, int n) {   // adds data at specificified index
		if (n>= size) { // includes empty list
			throw new IllegalStateException("Index too big");
		}
		DNode<T> newNode = new DNode<T> ((T) newData);
		DNode<T> newPrev = get(n-1);
		DNode<T> newNext = get(n);
		newNode.setPrev(newPrev);
		newNode.setNext(newNext);
		newPrev.setNext(newNode);
		newNext.setPrev(newNode);
		size++;
	}
	
	public DNode<T> get(int index) { // returns DNode at index
		if (isEmpty()) {
			return null;
		} else if (size <= index) { // index called for is bigger than size
			DNode<T> last = head.getPrev();  // returns last element
			return last;			
		} else {
			DNode<T> temp = head;
			return getAux(head, index);		
		}
	}
	
	public DNode<T> getAux(DNode<T> temp, int index) { // get Auxiliary function
		if (index==0) {    // base case 
			return temp;
		} else {
			return getAux(temp.getNext(), index-1);  //counts down index until zero
		}
	}
	
	public DNode<T> find(T newData) {  // returns node with given data 
		if (isEmpty()) {
			return null;
		} else {
			DNode<T> current = head;
			return findAux(current, newData);
		}
	}
		
	public DNode<T> findAux(DNode<T> current, T newData) {  //  find helper function
		if (current.getData() == newData) {
			return current;
		}
		else if (current.getNext() == head) {  // already recursed through whole list
				throw new IllegalStateException("Not in the List"); // and not in the list
		} else {
			return findAux(current.getNext(), newData);
		}
	}

	public void set(int index, T newElement) {  // sets  new value to the node at index
		DNode <T> newNode = get(index);
		newNode.setData(newElement);
	}
	
	public void print() {
		if(isEmpty()) {
			System.out.print("Empty");
			return;
		}
		DNode<T> current = head;
		int n = 0;
		while(n != size) {
			System.out.println("** " + current.toString());
			current = current.getNext();	
			n++;
		}
		System.out.println();	
	}
//-----------------------------------------------------------
	public interface ListIterator<E>{
		boolean hasNext();
		boolean hasPrevious();
		boolean isNotLast();
		Object next();
		Object previous();
	}
	class DLLIterator implements ListIterator {
		private DNode<T> nextNode;
		private DNode<T> prevNode;

		public DLLIterator(DNode<T> head) {
			nextNode = head;
			prevNode = head;	
		}
	
		@Override
		public boolean hasNext() {
			return  nextNode != null;
		}
		@Override
		public boolean hasPrevious() {
			return prevNode != null;
		}
		@Override
		public boolean isNotLast() {  // False if last element
			return nextNode != head;  // true if not last
		} 
		
		@Override
		public Object next() {
			Object data = nextNode.getData(); // data from nextNode
			prevNode = nextNode;
			nextNode = nextNode.getNext(); // moves the pointer to next node 
		
			return data; 
		}	
		@Override
		public Object previous() {  
			Object data = prevNode.getData();
			nextNode = prevNode;
			prevNode = prevNode.getPrev();
			return data;
		}
	}

	public ListIterator listIterator() {
		return new DLLIterator (head);
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
