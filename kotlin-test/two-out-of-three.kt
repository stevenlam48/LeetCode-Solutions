package twooutofthree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoOutOfThreeTest {
    @Test
    fun example1() {
        val result = Solution().twoOutOfThree(
            intArrayOf(1, 1, 3, 2),
            intArrayOf(2, 3),
            intArrayOf(3)
        )
        assertEquals(setOf(3, 2), result.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun example2() {
        val result = Solution().twoOutOfThree(
            intArrayOf(3, 1),
            intArrayOf(2, 3),
            intArrayOf(1, 2)
        )
        assertEquals(setOf(2, 3, 1), result.toSet())
        assertEquals(3, result.size)
    }

    @Test
    fun example3() {
        assertEquals(emptyList<Int>(), Solution().twoOutOfThree(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        ))
    }
}
