package manhattandistancesofallarrangementsofpieces

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ManhattanDistancesOfAllArrangementsOfPiecesTest {
    @Test
    fun testTwoByTwoChooseTwo() {
        assertEquals(8, Solution().distanceSum(2, 2, 2))
    }

    @Test
    fun testOneByThreeChooseTwo() {
        assertEquals(4, Solution().distanceSum(1, 3, 2))
    }

    @Test
    fun testOneByThreeChooseThree() {
        assertEquals(4, Solution().distanceSum(1, 3, 3))
    }

    @Test
    fun testTwoByThreeChooseTwo() {
        assertEquals(25, Solution().distanceSum(2, 3, 2))
    }

    @Test
    fun testSingleRowChooseTwo() {
        assertEquals(1, Solution().distanceSum(1, 2, 2))
    }
}
