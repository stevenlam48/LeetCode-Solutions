package removingminimumandmaximumfromarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovingMinimumAndMaximumFromArrayTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(5, solution.minimumDeletions(intArrayOf(2, 10, 7, 5, 4, 1, 8, 6)))
    }

    @Test
    fun secondExample() {
        assertEquals(3, solution.minimumDeletions(intArrayOf(0, -4, 19, 1, 8, -2, -3, 5)))
    }

    @Test
    fun removingFromBothSidesIsOptimal() {
        assertEquals(4, solution.minimumDeletions(intArrayOf(1, -5, 2, 3, -2)))
    }

    @Test
    fun singleElementNeedsOneDeletion() {
        assertEquals(1, solution.minimumDeletions(intArrayOf(7)))
    }
}
