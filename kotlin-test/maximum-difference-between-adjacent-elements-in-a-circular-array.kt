package maximumdifferencebetweenadjacentelementsinacirculararray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDifferenceBetweenAdjacentElementsInACircularArrayTest {
    @Test
    fun standardArray() {
        assertEquals(3, Solution().maxAdjacentDistance(intArrayOf(1, 2, 4)))
    }

    @Test
    fun negativeValues() {
        assertEquals(5, Solution().maxAdjacentDistance(intArrayOf(-5, -10, -5)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxAdjacentDistance(intArrayOf(7)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(1, Solution().maxAdjacentDistance(intArrayOf(1, 2, 2)))
    }
}
