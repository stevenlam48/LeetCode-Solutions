package numberofwaystoassignedgeweightsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToAssignEdgeWeightsITest {
    @Test
    fun singleEdge() {
        assertEquals(1, Solution().assignEdgeWeights(arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun pathOfThree() {
        assertEquals(2, Solution().assignEdgeWeights(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))))
    }

    @Test
    fun star() {
        assertEquals(1, Solution().assignEdgeWeights(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3))))
    }

    @Test
    fun pathOfFour() {
        assertEquals(4, Solution().assignEdgeWeights(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))))
    }

    @Test
    fun deeperBranch() {
        assertEquals(2, Solution().assignEdgeWeights(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4), intArrayOf(3, 5))))
    }
}
