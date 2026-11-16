package countthenumberofcomputerunlockingpermutations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfComputerUnlockingPermutationsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.countPermutations(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.countPermutations(intArrayOf(3, 3, 3, 4, 4, 4)))
    }

    @Test
    fun testAllGreater() {
        assertEquals(6, solution.countPermutations(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.countPermutations(intArrayOf(5)))
    }

    @Test
    fun testDuplicateMinimum() {
        assertEquals(0, solution.countPermutations(intArrayOf(1, 1, 2)))
    }
}
