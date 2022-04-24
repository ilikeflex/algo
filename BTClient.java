public class BTClient {

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
		
		
		BinaryTree tree2 = new BinaryTree();
		tree.flipEquivalent(tree2);
    }
}