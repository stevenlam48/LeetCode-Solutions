package decompressrunlengthencodedlist

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DecompressRunLengthEncodedListTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(2, 4, 4, 4),
            Solution().decompressRLElist(intArrayOf(1, 2, 3, 4))
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 3, 3),
            Solution().decompressRLElist(intArrayOf(1, 1, 2, 3))
        )
    }

    @Test
    fun singlePair() {
        assertArrayEquals(intArrayOf(1, 1), Solution().decompressRLElist(intArrayOf(2, 1)))
    }

    @Test
    fun repeatedValue() {
        assertArrayEquals(intArrayOf(5, 5, 5), Solution().decompressRLElist(intArrayOf(3, 5)))
    }
}
