package countandsay

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAndSayTest {
    private val solution = Solution()

    @Test
    fun testOne() {
        assertEquals("1", solution.countAndSay(1))
    }

    @Test
    fun testFour() {
        assertEquals("1211", solution.countAndSay(4))
    }

    @Test
    fun testFive() {
        assertEquals("111221", solution.countAndSay(5))
    }
}
