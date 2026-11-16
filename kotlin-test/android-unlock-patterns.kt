package androidunlockpatterns

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AndroidUnlockPatternsTest {
    @Test
    fun testLengthOne() {
        assertEquals(9, Solution().numberOfPatterns(1, 1))
    }

    @Test
    fun testLengthTwo() {
        assertEquals(65, Solution().numberOfPatterns(1, 2))
    }

    @Test
    fun testExactlyTwo() {
        assertEquals(56, Solution().numberOfPatterns(2, 2))
    }

    @Test
    fun testLengthThree() {
        assertEquals(385, Solution().numberOfPatterns(1, 3))
    }

    @Test
    fun testRange() {
        assertEquals(34792, Solution().numberOfPatterns(4, 6))
    }
}
