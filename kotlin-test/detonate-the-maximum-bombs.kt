package detonatethemaximumbombs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DetonateTheMaximumBombsTest {
    private val solution = Solution()

    @Test
    fun oneBombDetonatesBoth() {
        val bombs = arrayOf(intArrayOf(2, 1, 3), intArrayOf(6, 1, 4))
        assertEquals(2, solution.maximumDetonation(bombs))
    }

    @Test
    fun distantBomsDetonateSeparately() {
        val bombs = arrayOf(intArrayOf(1, 1, 5), intArrayOf(10, 10, 5))
        assertEquals(1, solution.maximumDetonation(bombs))
    }

    @Test
    fun directedChainDetonatesAllFive() {
        val bombs = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 4, 2),
            intArrayOf(4, 5, 3),
            intArrayOf(5, 6, 4)
        )
        assertEquals(5, solution.maximumDetonation(bombs))
    }

    @Test
    fun directionMattersForPartialChain() {
        val bombs = arrayOf(
            intArrayOf(0, 0, 5),
            intArrayOf(4, 0, 1),
            intArrayOf(5, 0, 1)
        )
        assertEquals(3, solution.maximumDetonation(bombs))
    }

    @Test
    fun singleBombDetonatesItself() {
        assertEquals(1, solution.maximumDetonation(arrayOf(intArrayOf(0, 0, 1))))
    }
}
