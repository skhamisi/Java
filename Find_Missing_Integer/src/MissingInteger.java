public class MissingInteger {

    public static int findMissingInteger(int[] arr) {
        int n = arr.length + 1; // Size of the original range
        boolean[] present = new boolean[n + 1]; // Boolean array to mark presence
        
        // Mark each integer in the array as present
        for (int num : arr) {
            present[num] = true;
        }
        
        // Find the missing integer
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i; // Found missing integer
            }
        }
        
        return -1; // No missing integer found (should not happen for valid input)
    }

    public static void main(String[] args) {

        int[] array = {3, 6, 5, 1, 4}; // Example array

        int missing = findMissingInteger(array);

        System.out.println("The missing integer is: " + missing);
    }
}
