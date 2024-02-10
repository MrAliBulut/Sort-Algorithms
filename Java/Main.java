import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        int arraySize = 1000;  // Size of the array to be generated
        int arrayRange = 1000;  // Range of values for the random numbers
        int[] array = new int[arraySize];  // Array to hold the random numbers

        // Generating random numbers and populating the array
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(arrayRange);
        }

        // Creating instances of sorting algorithms
        Selection selection = new Selection();  
        Insertion insertion = new Insertion();  
        Bubble bubble = new Bubble(); 
        Merge merge = new Merge();  
        Quick quick = new Quick(); 
        Heap heap = new Heap();
        Counting countingSort = new Counting();
        Radix radix = new Radix();
        
        System.out.println("================================================================");

        // Printing the original array
        System.out.println("Array:\n" + Arrays.toString(array) + "\n");

        System.out.println("================================================================");

        // Sorting the array in ascending order and printing the result
        //Please change the used object accordingly to desired sort method. 
        int[] minSorted = radix.minOrder(array);
        System.out.println("Ascending Order:\n" + Arrays.toString(minSorted) + "\n");

        // Sorting the array in descending order and printing the result
        //Please change the used object accordingly to desired sort method. 
        int[] maxSorted = radix.maxOrder(array);
        System.out.println("Descending Order:\n" + Arrays.toString(maxSorted));

        System.out.println("================================================================");
    }
}