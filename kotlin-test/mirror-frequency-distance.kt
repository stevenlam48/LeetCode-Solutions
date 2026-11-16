package mirrorfrequencydistance

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MirrorFrequencyDistanceTest {
    private val solution = Solution()

    @Test
    fun testMirroredLetters() {
        assertEquals(0, solution.mirrorFrequency("az"))
    }

    @Test
    fun testSingleLetter() {
        assertEquals(1, solution.mirrorFrequency("a"))
    }

    @Test
    fun testMirroredDigits() {
        assertEquals(0, solution.mirrorFrequency("09"))
    }

    @Test
    fun testSingleDigit() {
        assertEquals(1, solution.mirrorFrequency("0"))
    }

    @Test
    fun testThreeLetters() {
        assertEquals(3, solution.mirrorFrequency("abc"))
    }

    @Test
    fun testMixed() {
        assertEquals(2, solution.mirrorFrequency("a1"))
    }
}
