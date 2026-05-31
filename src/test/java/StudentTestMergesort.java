import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTestMergesort {
    protected Mergesort sorter;

    // Hilfsmethode: Music-Array aus IDs erstellen
    private Music[] musicArray(long... ids) {
        Music[] arr = new Music[ids.length];
        for (int i = 0; i < ids.length; i++) {
            arr[i] = new MusicImplementation("Title", ids[i]);
        }
        return arr;
    }

    // Hilfsmethode: IDs aus Sortable-Array extrahieren
    private long[] extractIds(Sortable[] arr) {
        long[] ids = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ids[i] = ((Music) arr[i]).getId();
        }
        return ids;
    }

    @BeforeEach
    void setUp() {
        sorter = new MergesortImplementation();
    }

    // --- Basisfälle ---

    @Test
    void testAlreadySorted() {
        Music[] arr = musicArray(1, 2, 3, 4, 5);
        Sortable[] result = sorter.mergesort(arr, 0, 4);
        assertArrayEquals(new long[]{1, 2, 3, 4, 5}, extractIds(result));
    }

    @Test
    void testUnsorted() {
        Music[] arr = musicArray(3, 6, 8, 10, 1, 2, 1);
        Sortable[] result = sorter.mergesort(arr, 0, 6);
        assertArrayEquals(new long[]{1, 1, 2, 3, 6, 8, 10}, extractIds(result));
    }

    // --- getMedian ---

    @Test
    void testGetMiddleOddLength() {
        // from=0, to=4 → mid=2
        assertEquals(2, sorter.getMiddle(0, 4));
    }

    @Test
    void testGetMiddleEvenLength() {
        // from=0, to=3 → mid=1
        assertEquals(1, sorter.getMiddle(0, 3));
    }

    @Test
    void testGetMiddleLargeRange() {
        // from=0, to=100 → mid=50
        assertEquals(50, sorter.getMiddle(0, 100));
    }

    // --- Größere Arrays ---

    @Test
    void testLargeArray() {
        Music[] arr = musicArray(9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        Sortable[] result = sorter.mergesort(arr, 0, 9);
        assertArrayEquals(new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, extractIds(result));
    }
}