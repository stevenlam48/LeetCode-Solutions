package makearraystrictlyincreasing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MakeArrayStrictlyIncreasingTest {
    @Test
    fun `uses one replacement when possible`() {
        assertEquals(
            1,
            Solution().makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 3, 2, 4))
        )
    }

    @Test
    fun `uses two replacements when possible`() {
        assertEquals(
            2,
            Solution().makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(4, 3, 1))
        )
    }

    @Test
    fun `returns minus one when no sequence works`() {
        assertEquals(
            -1,
            Solution().makeArrayIncreasing(intArrayOf(1, 5, 3, 6, 7), intArrayOf(1, 6, 3, 3))
        )
    }

    @Test
    fun `keeps strictly increasing input unchanged`() {
        assertEquals(0, Solution().makeArrayIncreasing(intArrayOf(1, 2, 3), intArrayOf()))
    }

    @Test
    fun `deduplicates replacement values`() {
        assertEquals(0, Solution().makeArrayIncreasing(intArrayOf(1, 3, 5), intArrayOf(2, 2)))
    }
}
