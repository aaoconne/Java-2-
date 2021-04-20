import java.util.List;
import java.util.ArrayList;
import java.lang.Comparable;

public class Sorters2120 {

    public static <T extends Comparable<T>> void bubbleSort(List<T> theList) {
        int lastToConsider = theList.size();
        while (lastToConsider > 1) {
            for (int j = 0; j < lastToConsider - 1; j++) {
                if (theList.get(j).compareTo(theList.get(j + 1)) > 0) {
                    swap(theList, j, j + 1);
                }
            }
            lastToConsider--;
        }
    }

    private static <T extends Comparable<T>> void swap(List<T> theList, int i1, int i2) {

        T temp = theList.get(i1);
        theList.set(i1, theList.get(i2));
        theList.set(i2, temp);
    }

    /**
     * Method that takes theList and compares it to rest of elemennts.
     * @param theList is of type List. 
     * First for loop goes through array comparing first element to every other element. 
     * Inner for loop starts at the second element and repeats the same process.   
     */
    public static <T extends Comparable<T>> void selectionSort(List<T> theList) {
        for(int i = 0; i < theList.size() - 1; i++) {
            int min = i;
            for(int j = i + 1; j < theList.size(); j++) {
                if(theList.get(j).compareTo(theList.get(min)) < 0)
                    min = j;

            }
            if(min != i) {
                swap(theList, i, min);
            }
        }

        // stubbed

    }

    public static <T extends Comparable<T>> void mergeSort(List<T> theList) {
        recursiveMergeSortHelper(theList, 0, theList.size());
    }

    /**
     * Method that recusrively goes through List, find the middle point of the elements, 
     * sorts the left half, sorts the right half, then merges the two together.   
     * @param first being the first element.
     * @param last being last element.
     * @param merge merges the halves together.
     */
    private static <T extends Comparable<T>> void recursiveMergeSortHelper(List<T> theList, int first, int last) {
        int end = last - 1;
        if (first < end) {

            int middle = first + (end - first) / 2;

            recursiveMergeSortHelper(theList, first, middle + 1);
            recursiveMergeSortHelper(theList, middle + 1, last);

            merge(theList, first, middle, end);
        }
    }
    /**
     * Method that compares the left, middle, and right of list. 
     * @param left is the left side of the list.
     * @param middle is where the list will be broken into two parts. 
     * @param right is the right side of the given list. 
     */
    public static <T extends Comparable<T>> void merge(List<T> theList, int left, int middle, int right) {
        int middle2 = middle + 1;

        if (theList.get(middle).compareTo(theList.get(middle2)) <= 0) {
            return;
        }
        while (left <= middle && middle2 <= right) {
            if (theList.get(left).compareTo(theList.get(middle2)) <= 0) {
                left++;
            } else {
                T value = theList.remove(middle2);
                theList.add(left, value);
                left++;
                middle++;
                middle2++;
            }
        }
    }

    public static <T extends Comparable<T>> int indexOf(T searchItem, List<T> theList) {

        return recursiveBinarySearcher(searchItem, theList, 0, theList.size() - 1);

    }
    /**
     * Method that is used to help find the indexOf a particular element. 
     */
    private static <T extends Comparable<T>> int recursiveBinarySearcher(T searchItem, List<T> theList, int first,
            int last) {
        if (last >= first) {
            int mid = first + (last - first) / 2;

            if (theList.get(mid).compareTo(searchItem) == 0)
                return mid;

            if (theList.get(mid).compareTo(searchItem)>0)
                return recursiveBinarySearcher(searchItem, theList, first, mid - 1);
            else
                return recursiveBinarySearcher(searchItem, theList, mid + 1, last);
        }

        return -1;

    }
}
