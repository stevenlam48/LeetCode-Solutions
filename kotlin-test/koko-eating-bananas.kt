package kokoeatingbananas

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KokoEatingBananasTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(4, solution.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    }

    @Test
    fun example2() {
        assertEquals(30, solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
    }

    @Test
    fun example3() {
        assertEquals(23, solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))
    }

    @Test
    fun singlePile() {
        assertEquals(1, solution.minEatingSpeed(intArrayOf(1), 1))
    }

    @Test
    fun manySmallPiles() {
        assertEquals(1, solution.minEatingSpeed(intArrayOf(1, 1, 1, 1), 4))
    }

    @Test
    fun largePile() {
        assertEquals(500000000, solution.minEatingSpeed(intArrayOf(1000000000), 2))
    }
}
