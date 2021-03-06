/*
Given a binary tree , print its nodes from root to bottom as visible from left side of tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the left view of the tree

Sample Input
1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
Sample Output
1 2 4
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \           \
   4       5           6
When viewed from the left , we would see the nodes 1,2 and 4.

Sample Input 2
4 5 2 -1 -1 3 1 6 7 -1 -1 -1 -1 -1 -1
Sample Output
4 5 3 6
Explanation
The tree looks like

             4
          /      \
       5           2
                 /   \
               3       1
            /    \
           6      7
Sample Input 3
1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
Sample Output
1 2 4
                 1
               /   \
              2     3
             / \     \
            4   5     6 
Sample Input 4
1 2 3 -1 4 -1 -1 -1 5 -1 6 -1 -1
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Output :1 2 4 5 6



*/
import java.util.*;
import java.io.*;
public class BinaryTreeLeftView {
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        
        bt.leftView();
        
    }
}

class BinaryTree
{
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new java.util.LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void leftView()
    {
		int[] maxlevel = new int[1];
		maxlevel[0] = -1;
        leftView(this.root, 0 , maxlevel);
    }

   private void leftView(Node node, int level, int[] maxlevel) {
		
		if(node.data == -1) return;	
		
		if(level > maxlevel[0]) {
			System.out.print(node.data + " ");
			maxlevel[0] = level;
		}

		leftView(node.left, level + 1, maxlevel);
		leftView(node.right, level + 1, maxlevel);
		
	}


    private void construct(String[] arr,int ind,Queue<Node> queue)
    {
        if(ind>=arr.length)
        return;
        if(queue.size()==0)
        {
            Node nn=new Node(Integer.parseInt(arr[ind]));
            this.root=nn;
            queue.add(nn);
        }
        else
        {
            Node parent=queue.peek();
                if(parent.data!=-1){
                if(parent.left==null)
                {
                    parent.left=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                }
                else
                {
                    if(parent.right==null)
                    {
                    parent.right=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.right);
                    queue.poll();
                    }
               }
               }
               else
               {
                   queue.poll();
                   ind--;
               }
        }
        construct(arr,ind+1,queue);
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
        return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}