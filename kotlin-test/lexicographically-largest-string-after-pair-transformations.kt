package lexicographicallylargeststringafterpairtransformations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallyLargestStringAfterPairTransformationsTest {
    @Test
    fun singleBits() {
        assertEquals(listOf("a", "b", ""), Solution().largestString(intArrayOf(1, 2, 0)))
    }

    @Test
    fun twoBits() {
        assertEquals(listOf("ba"), Solution().largestString(intArrayOf(3)))
    }

    @Test
    fun zeroAndShift() {
        assertEquals(listOf("", "z"), Solution().largestString(intArrayOf(0, 1 shl 25)))
    }

    @Test
    fun thirdBit() {
        assertEquals(listOf("c"), Solution().largestString(intArrayOf(4)))
    }
}
