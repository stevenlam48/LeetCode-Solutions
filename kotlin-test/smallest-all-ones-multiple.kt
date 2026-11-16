package smallestallonesmultiple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestAllOnesMultipleTest {
    private val solution = Solution()

    @Test
    fun testOne() {
        assertEquals(1, solution.minAllOneMultiple(1))
    }

    @Test
    fun testEvenIsImpossible() {
        assertEquals(-1, solution.minAllOneMultiple(2))
    }

    @Test
    fun testMultipleOfFiveIsImpossible() {
        assertEquals(-1, solution.minAllOneMultiple(5))
    }

    @Test
    fun testThree() {
        assertEquals(3, solution.minAllOneMultiple(3))
    }

    @Test
    fun testSeven() {
        assertEquals(6, solution.minAllOneMultiple(7))
    }

    @Test
    fun testEleven() {
        assertEquals(2, solution.minAllOneMultiple(11))
    }
}
