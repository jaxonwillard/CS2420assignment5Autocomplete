public class LeftistSkewHeap <AnyType extends Comparable<? super AnyType>> {
    public int size = 0;
    SkewNode<AnyType> root;
    public LeftistSkewHeap(){
        this.root = null;
    }
    public void insert(AnyType newNode) {
        this.size++;
        root = merge(new SkewNode<>(newNode), root);
    }
    public AnyType deleteMax() {
        if (isEmpty()){
            System.out.println("tree empty");
            return null;}
        this.size--;
        AnyType maxItem = root.element;
        root = merge(root.left, root.right);

        return maxItem;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private SkewNode<AnyType> merge(SkewNode<AnyType> node1, SkewNode<AnyType> node2) {
        if (node1 == null){
            return node2;}
        if (node2 == null){
            return node1;}
        if (node1.element.compareTo(node2.element) > 0){
            return mergeHelper(node1, node2);}
        else{
            return mergeHelper(node2, node1);}
    }

    private SkewNode<AnyType> mergeHelper(SkewNode<AnyType> node1, SkewNode<AnyType> node2) {
        if (node1.left == null) {
            node1.left = node2;
        }
        else {
            node1.right = merge(node1.right, node2);
            swapChildren(node1);
        }
        return node1;
    }
    private static <AnyType> void swapChildren(SkewNode<AnyType> parent) {
        SkewNode<AnyType> tmp = parent.left;
        parent.left = parent.right;
        parent.right = tmp;
    }

    public String toString(){
        return toString(this.root, "" , "", "");
    }

    private String toString(SkewNode node, String toReturn, String recLevel, String parentElement) {
        recLevel = recLevel + "-- ";
        if (parentElement == "") {
            parentElement = "no parent";
        }
        if (node.right != null) {
            toReturn = toString(node.right, toReturn, recLevel, node.element.toString());
        }
//        System.out.println(node.element);
        toReturn = toReturn + recLevel + node.element.toString() + "[" + parentElement + "]" + recLevel + "\n";
        if (node.left != null) {
//            toStrong(node.left);
            toReturn = toString(node.left, toReturn, recLevel, node.element.toString());
        }
        return toReturn;
    }






    private static class SkewNode<AnyType> {
        AnyType element;
        SkewNode<AnyType> left;
        SkewNode<AnyType> right;

        SkewNode(AnyType element){
            this(element, null, null);
        }

        SkewNode(AnyType element, SkewNode<AnyType> left, SkewNode<AnyType> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    }
