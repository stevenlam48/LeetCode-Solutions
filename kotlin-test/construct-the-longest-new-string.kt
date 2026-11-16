package constructthelongestnewstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConstructTheLongestNewStringTest {
    @Test
    fun testExample1() {
        assertEquals(12, Solution().longestString(2, 5, 1))
    }

    @Test
    fun testExample2() {
        assertEquals(14, Solution().longestString(3, 2, 2))
    }

    @Test
    fun testExample3() {
        assertEquals(16, Solution().longestString(2, 2, 4))
    }

    @Test
    fun testZeroAB() {
        assertEquals(2, Solution().longestString(0, 0, 1))
    }

    @Test
    fun testOnlyOneSide() {
        assertEquals(2, Solution().longestString(1, 0, 0))
    }
}
