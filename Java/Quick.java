import java.util.Random;

public class Quick implements ISort {

    // Method to sort the array in ascending order.
    @Override
    public int[] minOrder(int[] array) {
        array = array.clone();
        // Call the quickSort method to perform quick sort in ascending order.
        return quickSort(array, 0, array.length - 1, false, false);
    }

    // Method to sort the array in descending order.
    @Override
    public int[] maxOrder(int[] array) {
        array = array.clone();
        // Call the quickSort method to perform quick sort in descending order.
        return quickSort(array, 0, array.length - 1, true, true);
    }

    // Method to sort the array with a randomized pivot.
    public int[] randomized(int[] array) {
        array = array.clone();
        // Call the quickSort method with a randomized pivot.
        return quickSort(array, 0, array.length - 1, true, false);
    }

    // Main quick sort method.
    private int[] quickSort(int[] array, int lowIndex, int highIndex, boolean randomized, boolean reversed) {
        if (lowIndex < highIndex) {
            // Partition the array and recursively sort the subarrays.
            int partitionIndex = partition(array, lowIndex, highIndex, randomized, reversed);
            quickSort(array, lowIndex, partitionIndex - 1, randomized, reversed);
            quickSort(array, partitionIndex + 1, highIndex, randomized, reversed);
        }
        return array;
    }

    // Partition method to select a pivot and rearrange the array.
    private int partition(int[] array, int lowerBound, int higherBound, boolean randomized, boolean reversed) {
        int pivot;
        if (randomized) {
            // Choose a random pivot index and swap with the last element.
            int pivotIndex = new Random().nextInt(higherBound - lowerBound + 1) + lowerBound;
            arraySwap(array, pivotIndex, higherBound);
        } 
        pivot = array[higherBound];
    
        int i = lowerBound - 1;
    
        for (int j = lowerBound; j < higherBound; j++) {
            // Compare elements with the pivot and swap if necessary.
            if ((!reversed && array[j] < pivot) || (reversed && array[j] > pivot)) {
                i++;
                arraySwap(array, i, j);
            }
        }
        arraySwap(array, i + 1, higherBound);
        return (i + 1);
    }

    // Utility method to swap elements in the array.
    private void arraySwap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
