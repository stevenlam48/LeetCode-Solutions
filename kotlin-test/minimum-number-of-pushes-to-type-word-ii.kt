package minimumnumberofpushestotypewordii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfPushesToTypeWordIITest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(5, solution.minimumPushes("abcde"))
    }

    @Test
    fun repeatedLettersLeetCodeExample() {
        assertEquals(12, solution.minimumPushes("xyzxyzxyzxyz"))
    }

    @Test
    fun assignsKeysByDescendingFrequency() {
        assertEquals(18, solution.minimumPushes("aabbccddeeffgghhi"))
    }

    @Test
    fun repeatedSingleLetterNeedsOnePushEach() {
        assertEquals(4, solution.minimumPushes("aaaa"))
    }

    @Test
    fun handlesFullAlphabet() {
        assertEquals(56, solution.minimumPushes("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun handlesEmptyWord() {
        assertEquals(0, solution.minimumPushes(""))
    }
}
