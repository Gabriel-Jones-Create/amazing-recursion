package structure;

public class Node<T> {
  private Node<T> next;
  private T element;

  public Node(){
    next = null;
    element = null;
  }

  public Node(T elem) {
    next = null;
    element = elem;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> node) {
    next = node;
  }

  public T getElement() {
    return element;
  }

  public void setElement(T ele) {
    element = ele;
  }


}
