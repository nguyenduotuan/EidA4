public interface Radixsort {
    /**
     * Sorts the array arr using radix sort
     * @param arr the array to be sorted
     * @return the sorted array
     */
    public Music[] radixsort(Music[] arr);

    /**
     * Sets the base for the radix sort
     * Standard: base 10 (digits 0-9)
     * @param base the base to be used
     */
    public void setBase(int base);
}