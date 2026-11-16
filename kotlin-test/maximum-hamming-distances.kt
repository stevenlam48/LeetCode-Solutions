package maximumhammingdistances

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumHammingDistancesTest {
    private val solution = Solution()

    @Test
    fun `matches the primary reference dynamic program`() {
        assertArrayEquals(intArrayOf(1, 1), solution.maxHammingDistances(intArrayOf(0, 4), 3))
    }

    @Test
    fun `handles zero bits`() {
        assertArrayEquals(intArrayOf(0), solution.maxHammingDistances(intArrayOf(0), 0))
    }

    @Test
    fun `handles empty queries`() {
        assertArrayEquals(intArrayOf(), solution.maxHammingDistances(intArrayOf(), 2))
    }
}
