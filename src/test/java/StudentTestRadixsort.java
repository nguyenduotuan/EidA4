import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTestRadixsort {

    protected Radixsort sorter;

    // Hilfsmethode: Music-Array aus IDs erstellen
    private Music[] musicArray(long... ids) {
        Music[] arr = new Music[ids.length];
        for (int i = 0; i < ids.length; i++) {
            arr[i] = new MusicImplementation("Title", ids[i]);
        }
        return arr;
    }

    // Hilfsmethode: IDs aus Music-Array extrahieren
    private long[] extractIds(Music[] arr) {
        long[] ids = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ids[i] = arr[i].getId();
        }
        return ids;
    }

    @BeforeEach
    void setUp() {
        sorter = new RadixsortImplementation();
    }

    // --- Basisfälle ---

    @Test
    void testAlreadySorted() {
        Music[] arr = musicArray(1, 2, 3, 4, 5);
        Music[] result = sorter.radixsort(arr);
        assertArrayEquals(new long[]{1, 2, 3, 4, 5}, extractIds(result));
    }

    @Test
    void testUnsortedArray() {
        Music[] arr = musicArray(170, 45, 75, 90, 802, 24, 2, 66);
        Music[] result = sorter.radixsort(arr);
        assertArrayEquals(new long[]{2, 24, 45, 66, 75, 90, 170, 802}, extractIds(result));
    }

    // --- Negative Zahlen ---
    @Test
    void testMixedPositiveAndNegative() {
        Music[] arr = musicArray(-10, 5, -3, 0, 8, -1);
        Music[] result = sorter.radixsort(arr);
        assertArrayEquals(new long[]{-10, -3, -1, 0, 5, 8}, extractIds(result));
    }

    // --- Verschiedene Basen ---

    @Test
    void testBase2() {
        sorter.setBase(2);
        Music[] arr = musicArray(10, 3, 7, 1, 8);
        Music[] result = sorter.radixsort(arr);
        assertArrayEquals(new long[]{1, 3, 7, 8, 10}, extractIds(result));
    }

}


