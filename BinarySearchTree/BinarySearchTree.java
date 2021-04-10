// Written by Arsyi Syarief Aziz
// H071191003

public class BinarySearchTree {
    
    Node rootNode;

    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            // Reached a leaf, so add the new node
            return new Node(key);
        }

        if (key < node.key ) {
            node.left = insert(node.left , key);
        } else if (key > node.key) {
            node.right = insert(node.right,  key);
        }

        return node;
    }

    /**
     * Insert a node into the binary search tree
     * @param key
     */
    public void insert(int key) {
        rootNode = insert(rootNode, key);
    }

    private Node search(Node node, int key) {
        if (node == null) {
            // Couldn't find the node
            return null;
        }

        if (node.key == key) {
            // Found the node
            System.out.print(node.key);
            return node;
        }
        System.out.print(node.key);
        
        if (node.left != null || node.right != null) {
            System.out.print(" -> ");
        }
        if (key < node.key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * Search for the node with a specific key value
     * @param key
     */
    public void search(int key) {
        System.out.printf("Searching for node with key %d...\n",key);
        Node node = search(rootNode, key);
        System.out.println();

        if (node == null) {
            System.out.printf("Couldn't find node with key %d\n", key);
            return;
        }

        System.out.printf("Found node with key %d at address %s\n", key, node);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            // Couldn't find the node
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // The current node's key value is the same as the specified node's key value that is to be deleted

            if (node.left == null) {
                // One child deletion

                // Replace the deleted node with its right child
                return node.right;
            } else if (node.right == null) {
                // One child deletion

                // Replace the deleted node with its left child
                return node.left;
            } else {
                // Two child deletion

                // Find the right childs minimum value and set it to replace the to be deleted node's key
                // This is because the left child with the minimum value always has a null left child
                node.key = min(node.right);

                // Delete the minimum value node as there are two
                node.right = delete(node.right, node.key);
            }
        }
        return node;
        
    }

    /**
     * Delete a node based on it's key value
     * @param key
     */
    public void delete(int key) {
        rootNode = delete(rootNode, key);
    }

    private int max(Node node) {
        if (node == null) {
            // Reached a leaf
            return Integer.MIN_VALUE;
        }

        int maxLeft = max(node.left);   // Maximum value of the left child
        int maxRight = max(node.right); // Maximum value of the right child
        int max;                        // Maximum value of both left and right children
        
        if (maxLeft >= maxRight) {
            max = maxLeft;
        } else {
            max = maxRight;
        }

        if (node.key > max) {
            // The current node's key value is greater than its child's max value
            return node.key;
        } else {
            // The current node's key value is less than or equal to its child's max value
            return max;
        }
        
    }

    /**
     * Finds the maximum valued key in the binary search tree
     * @return maximum value key
     */
    public int max() {
        return max(rootNode);
    }

    private int min(Node node) {
        if (node == null) {
            // Reached a leaf
            return Integer.MAX_VALUE;
        }
        int minLeft = min(node.left);   // Minimum value of the left child
        int minRight = min(node.right); // Minimum value of the left child
        int min;                        // Minimum value of both left and right children
        
        if (minLeft <= minRight) {
            min = minLeft;
        } else {
            min = minRight;
        }

        if (node.key < min) {
            // The current node's key value is less than its child's max value
            return node.key;
        } else {
            // The current node's key value is greater than or equal to its child's max value
            return min;
        }

    }

    /**
     * Finds the minimum valued key in the binary search tree
     * 
     * @return minimum value key
     */
    public int min() {
        return min(rootNode);
    }
    
    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.printf("%d ", node.key);
    }

    /**
     * Prints out all the node key values using postorder traversal
     */
    public void postOrderTraversal() {
        postOrderTraversal(rootNode);
        System.out.println();
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d ", node.key);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * Prints out all the node key values using preorder traversal
     */
    public void preOrderTraversal() {
        preOrderTraversal(rootNode);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.printf("%d ", node.key);
        inOrderTraversal(node.right);
    }

    /**
     * Prints out all the node key values using inorder traversal
     */
    public void inOrderTraversal() {
        inOrderTraversal(rootNode);
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(20);
        binarySearchTree.insert(14);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);

        System.out.println("Initial values");
        binarySearchTree.preOrderTraversal();
        System.out.println();

        System.out.println("After deleting 8");
        binarySearchTree.delete(8);
        binarySearchTree.preOrderTraversal();
        System.out.println();

        System.out.println("After deleting 20");
        binarySearchTree.delete(20);
        binarySearchTree.preOrderTraversal();
        System.out.println();

        System.out.println("After deleting 6");
        binarySearchTree.delete(6);
        binarySearchTree.preOrderTraversal();
        System.out.println();
        

        System.out.print("Max value key: ");
        System.out.println(binarySearchTree.max());
        System.out.println();
        
        System.out.print("Min value key: ");
        System.out.println(binarySearchTree.min());
        System.out.println();

        
        binarySearchTree.search(6);
        System.out.println();

        binarySearchTree.search(7);
        System.out.println();

        System.out.println("Preorder traversal");
        binarySearchTree.preOrderTraversal();
        System.out.println();

        System.out.println("Inorder traversal");
        binarySearchTree.inOrderTraversal();
        System.out.println();

        System.out.println("Postorder traversal");
        binarySearchTree.postOrderTraversal();
        System.out.println();

    }
}