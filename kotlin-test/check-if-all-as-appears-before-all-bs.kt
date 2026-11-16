package checkifallasappearsbeforeallbs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAllAsAppearsBeforeAllBsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.checkString("aaabbb"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.checkString("abab"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.checkString("bbb"))
    }

    @Test
    fun testSingleCharacter() {
        assertTrue(solution.checkString("a"))
        assertTrue(solution.checkString("b"))
    }
}
