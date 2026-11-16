package majorityelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    private val solution = Solution()

    @Test
    fun findsMajorityAfterCancellation() {
        assertEquals(3, solution.majorityElement(intArrayOf(3, 2, 3)))
    }

    @Test
    fun findsMajorityAmongInterleavedValues() {
        assertEquals(2, solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }

    @Test
    fun supportsNegativeMajorityValues() {
        assertEquals(-1, solution.majorityElement(intArrayOf(-1, -1, 2)))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(7, solution.majorityElement(intArrayOf(7)))
    }
}
