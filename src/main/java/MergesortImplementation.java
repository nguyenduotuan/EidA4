public class MergesortImplementation implements Mergesort {

    public Sortable[] mergesort(Sortable[] arr, int from, int to){
        if (from >= to) {
            return new Sortable[]{arr[from]};
        }
        int middle = getMiddle(from, to);
        Sortable[] left = mergesort(arr, from, middle);
        Sortable[] right = mergesort(arr, middle + 1, to);
        return merge(left, right);
    }

    public int getMiddle(int from, int to){
           return(to + from) / 2;
    }

    private Sortable[] merge(Sortable[] left, Sortable[] right){
        Sortable[] merged_array = new Sortable[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){
            merged_array[k++] = left[i].precedes(right[j]) ? left[i++] : right[j++];
        }

        while(i < left.length){
            merged_array[k++] = left[i++];
        }
        while (j < right.length){
            merged_array[k++] = right[j++];
        }
        return merged_array;
    }

}
