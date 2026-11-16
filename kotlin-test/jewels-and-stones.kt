package jewelsandstones

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class JewelsAndStonesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.numJewelsInStones("aA", "aAAbbbb"))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.numJewelsInStones("z", "ZZ"))
    }

    @Test
    fun testEmptyJewels() {
        assertEquals(0, solution.numJewelsInStones("", "abc"))
    }

    @Test
    fun testEmptyStones() {
        assertEquals(0, solution.numJewelsInStones("abc", ""))
    }

    @Test
    fun testAllJewels() {
        assertEquals(4, solution.numJewelsInStones("a", "aaaa"))
    }
}
