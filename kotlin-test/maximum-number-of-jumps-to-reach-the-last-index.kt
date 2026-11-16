package maximumnumberofjumpstoreachthelastindex

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfJumpsToReachTheLastIndexTest {
    private val solution = Solution()

    @Test
    fun standardExampleWithTargetTwo() {
        assertEquals(3, solution.maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 2))
    }

    @Test
    fun standardExampleWithTargetThree() {
        assertEquals(5, solution.maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 3))
    }

    @Test
    fun unreachableLastIndex() {
        assertEquals(-1, solution.maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 0))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.maximumJumps(intArrayOf(5), 0))
    }

    @Test
    fun negativeNumbers() {
        assertEquals(2, solution.maximumJumps(intArrayOf(0, -1, 0), 1))
    }
}
