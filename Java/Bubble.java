public class Bubble implements ISort{

    @Override
    public int[] minOrder(int[] array) {

        // Clone the array to avoid modifying the original array.
        array = array.clone();

        int temp;
        int length = array.length;

        // Outer loop iterates through each element in the array.
        for (int i = 0; i < length; i++) {
            // Inner loop iterates through each pair of adjacent elements.
            for (int j = 0; j < length - 1; j++) {
                // Compare adjacent elements and swap if necessary.
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    @Override
    public int[] maxOrder(int[] array) {

        // Clone the array to avoid modifying the original array.
        array = array.clone();

        int temp;
        int length = array.length;

        // Outer loop iterates through each element in the array.
        for (int i = 0; i < length; i++) {
            // Inner loop iterates through each pair of adjacent elements.
            for (int j = 0; j < length - 1; j++) {
                // Compare adjacent elements and swap if necessary.
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}