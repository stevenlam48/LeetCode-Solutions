package subsequenceswithauniquemiddlemodei

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsequencesWithAUniqueMiddleModeITest {
    @Test
    fun testAllSame() {
        assertEquals(6, Solution().subsequencesWithMiddleMode(intArrayOf(1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun testAlternating() {
        assertEquals(4, Solution().subsequencesWithMiddleMode(intArrayOf(1, 2, 1, 2, 1, 2)))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(0, Solution().subsequencesWithMiddleMode(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun testNoUniqueMode() {
        assertEquals(0, Solution().subsequencesWithMiddleMode(intArrayOf(1, 1, 2, 2, 1, 1)))
    }

    @Test
    fun testFiveElements() {
        assertEquals(1, Solution().subsequencesWithMiddleMode(intArrayOf(2, 2, 2, 2, 2)))
    }

    @Test
    fun testLonger() {
        assertEquals(14, Solution().subsequencesWithMiddleMode(intArrayOf(1, 2, 1, 2, 1, 2, 1)))
    }
}
