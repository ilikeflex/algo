

/*

Tree
				50
		25				45
	38		48		85		60	
   x  x   18  x	   x  x    x  x



*/
import java.util.ArrayList;
import java.util.Scanner;


public class BinaryTree {
	
	private class Node {
		int data;
		Node left;
		Node right;
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	private Node root = null;
	private int size = 0;
	
	BinaryTree(){
	  Scanner s = new Scanner(System.in);
	  this.root = takeInput( s, null, false );
	}
	
	private Node takeInput(Scanner s, Node parent, boolean isLeftOrRight){
		
		if( parent == null ) {
			System.out.println("Enter data for root node");
		}
		else {
			if(isLeftOrRight){
				System.out.println("Enter data for left of node " + parent.data);
			}
			else {
				System.out.println("Enter data for right of node " + parent.data);
			}
		}
				
		int nodeData = s.nextInt();
		Node node = new Node(nodeData,null,null);
		this.size++;
		
		boolean choice = false;
		System.out.println("Do you have left child of " + nodeData);
		//choice = s.nextBoolean();
		choice = stringToBoolean(checkInput(s.next(),s));;
		
		if(choice){
			node.left = takeInput(s, node , true);
		}
		
		choice = false;
		System.out.println("Do you have right child of " + nodeData);
		//choice = s.nextBoolean();
		choice = stringToBoolean(checkInput(s.next(),s));
		
		
		if(choice){
			node.right = takeInput(s, node , false);
		}
		
		return node;
		
	}
	
	
	// Returns true if s is
    // a number else false
    static boolean isNumber(String s)
    {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;
 
        return true;
    }
	
	
	private static String checkInput(String input, Scanner s){
		
		
		if (isNumber(input)) {
			System.out.println("Enter yes/no");
			input  = s.next();
		}
		
		return input;
		
	}
	
	//https://www.geeksforgeeks.org/java-program-to-convert-a-string-to-boolean/
	private static boolean  stringToBoolean(String str)
    {
        // convert a given string to
        // its primitive boolean value
        // using parseBoolean() method
        boolean b1
            = Boolean.parseBoolean(str);
			
		if(str.equalsIgnoreCase("yes")){
			b1 = true;
		}			
  
        // returns primitive boolean value
        return b1;
    }
	
	
	public void display(){
		display(root);
	}
	
	public void display(Node node){

		if(node.left != null)
		{
			String str = node.left.data + ">>";
			System.out.print(str);
		}
		else {
			String str = "END=>";
			System.out.print(str);
		}
		
		//String str = node.data;
		System.out.print(node.data);
		
		if(node.right != null)
		{
			String str =  "<=" + node.right.data;
			System.out.print(str);
		}
		else {
			String str = "<=END";
			System.out.print(str);
		}
		
		if(node.left != null){
			display(node.left);
			System.out.println();
		}
		
		if(node.right != null){
			display(node.right);
			System.out.println();
		}	
	}
	
	public void preOrderdisplay(){
		preOrderdisplay(root);
	}
	
	//Output - 30,25,38,48,45,85,60
	public void preOrderdisplay(Node node){

		System.out.print(node.data + ",");
		
		if(node.left != null){
			preOrderdisplay(node.left);
		}
				
		if(node.right != null){
			preOrderdisplay(node.right);
		}
	}
	
	public static void main(String[] str){
		BinaryTree tree = new BinaryTree();
		//tree.display();
		tree.preOrderdisplay();
	}
}
