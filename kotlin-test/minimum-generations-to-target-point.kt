package minimumgenerationstotargetpoint

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumGenerationsToTargetPointTest {
    @Test
    fun targetIsAlreadyPresent() {
        val points = arrayOf(intArrayOf(0, 0, 0), intArrayOf(2, 2, 2))
        assertEquals(0, Solution().minGenerations(points, intArrayOf(2, 2, 2)))
    }

    @Test
    fun targetIsMidpoint() {
        val points = arrayOf(intArrayOf(0, 0, 0), intArrayOf(2, 2, 2))
        assertEquals(1, Solution().minGenerations(points, intArrayOf(1, 1, 1)))
    }

    @Test
    fun secondCoordinateMidpoint() {
        val points = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 2))
        assertEquals(1, Solution().minGenerations(points, intArrayOf(0, 0, 1)))
    }

    @Test
    fun unreachableWithSinglePoint() {
        val points = arrayOf(intArrayOf(0, 0, 0))
        assertEquals(-1, Solution().minGenerations(points, intArrayOf(1, 1, 1)))
    }
}
