public class Iterator<T> {

    private LinkedList<T> myList;
    private LinkedList<T>.Node myCurrentNode;

    public Iterator(LinkedList<T> list) {
        myList = list;
        myCurrentNode =  myList.itsFirstNode;
    }

    // return true if there is a "next" element, otherwise returns false
    public boolean hasNext() {
        if (myCurrentNode != null)
            return true;
        return false;
    }

    // TO BE IMPLEMENTED
    // return true if there is a "prior" element, otherwise returns false
    
    /**
     * Method that ensures through the use of a boolean that there is a prior node. 
     * @return will return true if there is a prior element but will return flase if otherwise. 
     */
    public boolean hasPrior() {
        if (myCurrentNode != null)
            return true;
        return false;
    }


    // returns the "next" node (really the current one) and
    // moves the Iterator forward by one node
    public T next() {
        T data = myCurrentNode.getData();
        myCurrentNode = myCurrentNode.getNextNode();
        return data;
    }

    // TO BE IMPLEMENTED 
    // returns the "prior" node (really the current one) and
    // moves the Iterator backward by one node

    /**
     * Method that moves the iterator backwards. 
     * @return will return the prior node which is really the current one. 
     */
    public T prior() {
        T data1 = myCurrentNode.getData();
        myCurrentNode = myCurrentNode.getPriorNode();
        return data1;

    }

    // Sets this iterator to point to the last Node in the list

    /**
     * Method that sets the iterator to point to the end of the list. 
     */
    public void setToEnd() {
        while(hasNext()){
            if(myCurrentNode.getNextNode() == null) {
                break;
            } else {
                next();
            }
        }
    }
    
}
