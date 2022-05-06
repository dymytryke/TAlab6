
class AVLTree extends BinaryTree {
    private Node root;

    private int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }


    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    @Override
    public void insert(int key) {
        root = insert_Recursive(root, key);
    }

    @Override
    protected Node insert_Recursive(Node root, int key) {

        if (root == null)
            return (new Node(key));

        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);
        else
            return root;

        root.height = 1 + max(height(root.left),
                height(root.right));

        int balance = getBalance(root);


        if (balance > 1 && key < root.left.key)
            return rightRotate(root);

        if (balance < -1 && key > root.right.key)
            return leftRotate(root);

        if (balance > 1 && key > root.left.key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && key < root.right.key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    @Override
    public void delete(int key) {
        root = delete_Recursive(root, key);
    }

    @Override
    protected Node delete_Recursive(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = delete_Recursive(root.left, key);

        else if (key > root.key)
            root.right = delete_Recursive(root.right, key);

        else {

            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {


                Node temp = minValueNode(root.right);


                root.key = temp.key;


                root.right = delete_Recursive(root.right, temp.key);
            }
        }


        if (root == null)
            return root;


        root.height = max(height(root.left), height(root.right)) + 1;


        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    @Override
    public void inorder() {
        super.inorder_Recursive(this.root);
    }

}