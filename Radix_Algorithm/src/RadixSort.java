public class RadixSort {

  // Radix sort function to sort an array of integers
  public static void radixSort(int[] arr) {

    // Find the maximum value in the array
    int max = arr[0];
    for (int i : arr) {
      max = Math.max(max, i);
    }

    // Calculate the number of digits needed to represent the maximum value (plus 1 for the ones digit)
    int d = (int) Math.log10(max) + 1;

    // Sort the array by digit position, one digit at a time from least significant digit (LSD) to most significant digit (MSD)
    for (int i = 1; i <= d; i++) {
      countingSortByDigit(arr, i);
    }
  }

  // Counting sort by digit function used as a helper function in radix sort
  private static void countingSortByDigit(int[] arr, int digit) {
    int n = arr.length;

    int[] count = new int[10];

    int[] output = new int[n];

    // Count the occurrences of each digit in the current digit position (given by 'digit')
    for (int i = 0; i < n; i++) {
      // Get the digit at the specified position (digit - 1) using modulo operation and division
      int index = (arr[i] / (int) Math.pow(10, digit - 1)) % 10;
      count[index]++;
    }

    // Calculate cumulative sums for the count array. This is used to determine the position of each element in the output array
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // Fill the output array by placing elements in their sorted positions based on their digit at the current position
    for (int i = n - 1; i >= 0; i--) {
      int index = (arr[i] / (int) Math.pow(10, digit - 1)) % 10;
      output[count[index] - 1] = arr[i];
      count[index]--;
    }

    // Copy the sorted elements from the output array back to the original array
    System.arraycopy(output, 0, arr, 0, n);
  }

  // Function to clear the console screen (optional)
  public static void ClearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void main(String[] args) {

    // Clear the screen (optional)
    ClearScreen();

    int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};

    // Sort the array using Radix Sort
    radixSort(arr);

    System.out.println("Sorted array:");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
