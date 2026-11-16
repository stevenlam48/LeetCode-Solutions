package uncrossedlines

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UncrossedLinesTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxUncrossedLines(intArrayOf(1, 4, 2), intArrayOf(1, 2, 4)))
    }

    @Test
    fun example2() {
        assertEquals(
            3,
            Solution().maxUncrossedLines(intArrayOf(2, 5, 1, 2, 5), intArrayOf(10, 5, 2, 1, 5, 2))
        )
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().maxUncrossedLines(intArrayOf(1, 3, 7, 1, 7, 5), intArrayOf(1, 9, 2, 5, 1)))
    }

    @Test
    fun noCommon() {
        assertEquals(0, Solution().maxUncrossedLines(intArrayOf(1, 2), intArrayOf(3, 4)))
    }
}
