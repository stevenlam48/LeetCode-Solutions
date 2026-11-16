package threeequalparts

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ThreeEqualPartsTest {
    private val solution = Solution()

    @Test
    fun equalSingleBitParts() {
        assertArrayEquals(intArrayOf(0, 3), solution.threeEqualParts(intArrayOf(1, 0, 1, 0, 1)))
    }

    @Test
    fun leadingOneCannotBeShared() {
        assertArrayEquals(intArrayOf(-1, -1), solution.threeEqualParts(intArrayOf(1, 1, 1, 0, 1)))
    }

    @Test
    fun differentBitPatterns() {
        assertArrayEquals(intArrayOf(-1, -1), solution.threeEqualParts(intArrayOf(1, 0, 1, 1, 0, 0, 1)))
    }

    @Test
    fun allZerosCanBeSplitAnywhere() {
        assertArrayEquals(intArrayOf(0, 4), solution.threeEqualParts(IntArray(5)))
    }

    @Test
    fun trailingZerosBelongToAllThreeParts() {
        assertArrayEquals(intArrayOf(1, 5), solution.threeEqualParts(intArrayOf(0, 1, 0, 0, 1, 0, 0, 1)))
    }
}
