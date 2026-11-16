package countspecialsubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSpecialSubsequencesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1L, solution.numberOfSubsequences(intArrayOf(1, 2, 3, 4, 3, 6, 1)))
    }

    @Test
    fun example2() {
        assertEquals(3L, solution.numberOfSubsequences(intArrayOf(3, 4, 3, 4, 3, 4, 3, 4)))
    }

    @Test
    fun tooShort() {
        assertEquals(0L, solution.numberOfSubsequences(intArrayOf(1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun allOnes() {
        assertEquals(1L, solution.numberOfSubsequences(intArrayOf(1, 1, 1, 1, 1, 1, 1)))
    }
}
