package fruitsintobasketsiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FruitsIntoBasketsIiiTest {
    @Test
    fun example1() {
        assertEquals(
            1,
            Solution().numOfUnplacedFruits(intArrayOf(4, 2, 5), intArrayOf(3, 5, 4))
        )
    }

    @Test
    fun example2() {
        assertEquals(
            0,
            Solution().numOfUnplacedFruits(intArrayOf(3, 6, 1), intArrayOf(6, 4, 7))
        )
    }

    @Test
    fun leftmostSuitableBasketIsUsed() {
        assertEquals(
            0,
            Solution().numOfUnplacedFruits(intArrayOf(2, 5, 3), intArrayOf(4, 3, 5))
        )
    }

    @Test
    fun largestFruitCannotBePlaced() {
        assertEquals(
            1,
            Solution().numOfUnplacedFruits(intArrayOf(5, 6, 7), intArrayOf(4, 5, 6))
        )
    }

    @Test
    fun threeBasketsOneFruit() {
        assertEquals(
            0,
            Solution().numOfUnplacedFruits(intArrayOf(1), intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun allUnplaced() {
        assertEquals(
            3,
            Solution().numOfUnplacedFruits(intArrayOf(9, 8, 7), intArrayOf(1, 2, 3))
        )
    }
}
