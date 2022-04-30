public class LinkedList {

	
	private class Node {
		int data;
		Node next;
	}	
	
	private Node head;
	private Node tail;
	private int size;
	
// Complexity is of Order(n)	
	public void display(){
		
		System.out.print("Start->");
		
		Node temp = this.head;
		
		while( temp != null ) {
			System.out.print(temp.data+",");
			temp =  temp.next;
		}
		
		System.out.println("<-Done");
	
	}
	
	// Complexity is of Order(1)
	public void addLast(int item) {
		
		//create a new Node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		
		// attach
		if( this.size >= 1 ){
			this.tail.next = nn;
		}
		
		if( this.size == 0 ) {
			this.head = nn;
			this.tail = nn;
			++this.size;
		}
		else {
			this.tail = nn;
			this.size++;
		}
		
	}
	
	// Complexity is of Order(1)
	public void addFirst(int item) {
		
		//create a new Node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;
		
		// attach
		if( this.size >= 1 ){
			Node oldHead = this.head;
			nn.next = oldHead;
		}
		
		if( this.size == 0 ) {
			this.head = nn;
			this.tail = nn;
			++this.size;
		}
		else {
			this.head = nn;
			this.size++;
		}
		
	}
	
	// Complexity is of Order(1)
	public int getFirst() throws Exception {
		
		//check for head or you can check size also
		/*if(this.head != null )
			return this.head.data;*/
		
		if ( this.size == 0 )
			throw new Exception("No Elements in Linked List");
		
		return this.head.data;
	}

	// Complexity is of Order(1) 
	public int getLast() throws Exception {
		
		//check for head or you can check size also
		/*if(this.head != null )
			return this.head.data;*/
		
		if ( this.size == 0 )
			throw new Exception("No Elements in Linked List");
		
		return this.tail.data;
	}	
	
	public int getAt(int index) throws Exception {
		
		return getItemAt(index);
	}
	
	//O(n)
	public int getItemAt(int index) throws Exception {
		
		if ( this.size == 0 )
			throw new Exception("No Elements in Linked List");
		
		if( index < 0 || index > size)
			throw new Exception(" in Linked List");
		
		Node temp = this.head;
		
		for ( int k = 1; k <= index ; ++k )
				temp = temp.next;
			
		return temp.data;	
	}
	
	//O(n)
	public Node getNodeAt(int index) throws Exception {
		
		if ( this.size == 0 )
			throw new Exception("No Elements in Linked List");
		
		if( index < 0 || index > size)
			throw new Exception("Index is out in Linked List");
		
		Node temp = this.head;
		
		for ( int k = 1; k <= index ; ++k )
				temp = temp.next;
			
		return temp;	
	}
	
	//O(n)
	public void addNodeAt(int index, int value) throws Exception {
		
		if ( this.size == 0 )
			throw new Exception("No Elements in Linked List");
		
		if( index < 0 || index > size)
			throw new Exception("Index is out in Linked List");
		
		
		Node temp = this.head;
		
		if( index == 0 ) {
			addFirst(value);
		}
		else if( this.size == index ) {
			addLast(value);
			
		}
		else {
			
			// This will also work
			/*
			for ( int k = 1; k < this.size ; ++k ) {			
				if( k == index ) {					
					Node nextToNextNode = temp.next.next;
					nn.next = nextToNextNode;
					temp.next = nn;
					return;
				}
			}
			*/
			
			Node nm1 = getNodeAt(index-1);  // nm1 = node minus one
			Node np1 = nm1.next;  // np1 = node plus one
			
			Node nn = new Node(); // nn = new node
			nn.data = value;
			
			nn.next = np1;
			nm1.next = nn;
			
			//sumamry update
			this.size++;
		
		}
					
	}
	
	//0(1)
	public int removeFirst() throws Exception{
		
		if(this.size == 0) 
		{ 
			throw new Exception("LL is empty"); 
		}
		
		int rv = this.head.data;
		
		if ( this.size == 1 ) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		else {
			Node first = this.head; //getNodeAt(1);
			Node second = first.next; //getNodeAt(2);
			this.head = second;
			this.size--;
		}	
		
		return rv;
		
	}
	
	public int size(){
		return this.size;
	}
	
	//Complexity Order(n)
	public int removeLast() throws Exception {
		
		if(this.size == 0) 
		{ 
			throw new Exception("LL is empty"); 
		}
		int rv = -1;
		
		if ( this.size == 1 ) {
			
			this.head = null;
			this.tail = null;
			this.size = 0;
			rv = 0;
			
		}
		else {
			
			Node lastNode = this.getNodeAt(this.size-1);
			rv = lastNode.data;
			
			Node nodeLastButOne = this.getNodeAt(this.size-2); //getNodeAt(1);
			this.tail = nodeLastButOne;
			nodeLastButOne.next = null;
			
			this.size--;
			
		}	
		
		return rv;
		
	}
	
	//0(n)
	public int removeAt(int index) throws Exception{
		
		if( index < 0 || index > size)
			throw new Exception("Index is out in Linked List");
		
		if(this.size == 0) 
			throw new Exception("LL is empty"); 
		
		int rv = -1;
		
		if ( index == 0 ) {
			rv = removeFirst();
		}
		else if ( index == this.size-1 ) {
			rv = this.removeLast();
		}
		else {
			
			Node nodeAtIndex = this.getNodeAt(index);
			rv = nodeAtIndex.data;
			
			Node nodeIndexMinusOne = this.getNodeAt(index-1);
			Node nodeIndexPlusOne = this.getNodeAt(index+1); //getNodeAt(1);
			
			nodeIndexMinusOne.next = nodeIndexPlusOne;
			
			this.size--;
		}	
		
		return rv;
		
	}
	
	public void reverseData() throws Exception{
		
		int left = 0;
		int right = this.size - 1;
		
		while ( left < right ) {
			
			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);
			
			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;
			
			left++;
			right--;
		}
	}
	
	
	public void reversePointers() throws Exception{
		
		Node previous = this.head;
		Node current = previous.next;
		
		while ( current != null ) {
			
			Node ahead = current.next;//order is very important in the loops.
			current.next = previous;
			previous = current;
			current = ahead;
		}
			
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
		
	}
	
	
	/*  this is working and tested. 
	public void reverseData() throws Exception{
				
		int loops = this.size/2;
		System.out.println(" loops  " + loops);
		
		for (int k = 0; k < loops ; ++k) {
			
			Node startvalue = getNodeAt(k);
			Node endvalue = getNodeAt(this.size-(k+1));
			
			System.out.println("startvalue = " + startvalue.data + " lastValue.data " + endvalue.data);
			
			int temp = startvalue.data;
			startvalue.data = endvalue.data;
			endvalue.data = temp;
		}
		
	}
	*/
	
	public static void main(String arg[]) throws Exception {
		LinkedList ls = new LinkedList();
		System.out.println("Default Size of Head " + ls.head);
		System.out.println("Default Size of Tail " + ls.tail);
		System.out.println("Default Size of size " + ls.size);
		
		
		//System.out.println("Get First = " + ls.getFirst());
		
		
		/*ls.addLast(10);
		ls.addLast(20);
		ls.addLast(30);
		ls.addLast(40);
		ls.addLast(50);*/

		
		ls.display();
		
		ls.addFirst(10);
		ls.addLast(20);
		ls.addLast(30);
		ls.addFirst(40);
		ls.addFirst(50);
		
		ls.display();
		
		System.out.println("Get First = " + ls.getFirst());
		
		System.out.println("Get Last = " + ls.getLast());
		
		
		System.out.println("Get Iteam At 3 = " + ls.getItemAt(3));
		
		System.out.println("Get Node At 3 = " + ls.getNodeAt(3));
		
		ls.addNodeAt(2,900);
		
		ls.display();
		
		System.out.println("Remove First");
		
		ls.removeFirst();
		
		ls.display();
		
		System.out.println("New Linked List");
		
		ls = new LinkedList();
		ls.addFirst(10);
		ls.addFirst(20);
		ls.addFirst(30);
		ls.addFirst(40);
		ls.addFirst(50);
		ls.addNodeAt(1,100);
		System.out.println("Display");
		ls.display();
		System.out.println("Print Size->" + ls.size());
		System.out.println("Print Last->" + ls.getLast());
		System.out.println("Print First->" + ls.getFirst());
		System.out.println("Print getAt(1)->" + ls.getAt(1));
		System.out.println("Remove First->" + ls.removeFirst());
		System.out.println("Remove Last->" + ls.removeLast());
		ls.display();
		System.out.println("Print Size->" + ls.size());
		System.out.println("Print removeAt(2)->" + ls.removeAt(2));
		System.out.println("Print removeAt(1)->" + ls.removeAt(1));
		System.out.println("Print removeAt(ls.size()-1)->" + ls.removeAt(ls.size()-1)); //index will be -1 of size
		ls.display();
		
		
		System.out.println("New List");
		
		ls = new LinkedList();
		ls.addFirst(10);
		ls.addFirst(20);
		ls.addFirst(30);
		ls.addFirst(40);
		ls.addFirst(50);
		ls.addNodeAt(1,100);
		//ls.addNodeAt(1,500);
		ls.display();
		System.out.println("Print Size->" + ls.size());
		System.out.println("Reverse Data");
		ls.reverseData();
		ls.display();
		ls.reversePointers();
		ls.display();
		
		
	}
}