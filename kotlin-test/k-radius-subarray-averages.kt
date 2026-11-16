package kradiussubarrayaverages

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class KRadiusSubarrayAveragesTest {
    @Test
    fun `computes centered window averages`() {
        assertArrayEquals(
            intArrayOf(-1, -1, -1, 5, 4, 4, -1, -1, -1),
            Solution().getAverages(intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6), 3)
        )
    }

    @Test
    fun `zero radius preserves every value`() {
        assertArrayEquals(intArrayOf(100000), Solution().getAverages(intArrayOf(100000), 0))
        assertArrayEquals(intArrayOf(1, 2, 3, 4), Solution().getAverages(intArrayOf(1, 2, 3, 4), 0))
    }

    @Test
    fun `window larger than input leaves all unavailable`() {
        assertArrayEquals(intArrayOf(-1, -1), Solution().getAverages(intArrayOf(1, 2), 1))
    }

    @Test
    fun `integer average truncates toward zero`() {
        assertArrayEquals(intArrayOf(-1, 0, -1), Solution().getAverages(intArrayOf(-3, -1, 2), 1))
    }
}
