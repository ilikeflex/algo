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
		
		System.out.println("Start");
		
		Node temp = this.head;
		
		while( temp != null ) {
			System.out.print(temp.data+",");
			temp =  temp.next;
		}
		
		System.out.println("Done");
	
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
	}
}