package destroyingasteroids

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DestroyingAsteroidsTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertTrue(solution.asteroidsDestroyed(10, intArrayOf(3, 9, 19, 5, 21)))
        assertTrue(solution.asteroidsDestroyed(5, intArrayOf(4, 9, 5, 4)))
    }

    @Test
    fun testInsufficientMass() {
        assertFalse(solution.asteroidsDestroyed(3, intArrayOf(4, 5)))
        assertFalse(solution.asteroidsDestroyed(1, intArrayOf(2, 3)))
        assertFalse(solution.asteroidsDestroyed(1, intArrayOf(1, 3)))
    }

    @Test
    fun testSingleAsteroid() {
        assertTrue(solution.asteroidsDestroyed(5, intArrayOf(5)))
        assertFalse(solution.asteroidsDestroyed(1, intArrayOf(2)))
    }

    @Test
    fun testMassAlreadyLargeEnough() {
        assertTrue(solution.asteroidsDestroyed(100, intArrayOf(1, 2, 3)))
        assertTrue(solution.asteroidsDestroyed(1000000000, intArrayOf(1000000000)))
    }

    @Test
    fun testUnorderedInput() {
        assertTrue(solution.asteroidsDestroyed(2, intArrayOf(5, 1, 2, 3)))
    }

    @Test
    fun testAllEqual() {
        assertTrue(solution.asteroidsDestroyed(4, intArrayOf(4, 4, 4, 4)))
    }
}
