package countthenumberofinversions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfInversionsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val requirements = arrayOf(intArrayOf(2, 2), intArrayOf(0, 0))
        assertEquals(2, solution.numberOfPermutations(3, requirements))
    }

    @Test
    fun testExample2() {
        val requirements = arrayOf(intArrayOf(2, 2), intArrayOf(1, 1))
        assertEquals(1, solution.numberOfPermutations(3, requirements))
    }

    @Test
    fun testZeroInversions() {
        val requirements = arrayOf(intArrayOf(1, 0))
        assertEquals(1, solution.numberOfPermutations(2, requirements))
    }

    @Test
    fun testOneInversion() {
        val requirements = arrayOf(intArrayOf(1, 1))
        assertEquals(1, solution.numberOfPermutations(2, requirements))
    }

    @Test
    fun testSortedOnly() {
        val requirements = arrayOf(intArrayOf(3, 0))
        assertEquals(1, solution.numberOfPermutations(4, requirements))
    }
}
