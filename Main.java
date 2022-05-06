import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree1 = new BinaryTree();
        BinaryTree binaryTree2 = new BinaryTree();
        AVLTree avlTree1 = new AVLTree();
        AVLTree avlTree2 = new AVLTree();
        System.out.println("Unbalanced BST insertion: r/e");

        double startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            binaryTree1.insert((int) (Math.random() * 1000000 - 500000));
        }
        System.out.println("\n" + (System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("Unbalanced BST insertion: c/e");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            binaryTree2.insert(i * 100 - 50);
        }

        System.out.println("\n" + (System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println();

        startTime = System.nanoTime();
        System.out.println("\nBalanced BST insertion: r/e");
        for (int i = 0; i < 1000; i++) {
            avlTree1.insert((int) (Math.random() * 1000000 - 500000));
        }
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nBalanced BST insertion: c/e");

        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            avlTree2.insert(i * 100 - 50);
        }

        System.out.println("\n" + (System.nanoTime() - startTime) / 1000000 + "ms");


        binaryTree1.insert(12345);
        binaryTree2.insert(12345);
        avlTree1.insert(12345);
        avlTree2.insert(12345);

        System.out.println("\nUnbalanced BST search(r/e)");

        startTime = System.nanoTime();
        binaryTree1.search(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nUnbalanced BST search(c/e)");

        startTime = System.nanoTime();
        binaryTree2.search(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nBalanced BST search(r/e)");

        startTime = System.nanoTime();
        avlTree1.search(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nBalanced BST search(c/e)");

        startTime = System.nanoTime();
        avlTree2.search(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nUnbalanced BST deletion(r/e)");

        startTime = System.nanoTime();
        binaryTree1.delete(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nUnbalanced BST deletion(c/e)");

        startTime = System.nanoTime();
        binaryTree2.delete(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nBalanced BST deletion(r/e)");

        startTime = System.nanoTime();
        avlTree1.delete(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("\nBalanced BST deletion(c/e)");

        startTime = System.nanoTime();
        avlTree2.delete(12345);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("Convert a normal BST to balanced BST(r/e)");
        startTime = System.nanoTime();
        ConvertBSTToBalancedBST.convertToBalancedBST(binaryTree1.root);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

        System.out.println("Convert a normal BST to balanced BST(c/e)");
        startTime = System.nanoTime();
        ConvertBSTToBalancedBST.convertToBalancedBST(binaryTree2.root);
        System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");

    }
}
