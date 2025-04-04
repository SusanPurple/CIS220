// Susan Meinhardt
// Chpt7 PA
class BSTNode {
    int key;
    BSTNode left, right;
	
	// Constructor to initialize a new BST node with a given key
    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BST {
    private BSTNode root;

	// Construct to initialize an empty BST
    public BST() {
        root = null;
    }
	
	// Getter method to access the root node
	public BSTNode getRoot() {
		return root;
	}

	// Implement the BSTSearchRecursive PseudoCode found in PA 7.9.1
    public BSTNode searchRecursive(BSTNode node, int key) {
		if (node != null) {
			if (key == node.key) {
				return node;
			} else if (key < node.key) {
				return searchRecursive(node.left, key);
			} else {
				return searchRecursive(node.right, key);
			}
		}
		return null;
    }
	
	// Implement the BSTSearch PseudoCode found in PA 7.9.1
	public BSTNode search(int key) {
		return searchRecursive(root, key);
	}

	// Checks if the tree contains a node with the given key
    public boolean contains(int key) {
        return search(key) != null;
    }

	// Inserts a key into the BST if it does not already exist
    public boolean insertKey(int key) {
        if (contains(key)) {
            return false; // Duplicate keys not allowed
        }
		// Create a new node
        BSTNode newNode = new BSTNode(key);
		// Call insertNode method
        insertNode(newNode);
        return true;
    }
	
	// Implement the BSTInsertNode PseudoCode found in Fig. 7.9.2
	private void insertNode(BSTNode node) {
		if (root == null) {
			root = node;
		} else {
			insertRecursive(root, node);
		}
	}

	// Implement the BSTInsertRecursive PseudoCode found in Fig. 7.9.2
    private void insertRecursive(BSTNode parent, BSTNode nodeToInsert) {
		if (nodeToInsert.key < parent.key) {
			if (parent.left == null) {
				parent.left = nodeToInsert;
			} else {
				insertRecursive(parent.left, nodeToInsert);
			}
		} else {
			if (parent.right == null) {
				parent.right = nodeToInsert;
			} else {
				insertRecursive(parent.right, nodeToInsert);
			}
		}
	}
	
	// Implement a printInReverseOrder method discussed in Section 7.7 
	public void printInReverseOrder(BSTNode node) {
		if (node == null) {
			return;
		}
		printInReverseOrder(node.right);
		System.out.print(node.key + " ");
		printInReverseOrder(node.left);
	}

	// Implement the main method based on the program instructions
	public static void main(String[] args) {
		// initialize variables
		int searchKey = 0;
		int i = 0;
		
		// Insert the keys into the BST in the order listed.
		BST tree = new BST();
		int[] keys = {35, 41, 13, 57, 3, 83, 88, 51, 38, 20, 11, 22, 27, 21, 48, 8};
		for (i = 0; i < keys.length; i++) {
			tree.insertKey(keys[i]);
		}
		
		//  Call the printInReverseOrder method
		System.out.println("Binary Search Tree After Inserts:");
		tree.printInReverseOrder(tree.getRoot());
		System.out.println("\n");
		
		// Call the print2D method found in the BSTPrint class
		BSTPrint.print2D(tree.getRoot());
		System.out.println();
		
		// Search for an existing key: 27 and check the return value to see if it was found
		searchKey = 27;
		if (tree.contains(searchKey)) {
			System.out.println("Found node with key = " + searchKey + ".");
		} else {
			System.out.println("Key " + searchKey + " not found.");
		}
		
		System.out.println();
		
		// Search for a non-existing key: 89 and check the return value to see if it was found
		searchKey = 89;
		if (tree.contains(searchKey)) {
			System.out.println("Found node with key = " + searchKey + ".");
		} else {
			System.out.println("Key " + searchKey + " not found.");
		}
		
		
	}
}