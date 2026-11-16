package smallestgoodbase

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestGoodBaseTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("3", solution.smallestGoodBase("13"))
    }

    @Test
    fun testExample2() {
        assertEquals("8", solution.smallestGoodBase("4681"))
    }

    @Test
    fun testExample3() {
        assertEquals("999999999999999999", solution.smallestGoodBase("1000000000000000000"))
    }

    @Test
    fun testThree() {
        assertEquals("2", solution.smallestGoodBase("3"))
    }

    @Test
    fun testSeven() {
        assertEquals("2", solution.smallestGoodBase("7"))
    }
}
