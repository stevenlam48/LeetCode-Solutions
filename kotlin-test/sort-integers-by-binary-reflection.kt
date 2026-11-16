package sortintegersbybinaryreflection

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortIntegersByBinaryReflectionTest {
    @Test
    fun sortsByReflectedBinaryValue() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 5),
            Solution().sortByReflection(intArrayOf(5, 2, 3, 1))
        )
    }

    @Test
    fun equalReflectionsUseIntegerValueAsTieBreaker() {
        assertArrayEquals(
            intArrayOf(4, 8, 6),
            Solution().sortByReflection(intArrayOf(4, 6, 8))
        )
    }

    @Test
    fun zeroAndDuplicates() {
        assertArrayEquals(
            intArrayOf(0, 0, 1, 1, 3),
            Solution().sortByReflection(intArrayOf(1, 0, 3, 1, 0))
        )
    }

    @Test
    fun emptyAndSingleElement() {
        assertArrayEquals(intArrayOf(), Solution().sortByReflection(intArrayOf()))
        assertArrayEquals(intArrayOf(9), Solution().sortByReflection(intArrayOf(9)))
    }
}
