package countrotationswithexactlykequaladjacentpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountRotationsWithExactlyKEqualAdjacentPairsTest {
    private val solution = Solution()

    @Test
    fun oneEqualAdjacentPair() {
        val s = "aabc"
        assertEquals(3, solution.countRotations(s, 1))
        assertEquals(0, solution.countRotations(s, 2))
    }

    @Test
    fun zeroOriginalEqualPairs() {
        assertEquals(1, solution.countRotations("aabc", 0))
        assertEquals(2, solution.countRotations("ab", 0))
    }

    @Test
    fun allCharactersEqual() {
        assertEquals(3, solution.countRotations("aaa", 2))
        assertEquals(0, solution.countRotations("aaa", 3))
    }
}
