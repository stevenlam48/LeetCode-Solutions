package minimumabsolutedistancebetweenmirrorpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDistanceBetweenMirrorPairsTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minMirrorPairDistance(intArrayOf(12, 21, 45, 33, 54)))
    }

    @Test
    fun trailingZero() {
        assertEquals(1, Solution().minMirrorPairDistance(intArrayOf(120, 21)))
    }

    @Test
    fun noPair() {
        assertEquals(-1, Solution().minMirrorPairDistance(intArrayOf(21, 120)))
    }

    @Test
    fun singleDigit() {
        assertEquals(1, Solution().minMirrorPairDistance(intArrayOf(10, 1)))
    }

    @Test
    fun zeros() {
        assertEquals(1, Solution().minMirrorPairDistance(intArrayOf(0, 0)))
    }

    @Test
    fun noMirror() {
        assertEquals(-1, Solution().minMirrorPairDistance(intArrayOf(1, 10)))
    }
}
