package reductionoperationstomakethearrayelementsequal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReductionOperationsToMakeTheArrayElementsEqualTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.reductionOperations(intArrayOf(5, 1, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.reductionOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(4, solution.reductionOperations(intArrayOf(1, 1, 2, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.reductionOperations(intArrayOf(7)))
    }

    @Test
    fun testTwoDistinct() {
        assertEquals(1, solution.reductionOperations(intArrayOf(1, 2)))
    }

    @Test
    fun testDescendingInput() {
        assertEquals(6, solution.reductionOperations(intArrayOf(4, 3, 2, 1)))
    }
}
