package countnumberofspecialsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfSpecialSubsequencesTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().countSpecialSubsequences(intArrayOf(0, 1, 2, 2)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(7, Solution().countSpecialSubsequences(intArrayOf(0, 1, 2, 0, 1, 2)))
    }

    @Test
    fun noSpecialSubsequence() {
        assertEquals(0, Solution().countSpecialSubsequences(intArrayOf(2, 2, 2, 2)))
        assertEquals(0, Solution().countSpecialSubsequences(intArrayOf()))
    }

    @Test
    fun duplicatePrefixesAndUnsortedInput() {
        assertEquals(3, Solution().countSpecialSubsequences(intArrayOf(0, 0, 1, 2)))
        assertEquals(3, Solution().countSpecialSubsequences(intArrayOf(1, 0, 2, 0, 1, 2)))
    }
}
