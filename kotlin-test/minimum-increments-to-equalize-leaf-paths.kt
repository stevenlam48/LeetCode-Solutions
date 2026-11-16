package minimumincrementstoequalizeleafpaths

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumIncrementsToEqualizeLeafPathsTest {
    @Test
    fun equalRootToLeafCostsRequireNoIncrements() {
        assertEquals(0, Solution().minIncrease(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)), intArrayOf(1, 2, 2)))
    }

    @Test
    fun differentLeafCostsRequireOneIncrement() {
        assertEquals(1, Solution().minIncrease(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)), intArrayOf(2, 1, 3)))
    }

    @Test
    fun singlePathRequiresNoIncrements() {
        assertEquals(0, Solution().minIncrease(4, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3)), intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun incrementsAtDifferentDepthsAreCounted() {
        assertEquals(2, Solution().minIncrease(5, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(1, 4)), intArrayOf(0, 1, 0, 1, 3)))
    }
}
