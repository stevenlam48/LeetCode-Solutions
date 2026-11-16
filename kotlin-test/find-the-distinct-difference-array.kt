package findthedistinctdifferencearray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDistinctDifferenceArrayTest {
    @Test
    fun handlesAllDistinctElements() {
        assertArrayEquals(intArrayOf(-3, -1, 1, 3, 5), Solution().distinctDifferenceArray(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun handlesRepeatedElements() {
        assertArrayEquals(intArrayOf(-2, -1, 0, 2, 3), Solution().distinctDifferenceArray(intArrayOf(3, 2, 3, 4, 2)))
    }

    @Test
    fun handlesEmptyArray() {
        assertArrayEquals(intArrayOf(), Solution().distinctDifferenceArray(intArrayOf()))
    }

    @Test
    fun handlesUniformArray() {
        assertArrayEquals(intArrayOf(0, 1), Solution().distinctDifferenceArray(intArrayOf(7, 7)))
    }
}
