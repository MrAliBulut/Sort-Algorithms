public class Heap implements ISort {

    int length;
    @Override
    public int[] minOrder(int[] array) {
        array = array.clone();
        length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--){
            maxHeapify(array, i, length);
        }

        for (int i = length - 1; i > 0; i--) {
            // Move current root to end
            arraySwap(array, 0, i);
            
            // call max heapify on the reduced heap
            maxHeapify(array, 0,i);
        }
        return array;
    }

    @Override
    public int[] maxOrder(int[] array) {
        array = array.clone();
        length = array.length;

        for (int i = length / 2 - 1; i >= 0; i--){
            minHeapify(array, i, length);
        }

        for (int i = length - 1; i > 0; i--) {
            // Move current root to end
            arraySwap(array, 0, i);
            
            // call max heapify on the reduced heap
            minHeapify(array, 0,i);
        }
        return array;
    }

    private void maxHeapify(int[] array,int parent,int heapSize){

        int largest = parent,
         leftChild = parent*2+1,
        rightChild = parent*2+2;

        if (leftChild < heapSize && array[largest] < array[leftChild]){ 
            largest = leftChild;
        }
        
        if (rightChild < heapSize && array[largest] < array[rightChild]){
            largest = rightChild;
        }

        if (largest != parent){
            arraySwap(array,largest,parent);

            maxHeapify(array,largest,heapSize);
        }
    
    }

    private void minHeapify(int[] array,int parent,int heapSize){

        int least = parent,
         leftChild = parent*2+1,
        rightChild = parent*2+2;

        if (leftChild < heapSize && array[least] > array[leftChild]){ 
            least = leftChild;
        }
        
        if (rightChild < heapSize && array[least] > array[rightChild]){
            least = rightChild;
        }        

        if (least != parent){
            arraySwap(array,least,parent);

            minHeapify(array,least,heapSize);
        }
    
    }

    private void arraySwap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
