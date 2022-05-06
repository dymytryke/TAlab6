class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }


    public void delete(int key) {
        root = delete_Recursive(root, key);
    }


    protected Node delete_Recursive(Node root, int key) {

        if (root == null) return root;

        if (key < root.key)
            root.left = delete_Recursive(root.left, key);

        else if (key > root.key)
            root.right = delete_Recursive(root.right, key);

        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = delete_Recursive(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {

        int minval = root.key;

        while (root.left != null) {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }


    public void insert(int key) {
        root = insert_Recursive(root, key);
    }


    protected Node insert_Recursive(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);

        return root;
    }

    public boolean search(int key) {
        if (search_Recursive(root, key) == null) {
            return false;
        }
        return true;
    }

    protected Node search_Recursive(Node root, int key) {

        if (root == null || root.key == key)
            return root;

        if (root.key < key)
            return search_Recursive(root.right, key);

        return search_Recursive(root.left, key);
    }

    public void inorder() {
        inorder_Recursive(root);
    }

    protected void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }
}