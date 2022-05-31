class Node {	
	constructor(){
		this.next = null;
		this.value = null;	
	}    
}

class LinkedList {

	constructor(){
		this.head = null;
		this.size = 0;	
	}
	
	addFirst(input_node){
		if( this.size == 0 ){
			this.head = input_node;
			this.size = 1;
		}
		else {
			var current = this.head;
			this.head = input_node;
			input_node.next = current;
			this.size = this.size + 1;
		}
	}
	
	addLast(input_node){
		
		if( this.size == 0 ){
			this.head = input_node;
			this.size = 1;
		}
		else {
			let node = this.head;
			let prev = null;
			while(node != null){
				prev = node;
				node = node.next;
			}
			prev.next = input_node;
			this.size = this.size + 1;
		}
	
	}
	
	addNode(input_node,location){
	
		if( location > this.size && location < 1 ){
			console.log('Not a correct location');
			return;
		}
		else if( location === 1 ){
			this.addFirst(input_node);
		}
		else if(location === this.size){
			this.addLast(input_node);
		}
		else {
		let count = 0;
		let prev = null;
		let next = null;
		let node = this.head;
			while(node != null){
			  ++count;	
			  prev = node;
			  next = node.next;	
			  node = node.next;
			  if(count == (location-1)) break;
			}
			
			prev.next = input_node;
			input_node.next = next;
			this.size = this.size + 1;
		
		}
	
	}
	
	display() {
	    let count = 0;
		let node = this.head;
		while(node != null){
		  console.log(`Count=${++count}, value=${node.value}`);
		  node = node.next;
		}
	
	}
	
	totalSize() {
		console.log(`Size=${this.size}`);
		return this.size;
	}
	
}


let node1 = new Node();
node1.next = null;
node1.value = 100;
console.log(`Node value=${node1.value} next=${node1.next}`);


let node2 = new Node();
node2.next = null;
node2.value = 120;
console.log(`Node value=${node2.value} next=${node2.next}`);


let node3 = new Node();
node3.next = null;
node3.value = 10;
console.log(`Node value=${node3.value} next=${node3.next}`);


let node4 = new Node();
node4.next = null;
node4.value = 50;
console.log(`Node value=${node4.value} next=${node4.next}`);

let node5 = new Node();
node5.value = 7;
console.log(`Node value=${node5.value} next=${node5.next}`);

let linkedlist = new LinkedList();
linkedlist.addLast(node1);
linkedlist.addLast(node2);
linkedlist.addFirst(node3);
linkedlist.addNode(node4,2);
linkedlist.addNode(node5,1);
linkedlist.totalSize();
linkedlist.display();