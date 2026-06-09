class Node {
    int id, height;
    Node left, right;

    Node(int id) {
        this.id = id;
        height = 1;
    }
}

public class AVLTree {

    int height(Node n) {
        return n == null ? 0 : n.height;
    }

    int getBalance(Node n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int id) {

        if (node == null)
            return new Node(id);

        if (id < node.id)
            node.left = insert(node.left, id);
        else if (id > node.id)
            node.right = insert(node.right, id);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && id < node.left.id)
            return rightRotate(node);

        if (balance < -1 && id > node.right.id)
            return leftRotate(node);

        if (balance > 1 && id > node.left.id) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && id < node.right.id) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.id + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();
        Node root = null;

        root = tree.insert(root, 101);
        root = tree.insert(root, 102);
        root = tree.insert(root, 103);
        root = tree.insert(root, 104);

        System.out.println("Patient Records:");
        tree.inorder(root);
    }
}