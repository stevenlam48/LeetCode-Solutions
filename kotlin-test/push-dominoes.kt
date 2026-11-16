package pushdominoes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PushDominoesTest {
    private val solution = Solution()

    @Test
    fun validCase1() {
        assertEquals("RR.L", solution.pushDominoes("RR.L"))
    }

    @Test
    fun validCase2() {
        assertEquals("LL.RR.LLRRLL..", solution.pushDominoes(".L.R...LR..L.."))
    }

    @Test
    fun validCase3_noForce() {
        assertEquals(".", solution.pushDominoes("."))
    }

    @Test
    fun validCase4_oppositeForces() {
        assertEquals("R.L", solution.pushDominoes("R.L"))
    }

    @Test
    fun validCase5_rightEdge() {
        assertEquals("R", solution.pushDominoes("R"))
    }

    @Test
    fun validCase6_leftEdge() {
        assertEquals("L", solution.pushDominoes("L"))
    }
}
