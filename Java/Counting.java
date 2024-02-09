public class Counting implements ISort {

    // Method to check if the given array is suitable for counting sort.
    public boolean checkSuitability(int[] array) {
        int length = array.length;

        if (length == 0) {
            // Array is empty.
            return false;
        }

        int maxValue = 0, minValue = 0;

        // Find the maximum and minimum values in the array.
        for (int value : array) {
            maxValue = returnMAX(maxValue, value);
            minValue = returnMIN(minValue, value);
        }

        int range = maxValue - minValue;

        // Check if the gap between range and the length is greater than 100.
        return (range - length) > 100 ? false : true;
    }

    // Method to sort the array in ascending order using counting sort.
    @Override
    public int[] minOrder(int[] array) {
        int[] outputArray = array.clone();
        int length = array.length;
        int maxValue = 0;

        // Find the maximum value in the array.
        for (int value : array) {
            maxValue = returnMAX(maxValue, value);
        }

        // Create a count array to store the count of each element.
        int[] countArray = new int[maxValue + 1];

        // Count the occurrences of each element in the input array.
        for (int value : array) {
            countArray[value]++;
        }

        // Modify the count array to store the actual position of elements in the output array.
        // (Ascending order)
        for (int i = 0; i <= maxValue - 1; i++) {
            countArray[i + 1] += countArray[i];
        }

        // Arrange the elements in the output array based on the count array.
        for (int i = length - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }

        return outputArray;
    }

    // Method to sort the array in descending order using counting sort.
    @Override
    public int[] maxOrder(int[] array) {
        int[] outputArray = array.clone();
        int length = array.length;
        int maxValue = 0;

        // Find the maximum value in the array.
        for (int value : array) {
            maxValue = returnMAX(maxValue, value);
        }

        // Create a count array to store the count of each element.
        int[] countArray = new int[maxValue + 1];

        // Count the occurrences of each element in the input array.
        for (int value : array) {
            countArray[value]++;
        }

        // Modify the count array to store the actual position of elements in the output array.
        // (Descending order)
        for (int i = maxValue - 1; i >= 0; i--) {
            countArray[i] += countArray[i + 1];
        }

        // Arrange the elements in the output array based on the count array.
        for (int i = length - 1; i >= 0; i--) {
            outputArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }

        return outputArray;
    }

    // Utility method to return the maximum of two values.
    private int returnMAX(int value1, int value2) {
        return value1 > value2 ? value1 : value2;
    }

    // Utility method to return the minimum of two values.
    private int returnMIN(int value1, int value2) {
        return value1 < value2 ? value1 : value2;
    }
}
