/*

Command To Enter
50 yes 25 yes 38 no no yes 48 yes 18 no no no yes 45 yes 85 no no yes 60 no no
10 yes 20 yes 40 no no yes 50 no no yes 30 no yes 60 no no

Tree
				50
		25				45
	38		48		85		60	
   x  x   18  x	   x  x    x  x


Tree
				10
		20				30
	40  	50   	X  		60
   X  X	   X  X            X  X

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
	
	//isLeftOrRight = true means left node
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
	
	
	// Returns true if s is a number else false
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
        // convert a given string to its primitive boolean value using parseBoolean() method
        boolean b1
            = Boolean.parseBoolean(str);
			
		if(str.equalsIgnoreCase("yes")){
			b1 = true;
		}			
  
        // returns primitive boolean value
        return b1;
    }
	
	
	public void display(){
		display2(root);
	}
	
	
	public void display2(Node node) {
		
		if(node == null )
			return;
		
		String str = "";
		
		if(node.left != null)
		{
			str += node.left.data + ">>";
		}
		else {
			str += "END=>";
		}
		
		str += node.data;
		
		if(node.right != null)
		{
			str +=  "<=" + node.right.data;
		}
		else {
			str += "<=END";
		}

		System.out.println(str);
		
		display2(node.left);
		display2(node.right);
		
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
		
		System.out.println();
		
		if(node.left != null){
			display(node.left);
			
		}
		
		if(node.right != null){
			display(node.right);
		}	
	}
	
	public void preOrderdisplay(){
		preOrderdisplay(root);
		System.out.println("PRE ORDER END");
	}
	
	//Output - 50,25,38,48,18,45,85,60
	public void preOrderdisplay(Node node){

		System.out.print(node.data + ",");
		
		if(node.left != null){
			preOrderdisplay(node.left);
		}
				
		if(node.right != null){
			preOrderdisplay(node.right);
		}
	}
	
	//Another way
	public void preOrderdisplay2(Node node){
		if(node == null) return;
		System.out.print(node.data + ",");
		preOrderdisplay(node.left);
		preOrderdisplay(node.right);		
	}
	
	//38,25,18,48,50,85,45,60
	public void inOrderdisplay(){
		inOrderdisplay(root);
		System.out.println("INORDER END");
	}
	
	public void inOrderdisplay(Node node){

		if(node.left != null){
			inOrderdisplay(node.left);
		}
		else
		{
			System.out.print(node.data + ",");
			return;
		}

		System.out.print(node.data + ",");
		
		if(node.right != null){
			inOrderdisplay(node.right);
		}
		else {
			System.out.print(node.data + ",");
			return ;
		}
		
	}
	
	//Anotherway 2
	public void inOrderdisplay2(Node node){

		if(node == null) return;
		inOrderdisplay2(node.left);
		System.out.print(node.data + ",");
		inOrderdisplay2(node.right);
		
	}

	//38,18,48,25,85,60,45,50
	public void postOrderDisplay(){
		postOrderDisplay2(root);
		System.out.println(" POST ORDER END");
	}
	
	//Anotherway 2
	public void postOrderDisplay2(Node node){
		if(node == null) return;
		postOrderDisplay2(node.left);
		postOrderDisplay2(node.right);
		System.out.print(node.data + ",");
	}	
	
	
	//Expected 50,25,45,38,48,85,60,18 
	public void levelOrderDisplay(){
		levelOrderDisplay(root);
		System.out.println(" LEVEL ORDER END IS NOT CORRECT");
	}
	
	//Anotherway 2
	public void levelOrderDisplay(Node node){
		if(node == null) return;
		
		System.out.print(node.data + ",");
		
		if(node.left != null){
			System.out.print(node.left.data + ",");
		}
		
		if(node.right != null){
			System.out.print(node.right.data + ",");
		}
			
		levelOrderDisplay(node.right);
		System.out.print(node.data + ",");
	}	
	
	
	public static void main(String[] str){
		BinaryTree tree = new BinaryTree();
		tree.display();
		tree.preOrderdisplay();
		tree.inOrderdisplay();
		tree.postOrderDisplay();
		tree.levelOrderDisplay();
	}
}