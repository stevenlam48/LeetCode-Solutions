package permutationinstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PermutationInStringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.checkInclusion("ab", "eidbaooo"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.checkInclusion("ab", "eidboaoo"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.checkInclusion("adc", "dcda"))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(solution.checkInclusion("a", "a"))
        assertFalse(solution.checkInclusion("a", "b"))
    }
}
