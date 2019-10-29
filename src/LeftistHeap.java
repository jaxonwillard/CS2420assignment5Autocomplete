public class LeftistHeap<Node> {
    HeapNode root;
    HeapNode[] array;

//    public String deleteMax(){
//        return value;
//    }

    public void insert(String word, int priority){
        Term node = new Term(word, priority);
//        insertNode(this.root, node);
    }

    private void insertNode(HeapNode root, HeapNode node){
        if (this.root == null){
            this.root = node;
            return;}
        if (root.right != null){
            insertNode(root.right, node);
        }
        root.right = node;
    }






//    @Override
//    public String toString() {
//        if (root == null)
//            return (" Empty tree\n");
//        else
////            System.out.println(this.treeName);
//        return toString(this.root, "", "", "");
//    }
//
//    /**
//     * Return string displaying the tree contents as a tree
//     * complexity: O(n)
//     * @param node
//     * @param toReturn
//     * @param recLevel
//     * @param parentElement
//     * @return
//     */
//
//    public String toString(BinaryNode node, String toReturn, String recLevel, String parentElement){
//        recLevel = recLevel + " ";
//        if(parentElement == ""){
//            parentElement = "no parent";
//        }
//        if (node.right != null){
//            toReturn = toString(node.right, toReturn, recLevel, node.element.toString());
//        }
////        System.out.println(node.element);
//        toReturn = toReturn + recLevel + node.element.toString() + "[" + parentElement + "]" + recLevel + "\n";
//        if (node.left != null){
////            toStrong(node.left);
//            toReturn = toString(node.left, toReturn, recLevel, node.element.toString());
//        }
//        return toReturn;
//    }
//
//
//
//

















    private static class HeapNode<Node>{
        private HeapNode left;
        private HeapNode right;
        private Node term;
        HeapNode(Node node){
             this.term = node;
        }
    }
}
