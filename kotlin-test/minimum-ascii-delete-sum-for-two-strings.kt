package minimumasciideletesumfortwostrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAsciiDeleteSumForTwoStringsTest {
    @Test
    fun standardExample() = assertEquals(231, Solution().minimumDeleteSum("sea", "eat"))

    @Test
    fun partialCommonSubsequence() = assertEquals(403, Solution().minimumDeleteSum("delete", "leet"))

    @Test
    fun equalStrings() = assertEquals(0, Solution().minimumDeleteSum("abc", "abc"))

    @Test
    fun emptyString() = assertEquals(294, Solution().minimumDeleteSum("", "abc"))
}
