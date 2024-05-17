public class BubbleSort {

    public static void sort(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
          if (arr[j] > arr[j + 1]) {
            // Swap elements if they are not in order
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
          }
        }
      }
    }
  
    public static void main(String[] args) {
      int[] arr = {64, 25, 12, 22, 11};
      System.out.println("Unsorted array: ");
      for (int i : arr) {
        System.out.print(i + " ");
      }
  
      sort(arr);
  
      System.out.println("\nSorted array: ");
      for (int i : arr) {
        System.out.print(i + " ");
      }
    }
  }
  