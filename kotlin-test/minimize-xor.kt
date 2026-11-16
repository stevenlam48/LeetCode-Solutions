package minimizexor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeXorTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minimizeXor(3, 5))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minimizeXor(1, 12))
    }

    @Test
    fun needsMoreBits() {
        assertEquals(11, Solution().minimizeXor(10, 7))
    }

    @Test
    fun samePopcount() {
        assertEquals(1, Solution().minimizeXor(1, 1))
    }

    @Test
    fun fewerBits() {
        assertEquals(4, Solution().minimizeXor(7, 1))
    }
}
