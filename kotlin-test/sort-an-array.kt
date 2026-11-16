package sortanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortAnArrayTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(1, 2, 3, 5), Solution().sortArray(intArrayOf(5, 2, 3, 1)))
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(0, 0, 1, 1, 2, 5),
            Solution().sortArray(intArrayOf(5, 1, 1, 2, 0, 0))
        )
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(intArrayOf(), Solution().sortArray(intArrayOf()))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(7), Solution().sortArray(intArrayOf(7)))
    }

    @Test
    fun negativesAndDuplicates() {
        assertArrayEquals(
            intArrayOf(-5, -3, -3, 0, 2, 4),
            Solution().sortArray(intArrayOf(4, -3, 2, -5, 0, -3))
        )
    }
}
