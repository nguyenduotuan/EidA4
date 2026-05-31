public class RadixsortImplementation implements Radixsort {
    private int base = 10;

    /**
     * Die Basis des Radixsorts. Sie gibt an in wie viele Gruppen
     * die Ziffern pro Durchlauf aufgeteilt werden.
     * Standard: Basis 10 (Ziffern 0-9)
     */
    public void setBase(int base){
        this.base = base;
    }

    public Music[] radixsort(Music[] arr){
        long[] extracted_ids = extractIds(arr);

        long min = getMin(extracted_ids);
        for (int i = 0; i < extracted_ids.length; i++) {
            extracted_ids[i] -= min;
        }

        long max = getMax(extracted_ids);
        for (long exp = 1; max / exp > 0; exp*=10) {
            countingSort(arr, extracted_ids, exp);
        }
        return arr;
    }

    private void countingSort(Music[] arr, long[] ids, long exp){
        int[] digit_counts = new int[10];
        //tracking digit count
        for (int i = 0; i < ids.length; i++) {
            int digit = (int) (Math.abs(ids[i] / exp) % 10);
            digit_counts[digit]++;
        }
        //cumulative sum
        for (int i = 1; i < 10; i++) {
            digit_counts[i] += digit_counts[i - 1];
        }

        Music[] sorted_arr = new Music[arr.length];
        long[] sorted_ids = new long[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (int) (Math.abs(ids[i] / exp) % 10);
            int index = --digit_counts[digit];
            sorted_arr[index] = arr[i];
            sorted_ids[index] = ids[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted_arr[i];
            ids[i] = sorted_ids[i];
        }
    }

    private long[] extractIds(Music[] arr){
       long[] music_ids = new long[arr.length];
       for (int i = 0; i < arr.length; i++) {
           music_ids[i] = arr[i].getId();
       }
       return music_ids;
    }

    private long getMax(long[] ids){
        long max = 0;
        for (int i = 0; i < ids.length; i++) {
            if (max < ids[i]) {
                max = ids[i];
            }
        }
        return max;
    }

    private long getMin(long[] ids){
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < ids.length; i++) {
            if (min > ids[i]) {
                min = ids[i];
            }
        }
        return min;
    }
}
