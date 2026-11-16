package appleredistributionintoboxes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AppleRedistributionIntoBoxesTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(
            2,
            solution.minimumBoxes(intArrayOf(1, 3, 2), intArrayOf(4, 3, 1, 5, 2))
        )
    }

    @Test
    fun allBoxesAreNeeded() {
        assertEquals(4, solution.minimumBoxes(intArrayOf(5, 5, 5), intArrayOf(2, 4, 2, 7)))
    }

    @Test
    fun insufficientCapacity() {
        assertEquals(-1, solution.minimumBoxes(intArrayOf(4, 4), intArrayOf(3, 4)))
    }

    @Test
    fun largestSingleBoxIsEnough() {
        assertEquals(1, solution.minimumBoxes(intArrayOf(2, 1), intArrayOf(1, 3, 2)))
    }
}
