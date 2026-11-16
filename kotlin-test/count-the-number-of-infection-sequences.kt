package countthenumberofinfectionsequences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfInfectionSequencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.numberOfSequence(5, intArrayOf(0, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.numberOfSequence(4, intArrayOf(1)))
    }

    @Test
    fun testSingleUninfected() {
        assertEquals(1, solution.numberOfSequence(2, intArrayOf(0)))
    }

    @Test
    fun testMiddleSick() {
        assertEquals(2, solution.numberOfSequence(3, intArrayOf(1)))
    }

    @Test
    fun testAllSick() {
        assertEquals(1, solution.numberOfSequence(3, intArrayOf(0, 1, 2)))
    }
}
