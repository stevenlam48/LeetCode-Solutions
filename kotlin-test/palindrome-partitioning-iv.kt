package palindromepartitioningiv

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromePartitioningIvTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertTrue(solution.checkPartitioning("abcbdd"))
        assertFalse(solution.checkPartitioning("bcbddxy"))
    }

    @Test
    fun repeatedCharacter() {
        assertTrue(solution.checkPartitioning("aaa"))
        assertTrue(solution.checkPartitioning("aaaa"))
    }

    @Test
    fun tooShortForThreeParts() {
        assertFalse(solution.checkPartitioning(""))
        assertFalse(solution.checkPartitioning("a"))
        assertFalse(solution.checkPartitioning("aa"))
    }

    @Test
    fun singlePalindromeIsNotEnough() {
        assertTrue(solution.checkPartitioning("aba"))
        assertFalse(solution.checkPartitioning("abcd"))
    }
}
