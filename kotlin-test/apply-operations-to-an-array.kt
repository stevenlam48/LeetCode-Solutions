package applyoperationstoanarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class ApplyOperationsToAnArrayTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(1, 4, 2, 0, 0, 0),
            solution.applyOperations(intArrayOf(1, 2, 2, 1, 1, 0))
        )
    }

    @Test
    fun noEqualAdjacentValues() {
        assertArrayEquals(intArrayOf(1, 0), solution.applyOperations(intArrayOf(0, 1)))
    }

    @Test
    fun operationsAreNotChained() {
        assertArrayEquals(intArrayOf(4, 2, 0), solution.applyOperations(intArrayOf(2, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(3), solution.applyOperations(intArrayOf(3)))
    }
}
