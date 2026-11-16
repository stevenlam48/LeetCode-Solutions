package findminimuminrotatedsortedarrayii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumInRotatedSortedArrayIITest {
    @Test
    fun example1() {
        assertEquals(1, Solution().findMin(intArrayOf(1, 3, 5)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().findMin(intArrayOf(2, 2, 2, 0, 1)))
    }

    @Test
    fun duplicatesAroundMinimum() {
        assertEquals(1, Solution().findMin(intArrayOf(3, 3, 1, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(2, Solution().findMin(intArrayOf(2, 2, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().findMin(intArrayOf(1)))
    }

    @Test
    fun duplicatesAtEnds() {
        assertEquals(1, Solution().findMin(intArrayOf(10, 1, 10, 10, 10)))
    }
}
