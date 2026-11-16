package maximizenumberofsubsequencesinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeNumberOfSubsequencesInAStringTest {
    @Test
    fun firstExample() {
        assertEquals(4L, Solution().maximumSubsequenceCount("abdcdbc", "ac"))
    }

    @Test
    fun secondExample() {
        assertEquals(6L, Solution().maximumSubsequenceCount("aabb", "ab"))
    }

    @Test
    fun equalPatternCharactersCountEveryPair() {
        assertEquals(10L, Solution().maximumSubsequenceCount("aaaa", "aa"))
    }

    @Test
    fun emptyTextHasNoSubsequence() {
        assertEquals(0L, Solution().maximumSubsequenceCount("", "ab"))
    }
}
