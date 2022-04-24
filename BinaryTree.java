/*

Command To Enter

Tree(50 yes 25 yes 38 no no yes 48 yes 18 no no no yes 45 yes 85 no no yes 60 no no)
				50
		25				45
	38		48		85		60	
      18


Tree(10 yes 20 yes 40 no no yes 50 no no yes 30 no yes 60 no no)
				10
		20				30
	40		50		x		60
   
Tree(10 yes 20 yes 40 no no yes 50 yes 17 no no no yes 30 no yes 60 no yes 80 no yes 90 no no)
				10
		20				30
	40		50		x		60
                       17 X   	`	              X   80
							 X  90

Tree(10 yes 20 yes 40 yes 70 yes 90 yes 110 no no no no no yes 50 no yes 80 no yes 100 no yes 120 no no yes 30 no yes 60 no no)

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class BinaryTree {

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root = null;
    private int size = 0;

    BinaryTree() {
        Scanner s = new Scanner(System.in);
        this.root = takeInput(s, null, false);
    }

    //isLeftOrRight = true means left node
    private Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {

        if (parent == null) {
            System.out.println("Enter data for root node");
        } else {
            if (isLeftOrRight) {
                System.out.println("Enter data for left of node " + parent.data);
            } else {
                System.out.println("Enter data for right of node " + parent.data);
            }
        }

        int nodeData = s.nextInt();
        Node node = new Node(nodeData, null, null);
        this.size++;

        boolean choice = false;
        System.out.println("Do you have left child of " + nodeData);
        //choice = s.nextBoolean();
        choice = stringToBoolean(checkInput(s.next(), s));
        ;

        if (choice) {
            node.left = takeInput(s, node, true);
        }

        choice = false;
        System.out.println("Do you have right child of " + nodeData);
        //choice = s.nextBoolean();
        choice = stringToBoolean(checkInput(s.next(), s));


        if (choice) {
            node.right = takeInput(s, node, false);
        }

        return node;

    }


    // Returns true if s is a number else false
    static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++)
            if (Character.isDigit(s.charAt(i)) == false)
                return false;

        return true;
    }


    private static String checkInput(String input, Scanner s) {

        if (isNumber(input)) {
            System.out.println("Enter yes/no");
            input = s.next();
        }

        return input;

    }

    //https://www.geeksforgeeks.org/java-program-to-convert-a-string-to-boolean/
    private static boolean stringToBoolean(String str) {
        // convert a given string to its primitive boolean value using parseBoolean() method
        boolean b1
                = Boolean.parseBoolean(str);

        if (str.equalsIgnoreCase("yes")) {
            b1 = true;
        }

        // returns primitive boolean value
        return b1;
    }


    public void display() {
        display2(root);
    }


    public void display2(Node node) {

        if (node == null)
            return;

        String str = "";

        if (node.left != null) {
            str += node.left.data + ">>";
        } else {
            str += "END=>";
        }

        str += node.data;

        if (node.right != null) {
            str += "<=" + node.right.data;
        } else {
            str += "<=END";
        }

        System.out.println(str);

        display2(node.left);
        display2(node.right);

    }


    public void display(Node node) {

        if (node.left != null) {
            String str = node.left.data + ">>";
            System.out.print(str);
        } else {
            String str = "END=>";
            System.out.print(str);
        }

        //String str = node.data;
        System.out.print(node.data);

        if (node.right != null) {
            String str = "<=" + node.right.data;
            System.out.print(str);
        } else {
            String str = "<=END";
            System.out.print(str);
        }

        System.out.println();

        if (node.left != null) {
            display(node.left);

        }

        if (node.right != null) {
            display(node.right);
        }
    }

    public void preOrderdisplay() {
        preOrderdisplay(root);
        System.out.println("PRE ORDER END");
    }

    //Output - 50,25,38,48,18,45,85,60
    public void preOrderdisplay(Node node) {

        System.out.print(node.data + ",");

        if (node.left != null) {
            preOrderdisplay(node.left);
        }

        if (node.right != null) {
            preOrderdisplay(node.right);
        }
    }

    //Another way
    public void preOrderdisplay2(Node node) {
        if (node == null) return;
        System.out.print(node.data + ",");
        preOrderdisplay(node.left);
        preOrderdisplay(node.right);
    }

    //38,25,18,48,50,85,45,60
    public void inOrderdisplay() {
        inOrderdisplay(root);
        System.out.println("INORDER END");
    }

    public void inOrderdisplay(Node node) {

        if (node.left != null) {
            inOrderdisplay(node.left);
        } else {
            System.out.print(node.data + ",");
            return;
        }

        System.out.print(node.data + ",");

        if (node.right != null) {
            inOrderdisplay(node.right);
        } else {
            System.out.print(node.data + ",");
            return;
        }

    }

    //Anotherway 2
    public void inOrderdisplay2(Node node) {

        if (node == null) return;
        inOrderdisplay2(node.left);
        System.out.print(node.data + ",");
        inOrderdisplay2(node.right);

    }

    //38,18,48,25,85,60,45,50
    public void postOrderDisplay() {
        postOrderDisplay2(root);
        System.out.println(" POST ORDER END");
    }

    //Anotherway 2
    public void postOrderDisplay2(Node node) {
        if (node == null) return;
        postOrderDisplay2(node.left);
        postOrderDisplay2(node.right);
        System.out.print(node.data + ",");
    }


    //Expected 50,25,45,38,48,85,60,18 
    public void levelOrderDisplay() {
        levelOrderDisplay(root);
        System.out.println(" LEVEL ORDER END IS NOT CORRECT");
    }

    //Anotherway 2
    public void levelOrderDisplay(Node node) {
        if (node == null) return;

        System.out.print(node.data + ",");

        if (node.left != null) {
            System.out.print(node.left.data + ",");
        }

        if (node.right != null) {
            System.out.print(node.right.data + ",");
        }

        levelOrderDisplay(node.right);
        System.out.print(node.data + ",");
    }
	
	public void calculateSize(){
		System.out.println("Size = " + size(this.root));
	}

	private int size(Node node) {		
		
		int count = 0;	
		
		if(node == null) 
			return count;
		
		if(node != null) 
			++count;
				
		
		count = count + size(node.left);
		
		count = count + size(node.right);
		
		return count;
		
	}
	
	public void max() {
		System.out.println("MAX = " + max(this.root));
	}
	
	private int max(Node node){
		
		if(node == null) 
			return -1;
				
		
		int result = Math.max(node.data,max(node.left));
		result = Math.max(result,max(node.right));
		
		return result;
	}
	
	public void find() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER NODE TO FIND = ");
		int nodeToFound = s.nextInt();
		
		System.out.println("FOUND = " + find(this.root,nodeToFound));
	}
	
	private boolean find(Node node, int nodeToFound){
		
		if(node == null) 
			return false;
		
		System.out.println("Node to test " + node.data);
				
		boolean result = node.data == nodeToFound ;
		
		if(result)		
			return true;
			
		result = find(node.left,nodeToFound);
		
		//any node in left is equal return then no need to go more left and no need to go right
		if(result) return true;
		
		result = find(node.right,nodeToFound);
		
		//any node in right is equal then no need to go more right
		if(result) return true;
		
		return result;
	}
	
	public void heightofTree(){
		System.out.println("Height of Tree " + heightofTree(this.root));
	}
	
	private static int heightofTree(Node node){
		
		if( node == null )
			return -1;
				
		int height = 1;
		
		int lheight = height + heightofTree(node.left);
		int rheight = height + heightofTree(node.right);
		
		if(lheight>=rheight)
			return lheight;
		
		return rheight;
	}
	
	public void diameter(){
		System.out.println("Diameter of Tree " + diameter(this.root));
	}
	
	/*
	private static int diameterOfNode(Node node){
		
		int lheight = heightofTree(node.left);
		int rheight = heightofTree(node.right);		
		int totaldiamter = lheight + rheight + 2;
		return totaldiamter;
	}
	*/
	
	private static int diameter(Node node){
		
		if( node == null )
			return 0;
		
		int leftdiameter = diameter(node.left);
		int rightdiameter = diameter(node.right);
		int selfdiameter = heightofTree(node.left) +  heightofTree(node.right) + 2;		// if node is itself part of diameter node
		
		
		return Math.max(selfdiameter,Math.max(leftdiameter,rightdiameter));
		
	}
	
	
	public void diameterOptimize(){
		
		System.out.println("Diameter of diameterOptimize " + diameterOptimize(this.root).dia);
		
	}
	
	private class DiaPair {
		int dia;
		int ht;
	}
	
	private DiaPair diameterOptimize(Node node){
		
		if( node == null )
		{
			DiaPair dp = new DiaPair();
			dp.ht = -1; //base condition for height of tree
			dp.dia = 0; //base condition for diameter
			return dp;
		};
		
		DiaPair leftdp = diameterOptimize(node.left);

		
		DiaPair rightdp = diameterOptimize(node.right);

		int selfdiameter = leftdp.ht +  rightdp.ht + 2;		// if node is itself part of diameter node
		int finaldiameter = Math.max(selfdiameter,Math.max(leftdp.dia,rightdp.dia));
		
		DiaPair result = new DiaPair();
		result.dia = finaldiameter;
		result.ht = Math.max(leftdp.ht,rightdp.ht) + 1;
		return result;
		 
		
	}
	
	public void isBalanced(){
		
		System.out.println("Node Balanced " + isBalanced(this.root));
		
	}
	
	private boolean isBalanced(Node node){
		
		if(node==null)
			return true;
		
		boolean lb = isBalanced(node.left);
		boolean rb = isBalanced(node.right);
		int bf = heightofTree(node.left) - heightofTree(node.right);
		
		boolean result = lb && rb && checkCondition(bf);
		
		return result;
	}
	
	private boolean checkCondition(int balancedFactor){
		
		if( balancedFactor == -1 || balancedFactor == 0 || balancedFactor == 1 )
			return true;
		else
			return false;
	}
	
	
	
	private class BalPair{
		boolean isBalanced = true; //base condiiton for balanced tree
		int ht = -1; //base condition for height of tree
	}
	
	
	public void isBalancedOptimize(){
		
		System.out.println("Node Balanced Optimize " + isBalancedOptimize(this.root).isBalanced);
		
	}
	
	private boolean checkConditionOptimize(int balancedFactor){
		
		if( balancedFactor == -1 || balancedFactor == 0 || balancedFactor == 1 )
			return true;
		else
			return false;
	}
	
	private BalPair isBalancedOptimize(Node node){
		
		if(node==null)
			return new BalPair();
		
		BalPair lbp = isBalancedOptimize(node.left); // lbp = left balanced pair
		BalPair rbp = isBalancedOptimize(node.right); // rbp = right balanced pair
		
		BalPair cbp = new BalPair(); // cbp = current balanced pair
		int bf = lbp.ht - rbp.ht; //bf = balanced factor
		boolean result = lbp.isBalanced && rbp.isBalanced && checkConditionOptimize(bf); // check if the current node is balanced
		cbp.ht = Math.max(lbp.ht,rbp.ht) + 1;
		cbp.isBalanced = result;
		
		return cbp;
	}
	
	public void flipEquivalent(BinaryTree node2){
		System.out.print(" flipEquivalent " + flipEquivalent(this.root,node2.root));
	}
	
	private String print(Node node){
	
		if(node != null )
			return String.valueOf(node.data);
		else
			return "NULL";
	}
	
	
	private boolean flipEquivalent(Node node1, Node node2){
		
		System.out.println("Node Value node1.data=" + print(node1) + "node2.data=" + print(node2));
		
		if( node1 == null && node2 == null ) {
			return true;
		}
		
		// can be written better 
		/*
			if( node1 == null || node2 == null ) {
				return false;
			}
		*/
		
		if( node1 != null && node2 == null ) {
			
			return false;
		}
		
		if( node1 == null && node2 != null ) {
			
			return false;
		}
		
		if( node1.data != node2.data ) {
			
			return false;
		}	
		
		
		boolean ll = flipEquivalent(node1.left, node2.left); // ll = left left
		boolean rr = flipEquivalent(node1.right, node2.right); // rr = right right
		
		if( ll && rr )
			return true;
		
		
		boolean lr = flipEquivalent(node1.left, node2.right); // lr = left right
		boolean rl = flipEquivalent(node1.right, node2.left); // rl = right left
		
			
		if( (ll && rr) || ( lr && rl ) )
			return true;
		else
			return false;
	}
		
	
    public static void main(String[] str) {
        BinaryTree tree = new BinaryTree();
        tree.display();
        tree.preOrderdisplay();
        tree.inOrderdisplay();
        tree.postOrderDisplay();
        tree.levelOrderDisplay();
		tree.calculateSize();
		tree.max();
		tree.find();
		tree.heightofTree();
		tree.diameter();
		tree.diameterOptimize();
		tree.isBalanced();
		tree.isBalancedOptimize();
    }
}
