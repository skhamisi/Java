public class RadixSort {

    public static void radixSort(int[] arr) {
      // Start by finding the maximum value
      int max = arr[0];
      for (int i : arr) {
        max = Math.max(max, i);
      }
  
      // Calculate the number of passes
      int d = (int) Math.log10(max) + 1;
  
      // Use counting sort for each number
      for (int i = 1; i <= d; i++) {
        countingSortByDigit(arr, i);
      }
    }
  
    private static void countingSortByDigit(int[] arr, int digit) {
      int n = arr.length;
      int[] count = new int[10];
      int[] output = new int[n];
  
      // Count occurrences of each digit
      for (int i = 0; i < n; i++) {
        int index = (arr[i] / (int) Math.pow(10, digit - 1)) % 10;
        count[index]++;
      }
  
      for (int i = 1; i < 10; i++) {
        count[i] += count[i - 1];
      }
  
      for (int i = n - 1; i >= 0; i--) {
        int index = (arr[i] / (int) Math.pow(10, digit - 1)) % 10;
        output[count[index] - 1] = arr[i];
        count[index]--;
      }
  
      // Copy output to original array
      System.arraycopy(output, 0, arr, 0, n);

      
    }

    // Used to clear the console screen prior to displaying the output
    public static void ClearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
  
    public static void main(String[] args) {

      ClearScreen();

      int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
      radixSort(arr);
      System.out.println("Sorted array:");
      for (int i : arr) {
        System.out.print(i + " ");
      }
    }
  }
  