package fruitsintobasketsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FruitsIntoBasketsIiTest {
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
    fun singleFruitFits() {
        assertEquals(
            0,
            Solution().numOfUnplacedFruits(intArrayOf(1), intArrayOf(1))
        )
    }

    @Test
    fun singleFruitDoesNotFit() {
        assertEquals(
            1,
            Solution().numOfUnplacedFruits(intArrayOf(2), intArrayOf(1))
        )
    }

    @Test
    fun someUnplaced() {
        assertEquals(
            1,
            Solution().numOfUnplacedFruits(intArrayOf(5, 5), intArrayOf(4, 6))
        )
    }

    @Test
    fun allUnplaced() {
        assertEquals(
            2,
            Solution().numOfUnplacedFruits(intArrayOf(3, 3), intArrayOf(1, 2))
        )
    }
}
