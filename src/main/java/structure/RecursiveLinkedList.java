package structure;

public class RecursiveLinkedList<T> implements ListInterface<T> {

  private int count;
  private Node<T> head, tail;

  public RecursiveLinkedList() {
    count = 0;
    head = null;
    tail = null;
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public ListInterface<T> insertFirst(T elem) {
    // similar to push
    // create a node
    Node<T> newNode = new Node<T>(elem);
    // set it's next to the current head
    newNode.setNext(head);
    // update head to point to our new node
    head = newNode;
    // return our list
    return this;
  }

  @Override
  public ListInterface<T> insertLast(T elem) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ListInterface<T> insertAt(int index, T elem) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T removeFirst() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T removeLast() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T removeAt(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T getFirst() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T getLast() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean remove(T elem) {
    // TODO Auto-generated method stub
    return false;
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
    // contains(toFind, toCheck.getNext(), currentIndex+1)
    return 0;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

}
