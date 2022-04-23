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

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class BalancedTree {

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

    BalancedTree() {
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
	
	public void isBalanced(){
		
		System.out.println("Node Balanced " + isBalanced(this.root));
		
	}
	
	private boolean checkCondition(int balancedFactor){
		
		if( balancedFactor == -1 | balancedFactor == 0 | balancedFactor == 1 )
			return true;
		else
			return false;
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
	
    public static void main(String[] str) {
        BalancedTree tree = new BalancedTree();
        tree.display();
    	tree.isBalanced();
    }
}
