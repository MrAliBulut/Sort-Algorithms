import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int arraySize = 20;  // Size of the array to be generated
        int arrayRange = 1000;  // Range of values for the random numbers
        int[] randomizedArray = new int[arraySize];  // Array to hold the random numbers

        // Generating random numbers and populating the array
        for (int i = 0; i < randomizedArray.length; i++) {
            randomizedArray[i] = rand.nextInt(arrayRange);
        }

        // Creating instances of sorting algorithms
        Selection selection = new Selection();  
        Insertion insertion = new Insertion();  
        Bubble bubble = new Bubble(); 
        Merge merge = new Merge();  
        
        System.out.println("================================================================");

        // Printing the original array
        System.out.println("Array:\n" + Arrays.toString(randomizedArray) + "\n");

        System.out.println("================================================================");

        // Sorting the array in ascending order and printing the result
        int[] minSorted = merge.minOrder(randomizedArray);
        System.out.println("Ascending Order:\n" + Arrays.toString(minSorted) + "\n");

        // Sorting the array in descending order and printing the result
        int[] maxSorted = merge.maxOrder(randomizedArray);
        System.out.println("Descending Order:\n" + Arrays.toString(maxSorted));

        System.out.println("================================================================");
    }
}
