public class LinkedList<T>  {


    Node itsFirstNode;
    Node itsLastNode;
    private int size;


    public LinkedList() {
        itsFirstNode = null;
        itsLastNode = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }
    
    public Iterator<T> getIterator() {
        return new Iterator<T>(this);
    }
    /**
     * Method that sets a a refrence from the previous node to the node after. 
     */
    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element) {

        Node node = new Node(element);

        if (itsFirstNode == null) {
            itsFirstNode = node;
            itsLastNode = node;
        }
        else {
            itsLastNode.setNextNode(node);
            node.setPriorNode(itsLastNode);
            itsLastNode = node;
        }
        size++;
    }
    /**
     * Method that keeps an index of the previous and next node. 
     */
    // THIS WILL NEED TO BE MODIFIED FOR DOUBLY LINKED LIST
    public void add(T element, int index) {
        int counter = 0;
        Node newNode = new Node(element);
        Node current = itsFirstNode;
        Node prior;
        while (current != null )
         {
            if (counter == index - 1 )
                break;
            current = current.getNextNode();
            counter++;
        }
        newNode.setNextNode(current.getNextNode());
        (current.getNextNode()).setPriorNode(newNode);
        newNode.setPriorNode(current);
        current.setNextNode(newNode);
        size++;
    }
    /** 
     * Method that obtains the current node.
     * @param index is used to keep a counter of where we are in the list. 
     */
    public T get(int index) {
        int counter = 0;
        Node current = itsFirstNode;
        while (current != null ) {
            if (counter == index)
                break;
            current = current.getNextNode();
            counter++;
        }
        return current.getData();
    }

    // TO BE IMPLEMENTED
    // returns true if element is in the list, false if not
    /**
     * Method that makes sure there is a node next to the previous node. 
     * @param element used to create an element that is in the list. 
     * @return returns true if element is in the list, false if not. 
     */
    public boolean contains(T element) {
        Node current = itsFirstNode;
        while (current != null ) {
            if (current.getData() == element)
                return true;
            current = current.getNextNode();
        }
        return false;
    }

    // returns the index of the element if it is in the list, -1 if not found
    public int indexOf(T element) {
        int counter = 0;
        Node current = itsFirstNode;
        while (current != null ) {
            if (current.getData() == element)
             return counter;
            current = current.getNextNode();
            counter++;
        }
        return -1;
    }

    // returns an Iterator at the location of the element if it is in the list
    // returns the null reference if the element is not found
    public Iterator<T> iteratorAt(T element) {
        Iterator<T> iter = new Iterator<T>(this);
        while (iter.hasNext()) {
            if (iter.next() == element) {
                return iter;
            }
        }
        return null;
    }
    

    public String toString() {
        String returnVal = "";
        Node current = itsFirstNode;
        if (size != 0 ) {
            while (current != null ) {
                returnVal += current.toString();
                returnVal += "\n";
                current = current.getNextNode();
            }
        }
        return returnVal;
    }  // end toString

    class Node {
    
        private T data;
        private Node itsNext;
        private Node itsPrior;
    
        public Node(T data) {
            itsNext = null;
            itsPrior = null;
            this.data = data;
        }
    
    
        public T getData() {
            return this.data;
        }
    
        public Node getNextNode() {
            return itsNext;
        }

        // TO BE IMPLEMENTED
        
        /**
         * Method that retrieves the prior node. 
         * @return will return the prior node. 
         */
        public Node getPriorNode() {
            return itsPrior;
        }
        
    
        public void setNextNode(Node next) {
            itsNext = next;
        }

        // TO BE IMPLEMENTED

        /**
         * Method that sets a prior node. 
         * @param prior used to set the prior node. 
         */
        public void setPriorNode(Node prior) {
            itsPrior = prior; 
        }
        
        public String toString() {
            return data.toString();
        }
    
    }  // end of Node
}
