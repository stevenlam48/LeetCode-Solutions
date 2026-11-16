package countthenumberofhousesatacertaindistanceii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfHousesAtACertainDistanceIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(longArrayOf(6, 0, 0), solution.countOfPairs(3, 1, 3))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(longArrayOf(10, 8, 2, 0, 0), solution.countOfPairs(5, 2, 4))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(longArrayOf(6, 4, 2, 0), solution.countOfPairs(4, 1, 1))
    }

    @Test
    fun testTwoHouses() {
        assertArrayEquals(longArrayOf(2, 0), solution.countOfPairs(2, 1, 2))
    }

    @Test
    fun testSingleHouse() {
        assertArrayEquals(longArrayOf(0), solution.countOfPairs(1, 1, 1))
    }
}
