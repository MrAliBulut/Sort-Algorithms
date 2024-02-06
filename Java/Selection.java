
public class Selection implements ISort{

    @Override
    public int[] minOrder(int[] array) {
        // Clone the array to avoid modifying the original array.
        array = array.clone();

        int minIndex, temp;
        // minIndex: Holds the index of the minimum value in the array.
        // temp: Used to swap values.

        int length = array.length;

        // Iterates through the array's indices.
        for (int i = 0; i < length; i++)
        {
            minIndex = i;

            // Iterates through the rest of the array to find the minimum value.
            for (int j = i + 1; j < length; j++)
            {
                // Compare values to find the index of the minimum value.
                if (array[j] < array[minIndex])
                {
                    minIndex = j;
                }
            }

            // Swaps the current element with the minimum value found.
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }
        return array;
    }

    @Override
    public int[] maxOrder(int[] array) {
        // Clone the array to avoid modifying the original array.
        array = array.clone();

        int maxIndex, temp;
        // maxIndex: Holds the index of the maximum value in the array.
        // temp: Used to swap values.
        int length = array.length;
        
        // Iterates through the array's indices.
        for (int i = 0; i < length; i++)
        {
            maxIndex = i;
        
            // Iterates through the rest of the array to find the maximum value.
            for (int j = i + 1; j < length; j++)
            {
                // Compare values to find the index of the minimum value.
                if (array[j] > array[maxIndex])
                {
                    maxIndex = j;
                }
            }
        
            // Swaps the current element with the maximum value found.
            temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        
        }
        return array;
    }
}
