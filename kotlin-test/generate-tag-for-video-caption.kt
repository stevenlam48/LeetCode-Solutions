package generatetagforvideocaption

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerateTagForVideoCaptionTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals("#leetcodeDailyChallengeAchieved", solution.generateTag("Leetcode daily challenge achieved"))
        assertEquals("#canIGoThere", solution.generateTag("can I Go There"))
    }

    @Test
    fun `spaces and empty caption`() {
        val solution = Solution()
        assertEquals("#", solution.generateTag(""))
        assertEquals("#", solution.generateTag("   "))
        assertEquals("#helloWorld", solution.generateTag("  hello   world  "))
    }

    @Test
    fun `tag is truncated to one hundred characters`() {
        val solution = Solution()
        val result = solution.generateTag("a".repeat(150))
        assertEquals(100, result.length)
        assertEquals("#" + "a".repeat(99), result)
    }
}
