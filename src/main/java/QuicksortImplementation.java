public class QuicksortImplementation implements Quicksort {
    private int pivotFunc;

    public QuicksortImplementation() {
        this.pivotFunc = 0;
    }

    public QuicksortImplementation(int pivotFunc) {
        this.pivotFunc = pivotFunc;
    }

    public void sort(Sortable[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public void quicksort(Sortable[] arr, int from, int to) {
        if (from >= to) return;
        int pivot = getPivot(arr, from, to);
        swap(arr, pivot, to);
        int split = from;
        for (int i = from; i < to; i++) {
            if (arr[i].precedes(arr[to])) {
                swap(arr, split++, i);
            }
        }
        swap(arr, to, split);
        quicksort(arr, split + 1, to);
        quicksort(arr, from, split - 1);
    }

    private static void swap(Sortable[] arr, int a, int b){
       Sortable temp = arr[a];
       arr[a] = arr[b];
       arr[b] = temp;
    }

    public int firstPivot(Sortable[] arr, int from, int to) {
        return from;
    }

    public int middlePivot(Sortable[] arr, int from, int to) {
        return (from + to) / 2;
    }

    public int lastPivot(Sortable[] arr, int from, int to) {
        return to;
    }

    public int dominantPivot(Sortable[] arr, int from, int to) {
        Sortable max = arr[from];
        int index = from;
        for(int i = from; i <= to; i++){
            if (max.precedes(arr[i])){
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public int medianOfThree(Sortable[] arr, int a, int b, int c) {
        Sortable A = arr[a];
        Sortable B = arr[b];
        Sortable C = arr[c];
        if ( (A.precedes(B) && B.precedes(C)) || (C.precedes(B) && B.precedes(A)) ) {
            return b;
        }
        if ( (B.precedes(A) && A.precedes(C)) || (C.precedes(A) && A.precedes(B)) ) {
            return a;
        }
        if ( (A.precedes(C) && C.precedes(B)) || (B.precedes(C) && C.precedes(A)) ) {
            return c;
        }
        return a;
    }

    public int medianFirstMiddleLastPivot(Sortable[] arr, int from, int to) {
        return medianOfThree(arr, from, to, middlePivot(arr, from, to));
    }

    /**
     * gets the pivot inside the subarray in arr starting
     * with from and ending with to according to this.pivotFunc
     *
     * @param arr the array
     * @param from the start of the subarray
     * @param to the end of the subarray
     *
     * @return returns the pivot inside the subarray in arr
     * starting with from and ending before to
     */
    private int getPivot(Sortable[] arr, int from, int to) {
        switch (pivotFunc) {
            case 1:
                return middlePivot(arr, from, to);
            case 2:
                return lastPivot(arr, from, to);
            case 3:
                return dominantPivot(arr, from, to);
            case 4:
                return medianFirstMiddleLastPivot(arr, from, to);
            case 0:
            default:
                return firstPivot(arr, from, to);
        }
    }

    public void setPivotFunc(int pivotFunc) {
        this.pivotFunc = pivotFunc;
    }

    public int getPivotFunc() {
        return this.pivotFunc;
    }

}
