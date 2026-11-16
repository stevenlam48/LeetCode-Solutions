package validmountainarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidMountainArrayTest {
    @Test
    fun leetCodeMountainExample() {
        assertTrue(Solution().validMountainArray(intArrayOf(0, 3, 2, 1)))
    }

    @Test
    fun leetCodeNonMountainExamples() {
        assertFalse(Solution().validMountainArray(intArrayOf(2, 1)))
        assertFalse(Solution().validMountainArray(intArrayOf(3, 5, 5)))
    }

    @Test
    fun strictlyIncreasingIsNotMountain() {
        assertFalse(Solution().validMountainArray(intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun strictlyDecreasingIsNotMountain() {
        assertFalse(Solution().validMountainArray(intArrayOf(3, 2, 1)))
    }

    @Test
    fun extraPeakAfterValleyIsNotMountain() {
        assertFalse(Solution().validMountainArray(intArrayOf(0, 2, 3, 1, 4)))
    }

    @Test
    fun emptyAndSingleElement() {
        assertFalse(Solution().validMountainArray(intArrayOf()))
        assertFalse(Solution().validMountainArray(intArrayOf(1)))
    }
}
