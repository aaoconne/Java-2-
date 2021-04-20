package HW2; 
public class MyObservable{
    private MyObserver[] observers;
    private int numObservers; 
    private boolean hasChanged;

    
    public MyObservable(){
        observers = new MyObserver[10];
        hasChanged = false; 
        numObservers = 0; 

    }

    /**
        Adds new observers to the observe list of this observable class.
        @param o The observer that we want to add.
    */
    public void addObserver(MyObserver o){
        if(numObservers == observers.length){
            MyObserver[] temp = new MyObserver[observers.length + 10];
            for(int i = 0; i < observers.length; i++){
                temp[i] = observers[i];
            }
            observers = temp; 
        }
        observers[numObservers] = o;
        numObservers++;
    }
    /**
        Returns the changed state of hasChanged.
        @return the value of the new state.
     */
    protected void clearChanged(){
        hasChanged = false; 
    }
    /**
     *  Returns the changed Observable.
     *  @return the new value of the Observable. 
     */ 
    protected void setChanged(){
        hasChanged = true; 
    }

    /**
        Returns the number of observers in this class.
        @return the number of observers.
    */
    public int countObservers(){
        return numObservers;
    }
    /**
     * Returns true if the state has changed. 
     * @return the value of the state. 
     */
    public boolean hasChanged(){
        return hasChanged;
    }
    /**
     * Returns the incremented Obersever.
     * @return the updated value to the Observer. 
     */
    public void notifyObservers(){
        if(hasChanged) {
            for(int i = 0; i < numObservers; i++){
                (observers[i]).update(this , "Observer notified");
            }
        }
        clearChanged();
    }
    /**
     * Returns the value of the notified observers. 
     * @return arg any object. 
     */ 
    public void notifyObservers(Object arg){
        if(hasChanged) {
            for(int i = 0; i < numObservers; i++){
                (observers[i]).update(this , arg);
            }
        }
        clearChanged();
     }

}