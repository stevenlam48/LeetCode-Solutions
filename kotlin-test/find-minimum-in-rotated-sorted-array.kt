package findminimuminrotatedsortedarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumInRotatedSortedArrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().findMin(intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
    }

    @Test
    fun example3() {
        assertEquals(11, Solution().findMin(intArrayOf(11, 13, 15, 17)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().findMin(intArrayOf(1)))
    }

    @Test
    fun twoElementsRotated() {
        assertEquals(1, Solution().findMin(intArrayOf(2, 1)))
    }

    @Test
    fun rotatedAtLast() {
        assertEquals(1, Solution().findMin(intArrayOf(2, 3, 4, 5, 1)))
    }
}
