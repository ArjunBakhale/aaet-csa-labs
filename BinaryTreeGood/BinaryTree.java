public class BinaryTree {
    protected class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    protected Node root;

    //constructors
    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(int data) {this.root = new Node(data);}

    //methods

    /*
    * • Public API
    * • calls insert_recursive(Node root, int data)
    */
    public void insert(int data){
        insert_recursive(root, data);
    }

    private Node insert_recursive(Node node, int data){
        if(node == null){
            return new Node(data);
        }

        if(data<node.data){
            node.left = insert_recursive(node.left, data);
        }
        else if(data >= node.data){
            node.right = insert_recursive(node.right, data);
        }

        return new Node(data);

    }

    public String in_order_traversal(){
        return in_order_traversal(root, "");
    }

    private String in_order_traversal(Node node, String s){
        if(node == null){
            return s;
        }

        if(node.left!= null){
            s = in_order_traversal(node.left, s);
        }
        s += node.data;

        if(node.right != null){
            in_order_traversal(node.right, s);
        }

        return s;
    }

    //analysis
    public int count_nodes(){
        return count_nodes_recursive(root);
    }

    private int count_nodes_recursive(Node node){
        if(node == null){
            return 0;
        }
        return 1+count_nodes_recursive(node.left)+count_nodes_recursive(node.right);
    }

    public int depth(){
        return depth_recursive(root);
    }

    private int depth_recursive(Node node){
        if(node == null){
            return 0;
        }
        return 1+ Math.max(count_nodes_recursive(node.left),count_nodes_recursive(node.right));
    }




}