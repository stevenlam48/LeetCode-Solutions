package minimumadjacentswapstoalternateparity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdjacentSwapsToAlternateParityTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minSwaps(intArrayOf(2, 4, 6, 5, 7)))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minSwaps(intArrayOf(2, 4, 5, 7)))
    }

    @Test
    fun alreadyAlternating() {
        assertEquals(0, Solution().minSwaps(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allOdd() {
        assertEquals(-1, Solution().minSwaps(intArrayOf(1, 1, 1)))
    }

    @Test
    fun allEven() {
        assertEquals(-1, Solution().minSwaps(intArrayOf(2, 2, 2)))
    }

    @Test
    fun twoElements() {
        assertEquals(0, Solution().minSwaps(intArrayOf(1, 2)))
    }
}
