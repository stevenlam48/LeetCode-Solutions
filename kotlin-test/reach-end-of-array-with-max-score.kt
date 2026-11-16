package reachendofarraywithmaxscore
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReachEndOfArrayWithMaxScoreTest {
    @Test
    fun leetCodeExample() {
        assertEquals(7L, Solution().findMaximumScore(intArrayOf(1, 3, 1, 5)))
    }

    @Test
    fun decreasingAndSingleElementArrays() {
        assertEquals(12L, Solution().findMaximumScore(intArrayOf(4, 3, 2, 1)))
        assertEquals(0L, Solution().findMaximumScore(intArrayOf(9)))
        assertEquals(0L, Solution().findMaximumScore(intArrayOf()))
    }

    @Test
    fun scoreUsesLongAccumulator() {
        assertEquals(6442450941L, Solution().findMaximumScore(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)))
    }
}
