package putmarblesinbags

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PutMarblesInBagsTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        val actual = solution.putMarbles(intArrayOf(1, 3, 5, 1), 2)
        assertEquals(4L, actual)
    }

    @Test
    fun validCase2_twoMarbles() {
        val actual = solution.putMarbles(intArrayOf(1, 3), 2)
        assertEquals(0L, actual)
    }

    @Test
    fun validCase3_oneBag() {
        val actual = solution.putMarbles(intArrayOf(1, 2, 3), 1)
        assertEquals(0L, actual)
    }

    @Test
    fun validCase4_equalBoundarySums() {
        val actual = solution.putMarbles(intArrayOf(1, 1, 1, 1), 3)
        assertEquals(0L, actual)
    }

    @Test
    fun validCase5_differentCuts() {
        val actual = solution.putMarbles(intArrayOf(2, 4, 1, 3, 5), 3)
        assertEquals(5L, actual)
    }

    @Test
    fun validCase6_eachMarbleSeparate() {
        val actual = solution.putMarbles(intArrayOf(1, 2, 3, 4), 4)
        assertEquals(0L, actual)
    }
}
