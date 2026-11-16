package countsubarrayswithmajorityelementi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithMajorityElementITest {
    private val solution = Solution()

    @Test
    fun allTarget() {
        assertEquals(6, solution.countMajoritySubarrays(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun mixed() {
        assertEquals(3, solution.countMajoritySubarrays(intArrayOf(1, 2, 1), 1))
    }

    @Test
    fun noTarget() {
        assertEquals(0, solution.countMajoritySubarrays(intArrayOf(2, 2), 1))
    }

    @Test
    fun singleTarget() {
        assertEquals(1, solution.countMajoritySubarrays(intArrayOf(1), 1))
    }
}
