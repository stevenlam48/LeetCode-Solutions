package sortevenandoddindicesindependently

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortEvenAndOddIndicesIndependentlyTest {
    @Test
    fun standardExample() {
        val nums = intArrayOf(4, 1, 2, 3)
        assertArrayEquals(intArrayOf(2, 3, 4, 1), Solution().sortEvenOdd(nums))
        assertArrayEquals(intArrayOf(2, 3, 4, 1), nums)
    }

    @Test
    fun twoElementsRemainUnchanged() {
        assertArrayEquals(intArrayOf(2, 1), Solution().sortEvenOdd(intArrayOf(2, 1)))
    }

    @Test
    fun duplicatesAtBothParities() {
        val nums = intArrayOf(5, 1, 1, 4, 3, 2)
        assertArrayEquals(intArrayOf(1, 4, 3, 2, 5, 1), Solution().sortEvenOdd(nums))
    }

    @Test
    fun zerosAndRepeatedValues() {
        val nums = intArrayOf(0, 0, 0, 1, 0, 0)
        assertArrayEquals(intArrayOf(0, 1, 0, 0, 0, 0), Solution().sortEvenOdd(nums))
    }

    @Test
    fun emptyAndSingleElement() {
        assertArrayEquals(intArrayOf(), Solution().sortEvenOdd(intArrayOf()))
        assertArrayEquals(intArrayOf(7), Solution().sortEvenOdd(intArrayOf(7)))
    }
}
