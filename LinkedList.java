public class LinkedList {

	
	private class Node {
		int data;
		Node next;
	}	
	
	private Node head;
	private Node tail;
	private int size;
		
	public void display(){
		
		System.out.println("Start");
		
		Node temp = this.head;
		
		while( temp != null ) {
			System.out.println(temp.data+",");
			temp =  temp.next;
		}
		
		System.out.println("Done");
	
	}
	
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
	
	
	public static void main(String arg[]){
		LinkedList ls = new LinkedList();
		System.out.println("Default Size of Head " + ls.head);
		System.out.println("Default Size of Tail " + ls.tail);
		System.out.println("Default Size of size " + ls.size);
		
		ls.addLast(10);
		ls.addLast(20);
		ls.addLast(30);
		ls.addLast(40);
		ls.addLast(50);
		ls.addLast(60);
		
		ls.display();
		
		
	}
}