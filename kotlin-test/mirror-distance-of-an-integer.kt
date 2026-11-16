package mirrordistanceofaninteger

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MirrorDistanceOfAnIntegerTest {
    private val solution = Solution()

    @Test
    fun testTwoDigits() {
        assertEquals(27, solution.mirrorDistance(25))
    }

    @Test
    fun testTrailingZero() {
        assertEquals(9, solution.mirrorDistance(10))
    }

    @Test
    fun testSingleDigit() {
        assertEquals(0, solution.mirrorDistance(7))
    }

    @Test
    fun testHundred() {
        assertEquals(99, solution.mirrorDistance(100))
    }

    @Test
    fun testThreeDigits() {
        assertEquals(198, solution.mirrorDistance(123))
    }
}
