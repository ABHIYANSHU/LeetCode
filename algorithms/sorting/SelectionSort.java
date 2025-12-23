package algorithms.sorting;

public class SelectionSort<E extends Comparable<E>> implements ISort<E> {

    /**
     * Sorts array in ascending order using selection sort algorithm.
     * In-place: Yes
     * Stable: No
     * Time Complexity: O(n²) - best, average, worst
     * Space Complexity: O(1)
     */
    @Override
    public E[] sort(E[] array) {
        if (array == null || array.length <= 1) 
            return array;
        
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            E temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
        return array;
    }
}
