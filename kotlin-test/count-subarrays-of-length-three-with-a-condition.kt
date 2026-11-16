package countsubarraysoflengththreewithacondition

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysOfLengthThreeWithAConditionTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.countSubarrays(intArrayOf(1, 2, 1, 4, 1)))
    }

    @Test
    fun singleMatch() {
        assertEquals(1, solution.countSubarrays(intArrayOf(1, 4, 1)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, solution.countSubarrays(intArrayOf(1, 1, 1)))
    }

    @Test
    fun increasing() {
        assertEquals(0, solution.countSubarrays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun tooShort() {
        assertEquals(0, solution.countSubarrays(intArrayOf(1, 2)))
    }
}
