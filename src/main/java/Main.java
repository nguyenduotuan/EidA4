import java.util.Random;

import static java.lang.System.nanoTime;

public class Main {
    public static void main(String[] args){
        Music[] arr = randomMusic(100);

        MainQuicksort(arr);
        MainMergesort(arr);
        MainRadixsort(arr);
    }
    private static void MainQuicksort(Music[] arr) {
        Quicksort qsf = new QuicksortImplementation();
        Quicksort qsm = new QuicksortImplementation(1);
        Quicksort qsl = new QuicksortImplementation(2);
        Quicksort qsd = new QuicksortImplementation(3);
        Quicksort qs_median = new QuicksortImplementation(4);
        Music[] original_arr = arr;

        long fstart = nanoTime();
        qsf.sort(original_arr);
        long fduration = nanoTime() - fstart;
        printBar("first", fduration);

        long mstart = nanoTime();
        qsm.sort(original_arr);
        long mduration = nanoTime() - mstart;
        printBar("middle", mduration);

        long lstart = nanoTime();
        qsl.sort(original_arr);
        long lduration = nanoTime() - lstart;
        printBar("last", lduration);

        long dstart = nanoTime();
        qsd.sort(original_arr);
        long dduration = nanoTime() - dstart;
        printBar("dominant", dduration);

        long median_start = nanoTime();
        qs_median.sort(original_arr);
        long median_duration = nanoTime() - median_start;
        printBar("median", median_duration);

    }

    private static void MainMergesort(Music[] arr){
        Mergesort ms = new MergesortImplementation();
        Music[] original_arr = arr;

        long start = nanoTime();
        ms.mergesort(original_arr, 0, original_arr.length - 1);
        long duration = nanoTime() - start;
        printBar("mergesort", duration);
    }

    private static void MainRadixsort(Music[] arr){
        Radixsort rs = new RadixsortImplementation();

        // TODO 4.1e

    }

    private static Music[] randomMusic(int size) {
        Random rg = new Random(0xca7caffe);
        Music[] arr = new Music[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new MusicImplementation("FZ",Math.abs(rg.nextInt()));
        }
        return arr;
    }

    private static void printBar(String lable, long timeINns){
        int bars = (int)(timeINns/1_000);
        System.out.printf("%-10.10s | %s %.2f ms%n", lable, "-".repeat(bars), timeINns/1e6);
    }

    private static boolean isSorted(Sortable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1].precedes(arr[i])) {
                return false; // arr[i+1] müsste NACH arr[i] kommen, nicht davor
            }
        }
        return true;
    }



}
