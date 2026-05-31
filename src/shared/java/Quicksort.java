
public interface Quicksort{

    public final String[] pivotNames = {
            "firstPivot",
            "middlePivot",
            "lastPivot",
            "inefficientPivot",
            "medianFirstMiddleLastPivot",
    };

    /**
     * sorts the array arr in place with the help of quicksort
     *
     * @param arr the array to be sorted
     */
    public void sort(Sortable[] arr);

    /**
     * sorts the subarray in arr in place starting at from and ending with to
     *
     * @param arr the array to be sorted
     * @param from the start of the subarray to be sorted
     * @param to the end of the subarray to be sorted
     */
    public void quicksort(Sortable[] arr, int from, int to);

    /**
     * returns the index of the first element
     * in the subarray starting with the element at index from and ending
     * with the element at index to
     *
     * @param arr the array containing the pivot
     * @param from the start of the subarray
     * @param to the end of the subarray
     *
     * @return returns the index of the first element
     * in the subarray indicated by from and to
     */
    public int firstPivot(Sortable[] arr, int from, int to);

    /**
     * returns the index of the middle element
     * in the subarray starting with the element at index from and ending
     * with the element at index to
     *
     * @param arr the array containing the pivot
     * @param from the start of the subarray
     * @param to the end of the subarray
     *
     * @return returns the index of the middle element
     * in the subarray indicated by from and to
     */
    public int middlePivot(Sortable[] arr, int from, int to);

    /**
     * returns the index of the last element
     * in the subarray starting with the element at index from and ending
     * with the element at index to
     *
     * @param arr the array containing the pivot
     * @param from the start of the subarray
     * @param to the end of the subarray
     *
     * @return returns the index of the last element
     * in the subarray indicated by from and to
     */
    public int lastPivot(Sortable[] arr, int from, int to);

    /**
     * returns the index of the biggest (according to Sortable.precedes) of the elements
     * in the subarray starting with the element at index from and ending
     * with the element at index to
     *
     * @param arr the array containing the pivot
     * @param from the start of the subarray
     * @param to the end of the subarray
     *
     * @return returns the index of the biggest (according to Sortable.precedes) of the elements
     * in the subarray indicated by from and to
     */
    public int dominantPivot(Sortable[] arr, int from, int to);

    /**
     * returns the index of the median of the first, middle and last elements
     * in the subarray starting with the element at index from and ending
     * with the element at index to
     *
     * @param arr the array containing the pivot
     * @param from the start of the subarray
     * @param to the end of the subarray
     *
     * @return returns the index of the median of the first, middle and last elements
     * in the subarray indicated by from and to
     */
    public int medianFirstMiddleLastPivot(Sortable[] arr, int from, int to);

    /**
     * returns the index of the median of the elements at a, b and c in arr
     *
     * @param arr the array in which a b and c are
     * @param a the first value
     * @param b the second value
     * @param c the third value
     */
    public int medianOfThree(Sortable[] arr, int a, int b, int c);

    public void setPivotFunc(int pivotFunc);

    public int getPivotFunc();

}
