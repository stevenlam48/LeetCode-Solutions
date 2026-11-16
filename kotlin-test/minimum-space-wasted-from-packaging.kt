package minimumspacewastedfrompackaging

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSpaceWastedFromPackagingTest {
    @Test
    fun example1() {
        val packages = intArrayOf(2, 3, 5)
        val boxes = arrayOf(intArrayOf(4, 8), intArrayOf(2, 8))
        assertEquals(6, Solution().minWastedSpace(packages, boxes))
    }

    @Test
    fun example2() {
        val packages = intArrayOf(2, 3, 5)
        val boxes = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 4))
        assertEquals(-1, Solution().minWastedSpace(packages, boxes))
    }

    @Test
    fun example3() {
        val packages = intArrayOf(3, 5, 8, 10, 11, 12)
        val boxes = arrayOf(intArrayOf(12), intArrayOf(11, 9), intArrayOf(10, 8, 12))
        assertEquals(9, Solution().minWastedSpace(packages, boxes))
    }

    @Test
    fun exactFitHasNoWaste() {
        assertEquals(0, Solution().minWastedSpace(intArrayOf(5), arrayOf(intArrayOf(5))))
    }
}
