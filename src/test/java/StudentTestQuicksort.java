import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTestQuicksort {
    protected Quicksort sorter;

    // Hilfsmethode: Music-Array aus IDs erstellen
    private Music[] musicArray(long... ids) {
        Music[] arr = new Music[ids.length];
        for (int i = 0; i < ids.length; i++) {
            arr[i] = new MusicImplementation("Title", ids[i]);
        }
        return arr;
    }

    // Hilfsmethode: IDs aus Music-Array extrahieren
    private long[] extractIds(Sortable[] arr) {
        long[] ids = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ids[i] = ((Music) arr[i]).getId();
        }
        return ids;
    }

    @BeforeEach
    void setUp() {
        sorter = new QuicksortImplementation();
    }

    // --- sort(): Basisfälle ---

    @Test
    void testSortSingleElement() {
        Music[] arr = musicArray(42);
        sorter.sort(arr);
        assertArrayEquals(new long[]{42}, extractIds(arr));
    }

    @Test
    void testSortAlreadySorted() {
        Music[] arr = musicArray(1, 2, 3, 4, 5);
        sorter.sort(arr);
        assertArrayEquals(new long[]{1, 2, 3, 4, 5}, extractIds(arr));
    }


    @Test
    void testSortUnsorted() {
        Music[] arr = musicArray(3, 6, 8, 10, 1, 2, 1);
        sorter.sort(arr);
        assertArrayEquals(new long[]{1, 1, 2, 3, 6, 8, 10}, extractIds(arr));
    }

    // --- firstPivot ---

    @Test
    void testPivots() {
        Music[] arr = musicArray(10, 20, 30, 40, 50);
        assertEquals(0, sorter.firstPivot(arr, 0, 4));
        assertEquals(2, sorter.middlePivot(arr, 0, 4));
        assertEquals(4, sorter.lastPivot(arr, 0, 4));
    }

    @Test
    void testDominantPivotReturnsMax() {
        Music[] arr = musicArray(10, 50, 30, 20, 40);
        assertEquals(1, sorter.dominantPivot(arr, 0, 4));
    }

    // --- medianOfThree ---

    @Test
    void testMedianOfThree() {
        Music[] arr = musicArray(10, 30, 20);
        // 10 < 20 < 30 → Median ist Index 2 (Wert 20)
        assertEquals(2, sorter.medianOfThree(arr, 0, 1, 2));
    }

    // --- medianFirstMiddleLastPivot ---

    @Test
    void testMedianFirstMiddleLastPivot() {
        Music[] arr = musicArray(30, 10, 20, 50, 40);
        // first=0(30), middle=2(20), last=4(40) → Median ist 0 (Wert 30)
        assertEquals(0, sorter.medianFirstMiddleLastPivot(arr, 0, 4));
    }

}
