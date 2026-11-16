package lastvisitedintegers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LastVisitedIntegersTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertArrayEquals(
            intArrayOf(2, 1, -1),
            solution.lastVisitedIntegers(listOf("1", "2", "prev", "prev", "prev"))
        )
    }

    @Test
    fun interleavedNumbersAndPrev() {
        assertArrayEquals(
            intArrayOf(1, 2, 1),
            solution.lastVisitedIntegers(listOf("1", "prev", "2", "prev", "prev"))
        )
    }

    @Test
    fun prevWithoutVisitedInteger() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            solution.lastVisitedIntegers(listOf("prev", "prev"))
        )
    }

    @Test
    fun negativeInteger() {
        assertArrayEquals(
            intArrayOf(-5),
            solution.lastVisitedIntegers(listOf("-5", "prev"))
        )
    }

    @Test
    fun noPrevOperations() {
        assertArrayEquals(intArrayOf(), solution.lastVisitedIntegers(listOf("10", "20")))
    }
}
