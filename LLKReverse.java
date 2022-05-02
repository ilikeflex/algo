/*
Given a head to Linked List L, write a function to reverse the list taking k elements at a time. Assume k is a factor of the size of List.

You need not have to create a new list. Just reverse the old one using head.

Input Format
The first line contains 2 space separated integers N and K

The next line contains N space separated integral elements of the list.

Constraints
0 <= N <= 10^6 0 <= K <= 10^6

Output Format
Display the linkedlist after reversing every k elements

Sample Input
9 3
9 4 1 7 8 3 2 6 5
Sample Output
1 4 9 3 8 7 5 6 2
Explanation
N = 9 & K = 3

Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5

After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2
*/

import java.util.Scanner;

public class LLKReverse {
	static class LinkedList {
		private class Node {
			int data;
			Node next;

			Node(int data, Node next) {
				this.data = data;
				this.next = next;
			}
		}

		private Node head;
		private Node tail;
		private int size;

		public LinkedList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}

		public LinkedList(Node head, Node tail, int size) {
			this.head = head;
			this.tail = tail;
			this.size = size;
		}

		// O(1)
		public int size() {
			return this.size;
		}

		// O(1)
		public boolean isEmpty() {
			return this.size() == 0;
		}

		// O(1)
		public int getFirst() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty.");
			}

			return this.head.data;
		}

		// O(1)
		public int getLast() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty.");
			}

			return this.tail.data;
		}

		// O(N)
		public int getAt(int idx) throws Exception {
			Node temp = this.getNodeAt(idx);
			return temp.data;
		}

		// O(N)
		private Node getNodeAt(int idx) throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty");
			}

			if (idx < 0 || idx >= this.size()) {
				throw new Exception("Invalid arguments");
			}

			Node retVal = this.head;
			for (int i = 0; i < idx; i++) {
				retVal = retVal.next;
			}

			return retVal;
		}

		// O(1)
		public void addFirst(int data) {
			Node node = new Node(data, this.head);

			if (this.size() == 0) {
				this.head = node;
				this.tail = node;
			} else {
				this.head = node;
			}

			this.size++;
		}

		// O(1)
		public void addLast(int data) {
			Node node = new Node(data, null);

			if (this.size() == 0) {
				this.head = node;
				this.tail = node;
			} else {
				this.tail.next = node;
				this.tail = node;
			}

			this.size++;
		}

		// O(n)
		public void addAt(int idx, int data) throws Exception {
			if (idx < 0 || idx > this.size()) {
				throw new Exception("Invalid arguments");
			}

			if (idx == 0) {
				this.addFirst(data);
			} else if (idx == this.size()) {
				this.addLast(data);
			} else {
				Node nm1 = this.getNodeAt(idx - 1);
				Node n = nm1.next;

				Node node = new Node(data, n);
				nm1.next = node;

				this.size++;
			}
		}

		// O(1)
		public int removeFirst() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty");
			}

			int retVal = this.head.data;

			if (this.size() == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
			}

			this.size--;
			return retVal;
		}

		// O(n)
		public int removeLast() throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty");
			}

			int retVal = this.tail.data;

			if (this.size() == 1) {
				this.head = null;
				this.tail = null;
			} else {
				Node sm2 = this.getNodeAt(this.size() - 2);
				sm2.next = null;
				this.tail = sm2;
			}

			this.size--;
			return retVal;
		}

		// O(n)
		public int removeAt(int idx) throws Exception {
			if (this.isEmpty()) {
				throw new Exception("List is empty");
			}

			if (idx < 0 || idx >= this.size()) {
				throw new Exception("Invalid arguments");
			}

			if (idx == 0) {
				return this.removeFirst();
			} else if (idx == this.size() - 1) {
				return this.removeLast();
			} else {
				Node nm1 = this.getNodeAt(idx - 1);
				Node n = nm1.next;
				Node np1 = n.next;

				nm1.next = np1;
				this.size--;

				return n.data;
			}
		}

		// O(n)
		public void display() {
			Node node = this.head;

			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}

			// System.out.println("END");
		}

		public void swapValues(int leftpointer, int rightpointer) throws Exception {
			
			while(leftpointer<rightpointer)
			{				
				Node left = getNodeAt(leftpointer);
				Node right = getNodeAt(rightpointer);	
				//System.out.println("Before left="+left.data+",right="+right.data);
				int temp = left.data;
				left.data = right.data;
				right.data = temp;
				leftpointer++;
				rightpointer--;
				//System.out.println("After left="+left.data+",right="+right.data);
			}
			
		}
		public void reverse(int k) throws Exception {

			// Write your code here
			//start mid1 mid2 mid3 mid4 end
			//Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5
			//After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2
			
			// 5 8 9 13 45 67 12 90 89 24 56
			// 13 9 8 5, 90 12 67 45, 
			
			int leftpointer = 0;
			int rightpointer = leftpointer + (k-1);
			
			while( leftpointer < this.size && rightpointer < this.size) {
				//System.out.println("leftpointer="+leftpointer+",rightpointer="+rightpointer);
				swapValues(leftpointer,rightpointer);
				leftpointer = rightpointer + 1 ;
				rightpointer = rightpointer + k;
			}			

		}

		public static void main(String[] args) throws Exception {

			Scanner scn = new Scanner(System.in);
			int N = scn.nextInt();
			int k = scn.nextInt();

			LinkedList list = new LinkedList();

			for (int i = 0; i < N; i++) {
				list.addLast(scn.nextInt());
			}

			list.reverse(k);
			list.display();
		}
	}

	public static void main(String[] args) throws Exception {
		
		LinkedList.main(args);
	}
}