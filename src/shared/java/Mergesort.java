public interface Mergesort {
    /**
     * Sorts the subarray of arr from index from to index to
     */
    public Sortable[] mergesort(Sortable[] arr, int from, int to);

    /**
     * Returns the median index between from and to
     */
    public int getMiddle(int from, int to);

}