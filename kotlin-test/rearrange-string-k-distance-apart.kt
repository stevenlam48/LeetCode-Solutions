package rearrangestringkdistanceapart

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RearrangeStringKDistanceApartTest {
    private val solution = Solution()

    private fun assertValid(original: String, k: Int, result: String) {
        assertEquals(original.toList().sorted(), result.toList().sorted())
        for (i in result.indices) {
            for (j in i + 1 until minOf(result.length, i + k)) {
                assertNotEquals(result[i], result[j], "characters at $i and $j are too close in \"$result\"")
            }
        }
    }

    @Test
    fun testExample1() {
        val result = solution.rearrangeString("aabbcc", 3)
        assertEquals(6, result.length)
        assertValid("aabbcc", 3, result)
    }

    @Test
    fun testExample2() {
        assertEquals("", solution.rearrangeString("aaabc", 3))
    }

    @Test
    fun testExample3() {
        val result = solution.rearrangeString("aaadbbcc", 2)
        assertEquals(8, result.length)
        assertValid("aaadbbcc", 2, result)
    }

    @Test
    fun testZeroDistance() {
        assertEquals("aabbcc", solution.rearrangeString("aabbcc", 0))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", solution.rearrangeString("a", 1))
        assertEquals("a", solution.rearrangeString("a", 5))
    }

    @Test
    fun testImpossible() {
        assertEquals("", solution.rearrangeString("aa", 2))
        assertEquals("", solution.rearrangeString("aaa", 2))
    }
}
