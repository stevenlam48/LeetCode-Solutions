package minimumcommonvalue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCommonValueTest {
    @Test
    fun standardExamples() {
        assertEquals(2, Solution().getCommon(intArrayOf(1, 2, 3), intArrayOf(2, 4)))
        assertEquals(2, Solution().getCommon(intArrayOf(1, 2, 3, 6), intArrayOf(2, 3, 4, 5)))
    }

    @Test
    fun noCommonValue() {
        assertEquals(-1, Solution().getCommon(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8)))
    }

    @Test
    fun singleElements() {
        assertEquals(5, Solution().getCommon(intArrayOf(5), intArrayOf(5)))
        assertEquals(-1, Solution().getCommon(intArrayOf(5), intArrayOf(6)))
    }

    @Test
    fun duplicates() {
        assertEquals(1, Solution().getCommon(intArrayOf(1, 1, 2), intArrayOf(1, 3)))
    }
}
