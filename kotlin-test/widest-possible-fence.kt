package widestpossiblefence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WidestPossibleFenceTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(3, solution.maximumWidth(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun example2() {
        assertEquals(3, solution.maximumWidth(intArrayOf(1, 1, 2, 2, 3)))
    }

    @Test
    fun allSameLength() {
        assertEquals(5, solution.maximumWidth(intArrayOf(2, 2, 2, 2, 2)))
    }

    @Test
    fun singlePlank() {
        assertEquals(1, solution.maximumWidth(intArrayOf(7)))
    }

    @Test
    fun mixedLengths() {
        assertEquals(3, solution.maximumWidth(intArrayOf(1, 2, 2, 3, 3, 4)))
    }
}
