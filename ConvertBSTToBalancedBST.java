import java.util.ArrayList;
class ConvertBSTToBalancedBST {

     private static void storeInOrderTraversal(Node root, ArrayList<Integer> inOrderNodes) {
        if (root != null) {
            storeInOrderTraversal(root.left, inOrderNodes);
            inOrderNodes.add(root.key);
            storeInOrderTraversal(root.right, inOrderNodes);
        }
    }

    private static Node convertSortedArrayToBalancedBST(ArrayList<Integer> inOrderNodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inOrderNodes.get(mid));

        root.left = convertSortedArrayToBalancedBST(inOrderNodes, start, mid - 1);

        root.right = convertSortedArrayToBalancedBST(inOrderNodes, mid + 1, end);

        return root;
    }

    public static Node convertToBalancedBST(Node root) {

        ArrayList<Integer> inOrderNodes = new ArrayList<>();

        storeInOrderTraversal(root, inOrderNodes);

        return convertSortedArrayToBalancedBST(inOrderNodes, 0, inOrderNodes.size() - 1);
    }
}