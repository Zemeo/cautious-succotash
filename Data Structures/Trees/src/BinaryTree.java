/**
 *
 */
public class BinaryTree{

    public Node root;

    /**
     *  When creating a new BinaryTree the root Node is set to null to signify an empty tree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Method to add a value to the BinaryTree
     *
     * @param value The value to be assigned to a Node and inserted
     */
    public void addNode(int value){
        Node newNode = new Node(value);
        if(root==null){
            root = newNode;
        }else{
            Node parent = findNode(value);
            if(parent.value > value){
                parent.left = newNode;
                newNode.parent = parent;
            }else{
                parent.right = newNode;
                newNode.parent = parent;
            }
        }
    }

    /**
     *  Method to remove a value from the BinaryTree
     *
     * @param value The value that is to be deleted     *
     * @return  returns true if the value was deleted and false if not
     */
    public boolean removeNode(int value) {
        Node temp = findNode(value);
        if (temp.value != value) {
            return false;
        } else {

            //no children
            if (temp.right == null && temp.left == null) {
                if (temp == root) {
                    root = null;
                } else if (temp.value < temp.parent.value) {
                    temp.parent.left = null;
                } else {
                    temp.parent.right = null;
                }
                return true;
            } else if (temp.right != null ^ temp.left != null) {
                //one child
                if (temp.right != null) {
                    //has right child
                    if (temp == root) {
                        root = temp.right;
                    } else if (temp.value < temp.parent.value) {
                        temp.parent.left = temp.right;
                    } else {
                        temp.parent.right = temp.right;
                    }
                    return true;
                } else {
                    //has left child
                    if (temp == root) {
                        root = temp.left;
                    } else if (temp.value < temp.parent.value) {
                        temp.parent.left = temp.left;
                    } else {
                        temp.parent.right = temp.left;
                    }
                    return true;
                }
            } else {
                Node successor = findSuccessor(temp);

                //left tree of temp is made left tree of successor
                successor.left = temp.left;
                successor.left.parent = successor;

                //if successor had a right child it becomes the child of its grandparent
                if (successor.right != null && successor.parent != temp) {
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                }

                if(temp == root){
                    successor.parent = null;
                    root = successor;
                }
                return true;
            }
        }
    }

    /**
     * Method to find a replacement for a deleted Node
     * To find the successor of a Node you have to find the lowest value child in its right subtree
     *
     * @param temp The Node that is to be succeeded
     * @return  The successor Node
     */
    public Node findSuccessor(Node temp){
        Node successor = temp.right;
        Node current = temp.right;
        while(current != null){
            successor = current;
            current = current.left;
        }
        return successor;
    }

    /**
     * Method to find a Node with a certain value
     *
     * @param value The value to be found
     * @return  Returns the Node containing that value otherwise returns closest match
     */
    public Node findNode(int value){
        Node current = root;
        while(current != null){
            if(current.value < value){
                if(current.right != null){
                    current = current.right;
                }else{
                    return current;
                }
            }else if(current.value > value){
                if(current.left != null){
                    current = current.left;
                }else{
                    return current;
                }
            }else{
                return current;
            }
        }
        return null;
    }

    /**
     * Method to print out all values within the tree
     * Left, Root, Right
     *
     * @param rootNode the root Node for output
     */
    public void inOrder(Node rootNode){
        if(rootNode != null){
            inOrder(rootNode.left);
            System.out.print(rootNode.value + ", ");
            inOrder(rootNode.right);
        }
    }

    /**
     * Method to print out all values within the tree
     * Root, Left, Right
     *
     * @param rootNode the root Node for output
     */
    public void preOrder(Node rootNode){
        if(rootNode != null){
            System.out.print(rootNode.value + ", ");
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    /**
     * Method to print out all values within the tree
     * Left, Right, Root
     *
     * @param rootNode the root Node for output
     */
    public void postOrder(Node rootNode){
        if(rootNode != null){
            postOrder(rootNode.left);
            postOrder(rootNode.right);
            System.out.print(rootNode.value + ", ");
        }
    }

    /**
     *  This class is the implementation of the Nodes used by a BST, each Node stores a value, it's parent Node and if applicable it's left and right child Nodes
     */
    private class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        /**
         * @param value the value that is stored within this Node
         */
        public Node(int value) {
            this.value = value;
        }
    }
}



