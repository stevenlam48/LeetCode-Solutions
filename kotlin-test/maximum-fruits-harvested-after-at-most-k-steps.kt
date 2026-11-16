package maximumfruitsharvestedafteratmostksteps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFruitsHarvestedAfterAtMostKStepsTest {
    @Test
    fun example1() {
        assertEquals(
            9,
            Solution().maxTotalFruits(
                arrayOf(intArrayOf(2, 8), intArrayOf(6, 3), intArrayOf(8, 6)),
                5,
                4
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            14,
            Solution().maxTotalFruits(
                arrayOf(
                    intArrayOf(0, 9), intArrayOf(4, 1), intArrayOf(5, 7),
                    intArrayOf(6, 2), intArrayOf(7, 4), intArrayOf(10, 9)
                ),
                5,
                4
            )
        )
    }

    @Test
    fun example3() {
        assertEquals(
            0,
            Solution().maxTotalFruits(
                arrayOf(intArrayOf(0, 3), intArrayOf(6, 4), intArrayOf(8, 5)),
                3,
                2
            )
        )
    }

    @Test
    fun zeroSteps() {
        assertEquals(
            10000,
            Solution().maxTotalFruits(arrayOf(intArrayOf(200, 10000)), 200, 0)
        )
    }

    @Test
    fun singleFruitReachable() {
        assertEquals(
            5,
            Solution().maxTotalFruits(arrayOf(intArrayOf(3, 5)), 0, 3)
        )
    }
}
