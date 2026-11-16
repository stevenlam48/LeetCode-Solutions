package maximumstrongpairxorii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStrongPairXorIITest {
    @Test
    fun example1() {
        assertEquals(7, Solution().maximumStrongPairXor(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun noStrongPair() {
        assertEquals(0, Solution().maximumStrongPairXor(intArrayOf(10, 100)))
    }

    @Test
    fun duplicates() {
        assertEquals(0, Solution().maximumStrongPairXor(intArrayOf(5, 5, 5)))
    }

    @Test
    fun twoValues() {
        assertEquals(3, Solution().maximumStrongPairXor(intArrayOf(1, 2)))
    }

    @Test
    fun singleValue() {
        assertEquals(0, Solution().maximumStrongPairXor(intArrayOf(7)))
    }
}
