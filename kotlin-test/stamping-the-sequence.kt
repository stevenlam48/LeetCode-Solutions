package stampingthesequence

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StampingTheSequenceTest {
    private val solution = Solution()

    private fun isValid(stamp: String, target: String, moves: IntArray): Boolean {
        val n = target.length
        val m = stamp.length
        val cur = CharArray(n) { '?' }
        for (p in moves) {
            if (p < 0 || p > n - m) {
                return false
            }
            for (j in 0 until m) {
                cur[p + j] = stamp[j]
            }
        }
        return String(cur) == target
    }

    @Test
    fun testExample1() {
        val stamp = "abc"
        val target = "ababc"
        assertTrue(isValid(stamp, target, solution.movesToStamp(stamp, target)))
    }

    @Test
    fun testExample2() {
        val stamp = "abca"
        val target = "aabcaca"
        assertTrue(isValid(stamp, target, solution.movesToStamp(stamp, target)))
    }

    @Test
    fun testSingleChar() {
        val stamp = "a"
        val target = "a"
        assertTrue(isValid(stamp, target, solution.movesToStamp(stamp, target)))
    }

    @Test
    fun testExactMatch() {
        val stamp = "abc"
        val target = "abc"
        assertTrue(isValid(stamp, target, solution.movesToStamp(stamp, target)))
    }

    @Test
    fun testImpossible() {
        assertArrayEquals(intArrayOf(), solution.movesToStamp("ab", "a"))
    }
}
