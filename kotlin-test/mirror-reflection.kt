package mirrorreflection

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MirrorReflectionTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.mirrorReflection(2, 1))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.mirrorReflection(3, 1))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.mirrorReflection(3, 2))
    }

    @Test
    fun testEqual() {
        assertEquals(1, solution.mirrorReflection(1, 1))
    }

    @Test
    fun testSquare() {
        assertEquals(1, solution.mirrorReflection(2, 2))
    }
}
