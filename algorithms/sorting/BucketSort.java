package algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort<E> implements ISort<E> {
    
    /**
     * Sorts array in ascending order using bucket sort algorithm.
     * In-place: No
     * Stable: Depends on bucket sorting algorithm
     * Time Complexity: O(n + k) average, O(n²) worst
     * Space Complexity: O(n + k)
     */
    @Override
    public E[] sort(E[] array) {
        if (array == null || array.length <= 1) 
            return array;
        
        ArrayList<E>[] buckets = createBuckets(array.length);
        double[] minMax = findMinMax(array);
        distributeToBuckets(array, buckets, minMax[0], minMax[1]);
        sortBuckets(buckets);
        return mergeBuckets(array, buckets);
    }
    
    // Creates n empty buckets for distributing elements
    @SuppressWarnings("unchecked")
    private ArrayList<E>[] createBuckets(int n) {
        ArrayList<E>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        return buckets;
    }
    
    // Finds minimum and maximum values to determine the range
    @SuppressWarnings("unchecked")
    private double[] findMinMax(E[] array) {
        Comparable<E> min = (Comparable<E>) array[0];
        Comparable<E> max = (Comparable<E>) array[0];
        
        for (E elem : array) {
            if (((Comparable<E>) elem).compareTo((E) min) < 0) min = (Comparable<E>) elem;
            if (((Comparable<E>) elem).compareTo((E) max) > 0) max = (Comparable<E>) elem;
        }
        
        return new double[]{((Number) min).doubleValue(), ((Number) max).doubleValue()};
    }
    
    // Distributes elements into buckets based on normalized position
    private void distributeToBuckets(E[] array, ArrayList<E>[] buckets, double min, double max) {
        double range = max - min;
        int n = array.length;
        
        for (E elem : array) {
            int bucketIndex = (int) ((((Number) elem).doubleValue() - min) / range * (n - 1));
            buckets[bucketIndex].add(elem);
        }
    }
    
    // Sorts each bucket individually
    @SuppressWarnings("unchecked")
    private void sortBuckets(ArrayList<E>[] buckets) {
        for (ArrayList<E> bucket : buckets) {
            Collections.sort(bucket, (a, b) -> ((Comparable<E>) a).compareTo(b));
        }
    }
    
    // Concatenates all sorted buckets back into the original array
    private E[] mergeBuckets(E[] array, ArrayList<E>[] buckets) {
        int index = 0;
        for (ArrayList<E> bucket : buckets) {
            for (E elem : bucket) {
                array[index++] = elem;
            }
        }
        return array;
    }
}
