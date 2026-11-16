package findthelargestalmostmissinginteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheLargestAlmostMissingIntegerTest {
    @Test
    fun example1() {
        assertEquals(9, Solution().largestInteger(intArrayOf(3, 9, 2, 3), 1))
    }

    @Test
    fun example2() {
        assertEquals(-1, Solution().largestInteger(intArrayOf(3, 9, 2, 3), 2))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().largestInteger(intArrayOf(3, 9, 2, 3), 3))
    }

    @Test
    fun duplicatesOnly() {
        assertEquals(-1, Solution().largestInteger(intArrayOf(0, 0), 1))
    }

    @Test
    fun kEqualsLength() {
        assertEquals(7, Solution().largestInteger(intArrayOf(7, 7, 7), 3))
    }

    @Test
    fun boundaryUnique() {
        assertEquals(4, Solution().largestInteger(intArrayOf(1, 2, 3, 4), 2))
    }
}
