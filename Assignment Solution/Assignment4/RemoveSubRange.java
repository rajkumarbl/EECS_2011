package A4;

import java.util.PriorityQueue;
import java.util.Queue;

public class  RemoveSubRange
{
		public static class BinarySearchTree<T extends Comparable<? super T>> 
		{
			Node<T> root;
			private Queue<T> sub = new PriorityQueue<T>();
			public void insert(T data) {
				this.root = insertNode(root, data);
		    }
			
			public Queue<T> removeSubMap(T k1, T k2) 
			{
				 this.removeSubMap(this.root, k1, k2);
				 return sub;
			}
			
			public void removeSubMap(Node<T> n, T entryk1, T entryk2) 
			{			
				if (n == null)
				{
					return;
				}	
				
				if(entryk1.compareTo(n.data) > 0)
			       removeSubMap(n.right, entryk1, entryk2);
				else
				   removeSubMap(n.left, entryk1, entryk2);
				
				int comparek1 = entryk1.compareTo(n.data); 
				int comparek2 = entryk2.compareTo(n.data);
				if(comparek1 <=0 && comparek2 >=0 )
				{
					 sub.add(n.data);
					 remove(n.data);
					 removeSubMap(n.left, entryk1, entryk2);
					 removeSubMap(n.right, entryk1, entryk2);
				}
				
				/*if (n == null)
				{
					return;
				}
				System.out.println(n.data);
				int comparek1 = entryk1.compareTo(n.data); 
				int comparek2 = entryk2.compareTo(n.data);
				
			    if(comparek1 <=0 && comparek2 >=0 )
			    {
			    	 sub.add(n.data);
			    	 remove(n.data);
			    	 removeSubMap(n.left, entryk1, entryk2);
					 removeSubMap(n.right, entryk1, entryk2);
			    }  
			    else if(n.data.compareTo(entryk1)<0)
			    {
			    	 removeSubMap(n.right, entryk1, entryk2);
			    }
			    else
			    {
			    	removeSubMap(n.left, entryk1, entryk2);
			    }*/
	
			}
			 public int height()
			   {
			      return height(root);
			   }
			   private int height(Node<T> p)
			   {
			      if(p == null) return -1;
			      else
			      return 1 + Math.max( height(p.left), height(p.right));
			   }


			private Node<T> insertNode(Node<T> n, T data) {
				if (n == null) {
					return new Node<T>(data, null, null);
				} else {
					if (n.data.compareTo(data) > 0) {
						n.left = insertNode(n.left, data);
					} else {
						n.right = insertNode(n.right, data);
					}
					n.size++; 
					return n;
				}
			}

		
			public Node<T> remove(T data) {
				return this.root = removeNode(root, data);
			}

			private Node<T> removeNode(Node<T> n, T data) {
				if (n == null) {
					return null;
				} else {
					int compare = n.data.compareTo(data);
					if (compare == 0) {
						if (n.left == null && n.right == null) {
							return null;
						} else if (n.left != null && n.right != null) {
							n.data = this.largestValue(n.left);
							n.left = this.removeNode(n.left, n.data);
							n.size--; 
							return n;
						} else {
							n.size--;
							if (n.left != null) {
								return n.left;
							} else {
								return n.right;
							}
						}
					} else if (compare > 0) {
						n.left = removeNode(n.left, data);
					} else {
						n.right = removeNode(n.right, data);
					}
					return n;
				}
			}

			public T largestValue() {
				return largestValue(this.root);
			}

			private T largestValue(Node<T> root) {
				if (root == null) {
					return null;
				} else if (root.right != null) {
					return largestValue(root.right);
				} else {
					return root.data;
				}
			}

			private String toStringInorder(Node<T> n) {
				StringBuilder sb = new StringBuilder();
				if (n != null) {
					if (n.left != null) {
						sb.append(toStringInorder(n.left));
						sb.append(",");
					}
					sb.append(n.data.toString());
					if (n.right != null) {
						sb.append(",");
						sb.append(toStringInorder(n.right));
					}
				}
				return sb.toString();
			}

			@Override
			public String toString() {
				return this.toStringInorder(this.root);
			}
		}

		public static class Node<T extends Comparable<? super T>> {
			public T data;
			public int size;
			public Node<T> left;
			public Node<T> right;

			public Node(T data, Node<T> left, Node<T> right) {
				this.data = data;
				this.left = left;
				this.right = right;
				this.size = 1;
			}

			@Override
			public String toString() {
				return this.data.toString();
			}
		}

		public static class Range<T extends Comparable<? super T>> {
			public T lower;
			public T upper;

			public Range(T lowerLimit, T upperLimit) {
				this.lower = lowerLimit;
				this.upper = upperLimit;
			}

			public boolean overlap(Range<T> other) {
				if (this.lower != null && other.upper != null && this.lower.compareTo(other.upper) > 0) {
					return false;
				}
				if (this.upper != null && other.lower != null && this.upper.compareTo(other.lower) < 0) {
					return false;
				}
				return true;
			}

			public boolean contains(T element) {
				if (this.lower != null && this.lower.compareTo(element) > 0) {
					return false;
				}
				if (this.upper != null && this.upper.compareTo(element) < 0) {
					return false;
				}
				return true;
			}
			
			public boolean contains(Range<T> other){
				if (this.lower != null && other.lower != null && this.lower.compareTo(other.lower) <= 0 && this.upper != null && other.upper != null && this.upper.compareTo(other.upper) >= 0){
					return true;
				}
				return false;
			}
		}

		public static void main(String[] args) 
		{
			
			BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
			Integer[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		    for(Integer n : a) bst1.insert(n);
			System.out.println("BinarySearchTree 1 - Before Removal : "+bst1);
			System.out.println("Removed Entries : "+ bst1.removeSubMap(5,10));
			System.out.println("BinarySearchTree 1 - After Removal  : "+bst1);
			
			System.out.println("\n====================================================================================\n");
			
			BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
			a = new Integer[] {3,55,67,23,12,54,98,45,36,1,3,14,16,28,74,62,58};
		    for(Integer n : a) bst2.insert(n);
			System.out.println("BinarySearchTree 2 - Before Removal : "+bst2);
			System.out.println("Removed Entries : "+ bst2.removeSubMap(30,60));
			System.out.println("BinarySearchTree 2 - After Removal  : "+bst2);
			

			
		}

	}