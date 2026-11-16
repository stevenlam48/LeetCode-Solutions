package findthenumberofsubarrayswhereboundaryelementsaremaximum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfSubarraysWhereBoundaryElementsAreMaximumTest {
    @Test
    fun repeatedMaximaWithSmallerValuesBetween() {
        assertEquals(5L, Solution().numberOfSubarrays(intArrayOf(1, 4, 2, 4)))
    }

    @Test
    fun everySubarrayOfEqualElementsCounts() {
        assertEquals(6L, Solution().numberOfSubarrays(intArrayOf(1, 1, 1)))
    }

    @Test
    fun strictlyDifferentValuesOnlyCountSingletons() {
        assertEquals(3L, Solution().numberOfSubarrays(intArrayOf(3, 1, 2)))
    }

    @Test
    fun largerInteriorValueInvalidatesSymmetricSubarray() {
        assertEquals(5L, Solution().numberOfSubarrays(intArrayOf(1, 2, 3, 2, 1)))
    }
}
