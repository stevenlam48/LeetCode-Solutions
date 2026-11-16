package mergetripletstoformtargettriplet

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MergeTripletsToFormTargetTripletTest {
    @Test
    fun example1() {
        val triplets = arrayOf(intArrayOf(2, 5, 3), intArrayOf(1, 8, 4), intArrayOf(1, 7, 5))
        assertTrue(Solution().mergeTriplets(triplets, intArrayOf(2, 7, 5)))
    }

    @Test
    fun cannotReachTarget() {
        val triplets = arrayOf(intArrayOf(2, 5, 3), intArrayOf(1, 8, 4))
        assertFalse(Solution().mergeTriplets(triplets, intArrayOf(2, 5, 4)))
    }

    @Test
    fun example3() {
        val triplets = arrayOf(intArrayOf(2, 5, 3), intArrayOf(2, 3, 4), intArrayOf(1, 2, 5))
        assertTrue(Solution().mergeTriplets(triplets, intArrayOf(2, 5, 3)))
    }

    @Test
    fun singleMatchingTriplet() {
        val triplets = arrayOf(intArrayOf(1, 1, 1))
        assertTrue(Solution().mergeTriplets(triplets, intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleLargerTriplet() {
        val triplets = arrayOf(intArrayOf(2, 2, 2))
        assertFalse(Solution().mergeTriplets(triplets, intArrayOf(1, 1, 1)))
    }
}
