package countksubsequencesofastringwithmaximumbeauty

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountKSubsequencesOfAStringWithMaximumBeautyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.countKSubsequencesWithMaxBeauty("bcca", 2))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.countKSubsequencesWithMaxBeauty("abbcd", 4))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(4, solution.countKSubsequencesWithMaxBeauty("abcd", 3))
    }

    @Test
    fun testDuplicateFrequencies() {
        assertEquals(2, solution.countKSubsequencesWithMaxBeauty("aab", 2))
    }

    @Test
    fun testNotEnoughDistinct() {
        assertEquals(0, solution.countKSubsequencesWithMaxBeauty("a", 2))
    }
}
