import java.util.LinkedList;

public class Sort {

    public static LinkedList<Student> mergeSort(LinkedList<Student> toSort) {
    
            if (toSort == null) {
                return toSort;
            }
    
            if (toSort.size() > 1) {
                // Finds the middle of the list
                int mid = toSort.size() / 2;
    
                // split left half
                LinkedList<Student> left = new LinkedList<>();

                for (int i = 0; i < mid; i++) {
                    left.add(toSort.get(i));
                }
    
                // split right half
                LinkedList<Student> right = new LinkedList<>();

                for (int i = mid; i < toSort.size(); i++) {
                    right.add(toSort.get(i));
                }
                mergeSort(left);
                mergeSort(right);
    
                int i = 0; // index left
                int j = 0; // index right
                int k = 0; // index whole
    
                // merge left and right lists
                while (i < left.size() && j < right.size()) {
                    
                    //Returns negative for less than; zero for equal; positive for greater than
                    if (left.get(i).compareTo(right.get(j)) == -1) {
                        toSort.set(k, left.get(i));
                        i++;
                    } else {
                        toSort.set(k, right.get(j));
                        j++;
                    }
                    k++;
                }
    
                // remaining list elements
                while (i < left.size()) {
                    toSort.set(k, left.get(i));
                    i++;
                    k++;
                }
                while (j < right.size()) {
                    toSort.set(k, right.get(j));
                    j++;
                    k++;
                }
            }

        return toSort;
    }
}
