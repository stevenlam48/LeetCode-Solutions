package findnthsmallestintegerwithkonebits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNthSmallestIntegerWithKOneBitsTest {
    private val solution = Solution()

    @Test
    fun singleOneBit() {
        assertEquals(16L, solution.nthSmallest(5, 1))
    }

    @Test
    fun twoOneBits() {
        assertEquals(9L, solution.nthSmallest(4, 2))
    }

    @Test
    fun threeOneBits() {
        assertEquals(14L, solution.nthSmallest(4, 3))
    }

    @Test
    fun largerCombination() {
        assertEquals(93L, solution.nthSmallest(10, 5))
    }
}
