package findthelosersofthecirculargame

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheLosersOfTheCircularGameTest {
    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(4, 5), Solution().circularGameLosers(5, 2))
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(intArrayOf(2, 3, 4), Solution().circularGameLosers(4, 4))
    }

    @Test
    fun onePlayer() {
        assertArrayEquals(intArrayOf(), Solution().circularGameLosers(1, 1))
    }

    @Test
    fun everyoneReceivesBall() {
        assertArrayEquals(intArrayOf(3), Solution().circularGameLosers(3, 1))
    }

    @Test
    fun stationaryBall() {
        assertArrayEquals(intArrayOf(2), Solution().circularGameLosers(2, 2))
    }
}
