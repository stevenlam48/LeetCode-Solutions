package findtheintegeraddedtoarrayii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheIntegerAddedToArrayIITest {
    @Test
    fun example1() {
        assertEquals(-2, Solution().minimumAddedInteger(intArrayOf(4, 20, 16, 12, 8), intArrayOf(14, 18, 10)))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().minimumAddedInteger(intArrayOf(3, 5, 5, 3), intArrayOf(7, 7)))
    }

    @Test
    fun negativeDifference() {
        assertEquals(-1, Solution().minimumAddedInteger(intArrayOf(1, 2, 3, 4), intArrayOf(2, 3)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().minimumAddedInteger(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1)))
    }
}
