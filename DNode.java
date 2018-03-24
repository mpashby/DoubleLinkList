/* Michele Pashby
 * 30335753
 * mpashby19@cmc.edu
 */

public class DNode<T> {
	private T data;
	private DNode<T> prev, next;
	
	public DNode (T newData) {
		this.data = newData;
	}
	public T getData() {
		return data;
	}
	public DNode<T> getPrev() {
		return prev;
	}
	public DNode<T> getNext() {
		return next;
	}
	public void setData(T d) {
		this.data = d;
	}
	public void setPrev(DNode<T> p) {
		this.prev = p;
	}
	public void setNext(DNode<T> n) {
		this.next = n;
	}
	public String toString()  {
		return(data.toString());
	}

}
