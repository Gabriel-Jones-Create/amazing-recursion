package structure;

/**
 * Represents {@link List} of {@link Object}s that can be appended anywhere
 * 
 * @author gabrieljones
 *
 * @param <T> object type stored in {@link RecursiveLinkedList}
 */
public class RecursiveLinkedList<T> implements ListInterface<T> {

  private int count;//number of elements in the list
  private Node<T> head, tail; // first and last elements in the List

  public RecursiveLinkedList() {
    count = 0;
    head = null;
    tail = null;
  }
  
  private Node<T> getNode(Node<T> currentNode, int currentIndex){
		if(currentIndex == 0) {
			return currentNode;
		}
		else {
			return getNode(currentNode.getNext(),currentIndex-1);
		}
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public ListInterface<T> insertFirst(T elem) {
	  if(elem == null) {
		  throw new NullPointerException("Cannot insert null element");
	  }
      Node<T> newNode = new Node<T>(elem);
	  if(count == 0) {
		head = newNode;
		tail = newNode;
		count++;
	  }
	  else {
		  newNode.setNext(head);
	      head = newNode;
	      count++;
	  }
      return this;
  }

 @Override
  public ListInterface<T> insertLast(T elem) {
	 if(count == 0) {
		 return insertFirst(elem);
	 }
	 else {
	  Node<T> before = tail;
	  Node<T> last = new Node<T>(elem);
	  tail = last;
	  before.setNext(last);
	  count++;
	  return this;
	 }
 }

  @Override
  public ListInterface<T> insertAt(int index, T elem) {
	// get node at index-1 (using private getNode)
	// set new nodes next to node at index 1's next
	//set index-1's next to new node
	  Node<T> newNode = new Node<T>(elem);
	  if(index == 0) {
		  return insertFirst(elem);
	  }
	  else if(index == this.size()){
		  return insertLast(elem);
	  }  
	  else if(count == 1) {
		  head.setNext(newNode);
		  tail = newNode;
		  count++;
	  }
	  else {
		 Node<T> before = getNode(head,index-1);
		 Node<T> precursor = getNode(head,index);
		 Node<T> insert = new Node<T>(elem);
		 before.setNext(insert);
		 insert.setNext(precursor);
		 count++;
	  }
	 
    return this;
  }
  @Override
  public T removeFirst() {
	 // copy dequeue 
	  if(isEmpty()) {
		  throw new IllegalStateException("Cannot remove when you are list is empty");
	  }
	  T elem = head.getElement();
	  head = head.getNext();
	  count--;
	  if(isEmpty()) {
		  tail = null;
	  }
      return elem;
  }

  @Override
  public T removeLast() {
	  // ur  gonna return the removeat (count-1) yk
	  if(isEmpty()) {
		  throw new IllegalStateException("Cannot remove when your list is empty");
	  }
	  if(count == 1) {
		  return removeFirst();
	  }
	 T result = tail.getElement();
	 Node<T> nextToLast = getNode(head,count-2);
	 nextToLast.setNext(null);
     tail = nextToLast;
	 count--;
	 return result;
	 
}

  @Override
  public T removeAt(int index) {
	 if(isEmpty()) {
		  throw new IndexOutOfBoundsException("Cannot remove when your list is empty");
	 }
	 else if(index >= size()) {
		 throw new IndexOutOfBoundsException("That item does not exist");
	 }
	if(index == count) {
		return removeLast();
	}
	else if(index == 0) {
		return removeFirst();
	}
	T removedValue = getNode(head,index).getElement();
	Node<T> front = getNode(head,index-1);
	Node<T> behind = getNode(head,index).getNext();
	front.setNext(behind);
	count--;
    return removedValue;
  }

  @Override
  public T getFirst() {
	if(size() == 0) {
		throw new IllegalStateException("Cannot get first when list does not exist");
	}
    return head.getElement();
  }

  @Override
  public T getLast() {
	 if(size() == 0) {
			throw new IllegalStateException("Cannot get last when list does not exist");
	}
    return tail.getElement();
  }

  @Override
  public T get(int index) {
    return getNode(head, index).getElement();
  }

  @Override
  public boolean remove(T elem) {
	  //do this after removeat and use remove at here
	  int index = contains(elem);
	  if(index == -1) {
		  return false;
	  }
	  else {
		  removeAt(index);
		  return true;
	  }
  }

  @Override
  public int contains(T elem) {
    return contains(elem, head, 0);
  }

  private int contains(T toFind, Node<T> toCheck, int currentIndex) {
    // 2 base cases
    // base 1 - I've reached end of the list (return -1)
    // base 2 - I've found the node (toCheck.getElement().equals(toFind)) return currentIndex

    // 1 recursive case
    // contains(toFind, toCheck.getNext(), currentIndex+1
	 if(currentIndex == count) {
		 return -1; 
	 }
	 else if(toCheck.getElement().equals(toFind)) {
		return currentIndex;
	}
	 else {
		 return contains(toFind,toCheck.getNext(),currentIndex+1);
	 }
  }

  @Override
  public boolean isEmpty() {
	if(this.size() > 0) {
		return false;
	}
    return true;
  }

}
