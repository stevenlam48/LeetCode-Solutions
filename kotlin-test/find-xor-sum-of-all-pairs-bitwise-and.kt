package findxorsumofallpairsbitwiseand

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindXorSumOfAllPairsBitwiseAndTest {
    @Test
    fun exampleOne() {
        assertEquals(0, Solution().getXORSum(intArrayOf(1, 2, 3), intArrayOf(6, 5)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(4, Solution().getXORSum(intArrayOf(12), intArrayOf(4)))
    }

    @Test
    fun multipleBits() {
        assertEquals(8, Solution().getXORSum(intArrayOf(8, 3, 4), intArrayOf(10, 2)))
    }

    @Test
    fun emptyFirstArray() {
        assertEquals(0, Solution().getXORSum(intArrayOf(), intArrayOf(4, 7)))
    }
}
