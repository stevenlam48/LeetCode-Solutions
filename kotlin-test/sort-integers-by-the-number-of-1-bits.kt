package sortintegersbythenumberof1bits

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortIntegersByTheNumberOf1BitsTest {
    @Test
    fun standardExample() {
        val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
        assertArrayEquals(intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7), Solution().sortByBits(arr))
        assertArrayEquals(intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7), arr)
    }

    @Test
    fun largerValuesAndTieBreaker() {
        assertArrayEquals(
            intArrayOf(16, 1024, 10, 12, 7),
            Solution().sortByBits(intArrayOf(1024, 12, 7, 16, 10))
        )
    }

    @Test
    fun duplicateValues() {
        assertArrayEquals(
            intArrayOf(1, 1, 2, 3, 3),
            Solution().sortByBits(intArrayOf(3, 1, 2, 1, 3))
        )
    }

    @Test
    fun emptyAndSingleElement() {
        assertArrayEquals(intArrayOf(), Solution().sortByBits(intArrayOf()))
        assertArrayEquals(intArrayOf(5), Solution().sortByBits(intArrayOf(5)))
    }
}
