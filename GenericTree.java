

/*

Tree
				10
		4				5
	6		8		
	

Display
Enter data for root node
10
Enter number of children for the node = 10
2
4
Enter number of children for the node = 4
2
Enter data for 0 child node whose parent is 4
6
Enter number of children for the node = 6
0
Enter data for 1 child node whose parent is 4
8
Enter number of children for the node = 8
0
Enter data for 1 child node whose parent is 10
5
Enter number of children for the node = 5
0
10=>4, 5, END
4=>6, 8, END
6=>END
8=>END
5=>END

*/
import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	
	private class Node {
		int data;
		ArrayList<Node> children;
		Node(int data){
			this.data = data;
			this.children = new ArrayList();
		}
	}
	
	private Node root;
	private int size;
	
	GenericTree(){
	  Scanner s = new Scanner(System.in);
	  this.root = takeInput( s, null, 0 );
	}
	
	private Node takeInput(Scanner s, Node parent, int ithchild){
		if(this.root == null ){
			
			if(parent!=null) 
				this.root = parent;
			else
				System.out.println("Enter data for root node");
			
		}
		else{
			System.out.println("Enter data for " + ithchild + " child node whose parent is " + parent.data);
		}
		
		int nodedata = s.nextInt();
		Node newNode = new Node(nodedata);
		this.size++;
		
		System.out.println("Enter number of children for the node = " + newNode.data);
		int children = s.nextInt();
		
		for(int x=0; x<children; ++x){
			Node childNode = takeInput(s,newNode,x);
			newNode.children.add(childNode);
		}
		
		return newNode;
	}
	
	public void display(){
		display(root);
	}
	
	public void display(Node node){
		
		String str = node.data + "=>";
		
		for(int x=0; x<node.children.size(); ++x){
			//add children data for current node 
			str = str + node.children.get(x).data + ", ";
		}
		
		str = str + "END";
				
		System.out.println(str);
		
		for(int x=0; x<node.children.size(); ++x){
			Node childNode = node.children.get(x);
			display(childNode);
		}
		
	}
	
	public static void main(String[] str){
		GenericTree tree = new GenericTree();
		tree.display();
	}
}