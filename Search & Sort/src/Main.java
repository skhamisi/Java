// Java implementation of recursive Binary Search
class BinarySearch {

    /**
     * @param l = the array index where you want to start the search, usually 0
     * @param r = the length of the array - 1
     * @param x = the element that you are searching for
     * @return -1 = the element is not in the array
     */
    static int binarySearch(int[] array, int l, int r, int x) {

        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (array[mid] == x) {
                return mid;
            }

            // If x is smaller than mid, search left subarray
            else if (array[mid] > x) {
                return binarySearch(array, l, mid - 1, x);
            }

            // Else search right subarray
            return binarySearch(array, mid + 1, r, x);
        }
        return -1;
    }

    static int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 1; j < n - i; j++) {

                if (arr[j - 1] > arr[j])
                {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

	public static void main(String args[]) {
    
		int arr[] = { 10, 20, 30, 40, 50 };
		int n = arr.length;
		int x = 20;
		int binaryResult = binarySearch(arr, 0, n - 1, x);

		if (binaryResult == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element found at index " + binaryResult);
        }

        int[] arr2 = {45, 29, 100, 67, 1, 40};
        int[] sortedArray = bubbleSort(arr2);

        for (int i : sortedArray) {
            System.out.print(i + "\n");
        }
	}
}

