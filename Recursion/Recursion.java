import java.util.ArrayList;

/**
 * Recusion class
 * provides two methods to compare string and find the smallest string in a list.
 */
public class Recursion{
    /**
     * Comparing two strings.
     * @param s1 a string 
     * @param s2 another string  
     * @return 0 if s1 and s2 are equal. -1, if s1 is less than. 
     */
    public static int compareTo(String s1, String s2){
        if(s1.length() == 0 && s2.length() == 0)
        return 0; 
        
        if(s1.length() > 0 && s2.length() == 0)
        return 1;

        if(s1.length() == 0 && s2.length() > 0)
        return -1; 

        s1 = s1.toLowerCase(); 
        s2 = s2.toLowerCase();
        char fs1 = s1.charAt(0);
        char fs2 = s2.charAt(0);
        if(fs1 < fs2)
        return -1; 
            
            else if(fs1 > fs2)
        return 1; 

        else{
           return compareTo(s1.substring(1), s2.substring(1));
        }
    }

    /**
     * Finds the smallest(alphabetically) string in a list
     * @param stringArray the array from where the smalles word is to be found
     * @return the smallest word in the list. 
     */
    public static String findMinimum(ArrayList<String> stringArray){
        String ret = "";
        if(stringArray.size() == 1)
        ret = stringArray.get(0);
        if(stringArray.size() >= 2){
            String fs1 = stringArray.get(0);
            ArrayList sublist = new ArrayList(stringArray);
            sublist.remove(0);
            String fs2 = findMinimum(sublist);
            int result = fs1.compareTo(fs2);
            if(result <= 0)
            return fs1;
            else return fs2;
        }
        return ret;
    }
}