package maximumnumberofdistinctelementsafteroperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfDistinctElementsAfterOperationsTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(6, solution.maxDistinctElements(intArrayOf(1, 2, 2, 3, 3, 4), 2))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, solution.maxDistinctElements(intArrayOf(4, 4, 4, 4), 1))
    }

    @Test
    fun exampleThree() {
        assertEquals(1, solution.maxDistinctElements(intArrayOf(1, 1, 1, 1), 0))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.maxDistinctElements(intArrayOf(1), 100))
    }

    @Test
    fun alreadyDistinct() {
        assertEquals(3, solution.maxDistinctElements(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun twoDuplicates() {
        assertEquals(2, solution.maxDistinctElements(intArrayOf(1, 1), 1))
    }
}
