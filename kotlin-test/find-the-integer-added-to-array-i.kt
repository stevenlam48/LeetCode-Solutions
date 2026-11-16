package findtheintegeraddedtoarrayi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheIntegerAddedToArrayITest {
    @Test
    fun example1() {
        assertEquals(3, Solution().addedInteger(intArrayOf(2, 6, 4), intArrayOf(9, 7, 5)))
    }

    @Test
    fun singleElement() {
        assertEquals(-5, Solution().addedInteger(intArrayOf(10), intArrayOf(5)))
    }

    @Test
    fun zeroDifference() {
        assertEquals(0, Solution().addedInteger(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun negativeDifference() {
        assertEquals(-2, Solution().addedInteger(intArrayOf(5, 5), intArrayOf(3, 3)))
    }
}
