package palindromepartitioningiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PalindromePartitioningIiiTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(1, solution.palindromePartition("abc", 2))
        assertEquals(0, solution.palindromePartition("aab", 2))
    }

    @Test
    fun singlePartition() {
        assertEquals(0, solution.palindromePartition("racecar", 1))
        assertEquals(2, solution.palindromePartition("abcde", 1))
    }

    @Test
    fun multiplePartitions() {
        assertEquals(1, solution.palindromePartition("abcde", 3))
        assertEquals(2, solution.palindromePartition("abcde", 2))
    }

    @Test
    fun everyCharacterIsAPartition() {
        assertEquals(0, solution.palindromePartition("abcdef", 6))
        assertEquals(0, solution.palindromePartition("a", 1))
    }
}
