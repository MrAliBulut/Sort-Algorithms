public class Insertion implements ISort{

    @Override
    public int[] minOrder(int[] array) {
        // Clone the array to avoid modifying the original array.
        array = array.clone();
    
        int length = array.length;
    
        for (int i = 1; i < length; i++) {
            int currentElement = array[i];
            int j = i - 1;
    
            // Shift elements to the right until you find the correct position for the current element.
            while (j >= 0 && array[j] > currentElement) {
                array[j + 1] = array[j];
                j--;
            }
    
            // Insert the current element at its correct position.
            array[j + 1] = currentElement;
        }
    
        return array;
    }
    
    @Override
    public int[] maxOrder(int[] array) {
        // Clone the array to avoid modifying the original array.
        array = array.clone();
    
        int length = array.length;
    
        for (int i = 1; i < length; i++) {
            int currentElement = array[i];
            int j = i - 1;
    
            // Shift elements to the right until you find the correct position for the current element.
            while (j >= 0 && array[j] < currentElement) {
                array[j + 1] = array[j];
                j--;
            }
    
            // Insert the current element at its correct position.
            array[j + 1] = currentElement;
        }
    
        return array;
    }
}