public class Radix implements ISort {

    // Method to sort the array in ascending order using Radix sort.
    @Override
    public int[] minOrder(int[] array) {
        array = array.clone();
        int max = maxOfArray(array);
        for (int currentDigit = 1; max / currentDigit > 0; currentDigit *= 10) {
            array = alteredCountingAscending(array, currentDigit);
        }
        return array;
    }

    // Method to sort the array in descending order using Radix sort.
    @Override
    public int[] maxOrder(int[] array) {
        array = array.clone();
        int max = maxOfArray(array);
        for (int currentDigit = 1; max / currentDigit > 0; currentDigit *= 10) {
            array = alteredCountingDescending(array, currentDigit);
        }
        return array;
    }

    // Helper method for Radix sort (ascending order).
    private int[] alteredCountingAscending(int[] array, int currentDigit) {
        int[] outputArray = array.clone();
        int length = array.length;
    
        int countArray[] = new int[10];
    
        // Store count of occurrences in count[]
        for (int i = 0; i < length; i++) {
            countArray[(array[i] / currentDigit) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }
    
        for (int i = length - 1; i >= 0; i--) {
            outputArray[countArray[(array[i] / currentDigit) % 10] - 1] = array[i];
            countArray[(array[i] / currentDigit) % 10]--;
        }
    
        return outputArray;
    }

    // Helper method for Radix sort (descending order).
    private int[] alteredCountingDescending(int[] array, int currentDigit) {
        int[] outputArray = new int[array.length];
        int length = array.length;
    
        int countArray[] = new int[10];
    
        // Store count of occurrences in count[]
        for (int i = 0; i < length; i++) {
            countArray[(array[i] / currentDigit) % 10]++;
        }
        for (int i = 8; i >= 0; i--) { // Notice the change here: starting from 8 and decrementing
            countArray[i] += countArray[i + 1];
        }
    
        for (int i = length - 1; i >= 0; i--) {
            outputArray[countArray[(array[i] / currentDigit) % 10] - 1] = array[i];
            countArray[(array[i] / currentDigit) % 10]--;
        }
    
        return outputArray;
    }
    
    // Helper method to find the maximum value in the array.
    private int maxOfArray(int[] array) {
        int max = array[0];

        for (int value : array){
            max = (max >= value) ? max : value;
        }
        return max;
    }
}
