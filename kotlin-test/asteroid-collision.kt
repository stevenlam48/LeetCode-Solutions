package asteroidcollision

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AsteroidCollisionTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(5, 10), solution.asteroidCollision(intArrayOf(5, 10, -5)))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(), solution.asteroidCollision(intArrayOf(8, -8)))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(intArrayOf(10), solution.asteroidCollision(intArrayOf(10, 2, -5)))
    }

    @Test
    fun testNoCollision() {
        assertArrayEquals(
            intArrayOf(-2, -1, 1, 2),
            solution.asteroidCollision(intArrayOf(-2, -1, 1, 2))
        )
    }

    @Test
    fun testChainCollision() {
        assertArrayEquals(intArrayOf(-5), solution.asteroidCollision(intArrayOf(1, 2, 3, -5)))
    }
}
