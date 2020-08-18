/* *********************************************************
 * EECS2011A: Fundamentals of Data Structures,  Fall 2017
 * Assignment 2, Problem 1
 * Student Full Name   : Rajkumar Balakrishnan Lakshmi  
 * Student eecs account: kumarraj 
 * Student ID number   : 213141197
 **********************************************************/

package A2;

/*
 * The purpose of this class is to create a doubly linked list from a list of elements
 * and to sort them using the pancake sort mechanism.
 */
public class PancakeSort<E extends Comparable<? super E>>
{
	  //---------------- nested Node class ----------------
	  /**
	   * Node of a doubly linked list, which stores a reference to its
	   * element and to both the previous and next node in the list.
	   */
	  protected static class Node<E> 
	  {

	    /** The element stored at this node */
	    private E element;               // reference to the element stored at this node

	    /** A reference to the preceding node in the list */
	    private Node<E> prev;            // reference to the previous node in the list

	    /** A reference to the subsequent node in the list */
	    private Node<E> next;            // reference to the subsequent node in the list

	    /**
	     * Creates a node with the given element and next node.
	     *
	     * @param e  the element to be stored
	     * @param p  reference to a node that should precede the new node
	     * @param n  reference to a node that should follow the new node
	     */
	    public Node(E e, Node<E> p, Node<E> n) {
	      element = e;
	      prev = p;
	      next = n;
	    }

	    // public accessor methods
	    /**
	     * Returns the element stored at the node.
	     * @return the element stored at the node
	     */
	    public E getElement() { return element; }

	    /**
	     * Returns the node that precedes this one (or null if no such node).
	     * @return the preceding node
	     */
	    public Node<E> getPrev() { return prev; }

	    /**
	     * Returns the node that follows this one (or null if no such node).
	     * @return the following node
	     */
	    public Node<E> getNext() { return next; }

	    // Update methods
	    /**
	     * Sets the node's previous reference to point to Node n.
	     * @param p    the node that should precede this one
	     */
	    public void setPrev(Node<E> p) { prev = p; }

	    /**
	     * Sets the node's next reference to point to Node n.
	     * @param n    the node that should follow this one
	     */
	    public void setNext(Node<E> n) { next = n; }
	  } //----------- end of nested Node class -----------

	  // instance variables of the DoublyLinkedList
	  /** Sentinel node at the beginning of the list */
	  private Node<E> header;                    // header sentinel

	  /** Sentinel node at the end of the list */
	  private Node<E> trailer;                   // trailer sentinel

	  /** Number of elements in the list (not including sentinels) */
	  private int size = 0;                      // number of elements in the list

	  /** Constructs a new empty list. */
	  public PancakeSort() {
	    header = new Node<>(null, null, null);      // create header
	    trailer = new Node<>(null, header, null);   // trailer is preceded by header
	    header.setNext(trailer);                    // header is followed by trailer
	  }

	  // public accessor methods
	  /**
	   * Returns the number of elements in the linked list.
	   * @return number of elements in the linked list
	   */
	  public int size() { return size; }

	  /**
	   * Tests whether the linked list is empty.
	   * @return true if the linked list is empty, false otherwise
	   */
	  public boolean isEmpty() { return size == 0; }

	  /**
	   * Returns (but does not remove) the first element of the list.
	   * @return element at the front of the list (or null if empty)
	   */
	  public E first() {
	    if (isEmpty()) return null;
	    return header.getNext().getElement();   // first element is beyond header
	  }

	  /**
	   * Returns (but does not remove) the last element of the list.
	   * @return element at the end of the list (or null if empty)
	   */
	  public E last() {
	    if (isEmpty()) return null;
	    return trailer.getPrev().getElement();    // last element is before trailer
	  }

	  // public update methods
	  /**
	   * Adds an element to the front of the list.
	   * @param e   the new element to add
	   */
	  public void addFirst(E e) {
	    addBetween(e, header, header.getNext());    // place just after the header
	  }

	  /**
	   * Adds an element to the end of the list.
	   * @param e   the new element to add
	   */
	  public void addLast(E e) {
	    addBetween(e, trailer.getPrev(), trailer);  // place just before the trailer
	  }

	  /**
	   * Removes and returns the first element of the list.
	   * @return the removed element (or null if empty)
	   */
	  public E removeFirst() {
	    if (isEmpty()) return null;                  // nothing to remove
	    return remove(header.getNext());             // first element is beyond header
	  }

	  /**
	   * Removes and returns the last element of the list.
	   * @return the removed element (or null if empty)
	   */
	  public E removeLast() {
	    if (isEmpty()) return null;                  // nothing to remove
	    return remove(trailer.getPrev());            // last element is before trailer
	  }

	  // private update methods
	  /**
	   * Adds an element to the linked list in between the given nodes.
	   * The given predecessor and successor should be neighboring each
	   * other prior to the call.
	   *
	   * @param predecessor   node just before the location where the new element is inserted
	   * @param successor     node just after the location where the new element is inserted
	   */
	  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
	    // create and link a new node
	    Node<E> newest = new Node<>(e, predecessor, successor);
	    predecessor.setNext(newest);
	    successor.setPrev(newest);
	    size++;
	  }

	  /**
	   * Removes the given node from the list and returns its element.
	   * @param node    the node to be removed (must not be a sentinel)
	   */
	  private E remove(Node<E> node) {
	    Node<E> predecessor = node.getPrev();
	    Node<E> successor = node.getNext();
	    predecessor.setNext(successor);
	    successor.setPrev(predecessor);
	    size--;
	    return node.getElement();
	  }

	  /**
	   * Produces a string representation of the contents of the list.
	   * This exists for debugging purposes only.
	   */
	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder("(");
	    Node<E> walk = header.getNext();
	    while (walk != trailer) {
	      sb.append(walk.getElement());
	      walk = walk.getNext();
	      if (walk != trailer)
	        sb.append(", ");
	    }
	    sb.append(")");
	    return sb.toString();
	  }
	
	
   Node<E> max;
   Node<E> prefixLast;
   
   /*
    * This method calculates and return the node whose element is greater than other elements of the subset.
    * 
    * @param prefixLast - This node points to the last position for a subset, 
    * in which the maximum node is to be calculated.
    * @return The node whose elements value is higher than the others in the subset
    */
   private Node<E> getPrefixMaxNode(Node<E> prefixLast) 
	{
		  max =prefixLast;
		  for( Node<E> i=max.getPrev();i != header;i=i.getPrev())
		  {
			  if(i.getElement().compareTo(max.getElement())>0)
				  max=i;
		  }
		  return max;
	}
   
   /*
    * This method reverses the subset of the linked list and returns the current last position in the subset after reversal.
    * 
    * @param prefixLast - This node points to the last position for a subset, 
    * which is to be reversed.
    * @return The node that current position is last  in the subset after reversal.
    */
   private Node<E> reversePrefix(Node<E> prefixLast) 
  	{
	  Node<E> current = prefixLast;
	  Node<E> start = header.next;
	  Node<E> last = prefixLast;
	  while(start!=current)
	   {
	   last= last.prev;
	   current.getNext().prev = current.getPrev();
	   current.getPrev().next =  current.getNext();
	   current.next=start;
	   current.prev=start.prev;
	   start.getPrev().next =current;
	   start.prev=current;
	   current=last;
  	   }
	   return current;
  	}
   
   /*
    * This method creates a doubly linked list out of the elements obtained in the parameter and returns it.
    * 
    * @param elements - An array of elements of the type E, that needs to be added to the doubly linked list.
    * @return The linked list of the given elements
    */
   private static <E extends Comparable<? super E>>PancakeSort<E> buildList(E[] elements)
   {
	   PancakeSort<E> linkedList = new PancakeSort<E>();
	   int length = elements.length;
	   if(length<1)
	   {
		   System.out.println("Enter a valid list!");
		
	   }
	   for(int i=length-1; i>=0;i--)
	   {
		  linkedList.addFirst( elements[i]);
	   }

	   return linkedList;
	   
   }
  
   /*
    * This Method basically sorts the doubly linked list by applying the pancake sort mechanism.
    */
   public  void pancakeSort()
   {
	   this.prefixLast = trailer.prev;
	   while(prefixLast != header.next)
	   {
	    this.max=getPrefixMaxNode(prefixLast);
	    Node<E> last = reversePrefix(max);
	    if (max == prefixLast)
			prefixLast = last;
	    prefixLast = reversePrefix(prefixLast).prev;
	   }
	
   }
   
   public static void main(String[] args)
	{
	   
	    Integer[] i = {5,8,3,9,2};
	    PancakeSort<Integer> linkedList = buildList(i);
	    linkedList.pancakeSort();
	    System.out.println(linkedList.toString());
	    
	    Integer[] i2 = {8,3,5,4,8,9,2,4,7,5,-9,-5,-4,-2,-28,7,88};
	    PancakeSort<Integer> linkedList2 = buildList(i2);
	    linkedList2.pancakeSort();
	    System.out.println(linkedList2.toString());
	    
	    String[] i3 = {"Raj","Kumar","Harresma","Gayu","Bagya","Amala","Samantha","Andy","Raju"};
	    PancakeSort<String> linkedList3 = buildList(i3);
	    linkedList3.pancakeSort();
	    System.out.println(linkedList3.toString());
	    
	    Double[] i4 = {4.0,5.0,-45.0,-5.0,23.0,876.0,3.0};
	    PancakeSort< Double> linkedList4 = buildList(i4);
	    linkedList4.pancakeSort();
	    System.out.println(linkedList4.toString());
	}
}
