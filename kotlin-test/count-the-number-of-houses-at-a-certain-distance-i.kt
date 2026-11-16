package countthenumberofhousesatacertaindistancei

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfHousesAtACertainDistanceITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(6, 0, 0), solution.countOfPairs(3, 1, 3))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(10, 8, 2, 0, 0), solution.countOfPairs(5, 2, 4))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(intArrayOf(6, 4, 2, 0), solution.countOfPairs(4, 1, 1))
    }

    @Test
    fun testTwoHouses() {
        assertArrayEquals(intArrayOf(2, 0), solution.countOfPairs(2, 1, 2))
    }

    @Test
    fun testSingleHouse() {
        assertArrayEquals(intArrayOf(0), solution.countOfPairs(1, 1, 1))
    }
}
