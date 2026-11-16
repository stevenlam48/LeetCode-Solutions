package countsubarrayswheremaxelementappearsatleastktimes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWhereMaxElementAppearsAtLeastKTimesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(6L, solution.countSubarrays(intArrayOf(1, 3, 2, 3, 3), 2))
    }

    @Test
    fun example2() {
        assertEquals(0L, solution.countSubarrays(intArrayOf(1, 4, 2, 1), 3))
    }

    @Test
    fun allMax() {
        assertEquals(6L, solution.countSubarrays(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun twoElements() {
        assertEquals(2L, solution.countSubarrays(intArrayOf(1, 2), 1))
    }
}
