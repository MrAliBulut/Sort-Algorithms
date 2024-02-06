public class Merge implements ISort {
    
    // Method to sort the array in ascending order.
    @Override
    public int[] minOrder(int[] array) {
        int length = array.length;

        // Base case: if the array has 0 or 1 element, it is already sorted.
        if (length <= 1) {
            return array;
        }

        // Find the midpoint of the array.
        int midPoint = array.length / 2;

        // Divide the array into two subarrays.
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[length - midPoint];

        // Populate left and right subarrays.
        for (int i = 0; i < midPoint; i++) {
            leftArray[i] = array[i];
        }

        for (int i = 0; i < length - midPoint; i++) {
            rightArray[i] = array[midPoint + i];
        }

        // Recursively sort the left and right subarrays.
        leftArray = minOrder(leftArray);
        rightArray = minOrder(rightArray);

        // Merge the sorted subarrays.
        return merge(array, leftArray, rightArray, false);
    }

    // Method to sort the array in descending order.
    @Override
    public int[] maxOrder(int[] array) {
        int length = array.length;

        // Base case: if the array has 0 or 1 element, it is already sorted.
        if (length <= 1) {
            return array;
        }

        // Find the midpoint of the array.
        int midPoint = array.length / 2;

        // Divide the array into two subarrays.
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[length - midPoint];

        // Populate left and right subarrays.
        for (int i = 0; i < midPoint; i++) {
            leftArray[i] = array[i];
        }

        for (int i = 0; i < length - midPoint; i++) {
            rightArray[i] = array[midPoint + i];
        }

        // Recursively sort the left and right subarrays.
        leftArray = maxOrder(leftArray);
        rightArray = maxOrder(rightArray);

        // Merge the sorted subarrays.
        return merge(array, leftArray, rightArray, true);
    }

    // Merge two sorted arrays into one.
    private int[] merge(int[] array, int[] leftArray, int[] rightArray, boolean reversed) {
        // Clone the original array to avoid modifying it.
        array = array.clone();
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int i = 0, j = 0, k = 0;

        // Merge two sorted arrays into one.
        while (i < leftLength && j < rightLength) {
            if (reversed) {
                if (leftArray[i] > rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            } else {
                if (leftArray[i] < rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            }
            k++;
        }

        // Copy remaining elements from left subarray.
        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from right subarray.
        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

        return array;
    }
}
