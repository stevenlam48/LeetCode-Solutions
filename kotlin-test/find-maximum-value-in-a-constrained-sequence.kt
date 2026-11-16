package findmaximumvalueinaconstrainedsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumValueInAConstrainedSequenceTest {
    @Test
    fun example1() {
        val restrictions = arrayOf(intArrayOf(1, 3), intArrayOf(2, 2))
        assertEquals(3, Solution().findMaxVal(4, restrictions, intArrayOf(1, 1, 1)))
    }

    @Test
    fun example2() {
        val restrictions = arrayOf(intArrayOf(1, 2))
        assertEquals(3, Solution().findMaxVal(3, restrictions, intArrayOf(1, 2)))
    }

    @Test
    fun example3() {
        val restrictions = arrayOf(intArrayOf(1, 1), intArrayOf(2, 1))
        assertEquals(1, Solution().findMaxVal(3, restrictions, intArrayOf(1, 1)))
    }

    @Test
    fun noRestrictions() {
        assertEquals(6, Solution().findMaxVal(4, arrayOf(), intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().findMaxVal(1, arrayOf(), intArrayOf()))
    }

    @Test
    fun tightRestrictionAtEnd() {
        val restrictions = arrayOf(intArrayOf(3, 0))
        assertEquals(1, Solution().findMaxVal(4, restrictions, intArrayOf(1, 1, 1)))
    }
}
