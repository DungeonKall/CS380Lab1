class Node{
	int value;
	Node left, right;

	public Node(int value){
		this.value = value;
		left = null;
		right = null;
	}

}

class BinarySearchTree{

	Node root;


	/*
    recursive insert method

    */
	   /*
	   inserts a node into the tree
	   */
	public void insert(int value){
		//tree is empty
		if(root == null){
			root = new Node(value);
			return;
		}else{
			Node current = root;
			Node parent = null;

			while(true){
				parent = current;

				if(value < current.value){
					current = current.left;
					if(current == null){
						parent.left = new Node(value);
						return;
					}
				}else{
					current = current.right;
					if(current == null){
						parent.right = new Node(value);
						return;
					}
				}

			}//closing while

		}//closing main if-else
	}

	/*
    pre-order traversal
    Prints the value of every node preorder
    */
	public void preOrderTraversal(Node root){
		//base case!
		if(root == null){
			return;
		}
		System.out.print(root.value+" ");

		//go left recursively
		preOrderTraversal(root.left);

		//go right recursively
		preOrderTraversal(root.right);
	}



	/*
    in-order traversal
    */
	public void inOrderTraversal(Node root){
		//base case!
		if(root == null){
			return;
		}

		//go left recursively
		inOrderTraversal(root.left);

		//process the root
		System.out.print(root.value+" ");

		//go right recursively
		inOrderTraversal(root.right);
	}



	   /*
	   post-order traversal
	   */

	public void postOrderTraversal(Node root){
		//implement in here
		if(root == null){
			return;
		}
		//go left recursively
		postOrderTraversal(root.left);
		//go right recursively
		postOrderTraversal(root.right);
		//process the root
		System.out.print(root.value+" ");
	}



	/*
    a method to find the node in the tree
    with a specific value

    -correction on assignment,
    method returns boolean, so its just to check
    if the node with such a key exists
    */
	public boolean find(Node root, int key){
		//implement in here
		if(root != null){
			//return the node if the keys match
			if(root.value == key){
				return true;
			}else{
				//search left and then right for a match
				find(root.left, key);
				find(root.right,key);
			}
		}else{
			//if the root is null, then there's no searching left
			return false;
		}
		//if we didn't find true, then must be false
		return false;

	}



	/*
    a method to find the node in the tree
    with a smallest key
    */
	public int getMin(Node root){
		//implement in here
		//return max if there's no root
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		//set up comparison vars, and search for left and right max
		int val = root.value;
		int leftval = getMin(root.left);
		int rightval = getMin(root.right);

		//if left smaller, store left val
		if (leftval < rightval){
			val = leftval;
		}
		//if right smaller, store right val
		if (rightval < val){
			val = rightval;
		}
		//returns min value in the tree
		return val;

	}



	/*
    a method to find the node in the tree
    with a largest key

    -correction of assignment,
    it returns int so this then searches for and returns
    the largest int
    */
	public int getMax(Node root){
		//implement in here
		//return min if there's no root
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		//set up comparison vars, and search for left and right max
		int val = root.value;
		int leftval = getMax(root.left);
		int rightval = getMax(root.right);

		//if left biggest, store left val
		if (leftval > rightval){
			val = leftval;
		}
		//if right biggest, store right val
		if (rightval > val){
			val = rightval;
		}
		//returns max value in the tree
		return val;
	}



	/*
    this method will not compile until getMax
    is implemented
    */
	public Node delete(Node root, int key){

		if(root == null){
			return root;
		}else if(key < root.value){
			root.left = delete(root.left, key);
		}else if(key > root.value){
			root.right = delete(root.right, key);
		}else{
			//node has been found
			if(root.left==null && root.right==null){
				//case #1: leaf node
				root = null;
			}else if(root.right == null){
				//case #2 : only left child
				root = root.left;
			}else if(root.left == null){
				//case #2 : only right child
				root = root.right;
			}else{
				//case #3 : 2 children
				root.value = getMax(root.left);
				root.left = delete(root.left, root.value);
			}
		}
		return root;
	}



}



public class TreeDemov2{
	public static void main(String[] args){
		BinarySearchTree t1  = new BinarySearchTree();
		t1.insert( 24);
		t1.insert(80);
		t1.insert(18);
		t1.insert(9);
		t1.insert(90);
		t1.insert(22);

		System.out.print("in-order :   ");
		t1.inOrderTraversal(t1.root);
		System.out.println();


	}
}
