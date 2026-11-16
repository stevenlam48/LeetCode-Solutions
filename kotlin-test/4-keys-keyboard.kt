package p4keyskeyboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P4keyskeyboardTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maxA(3))
    }

    @Test
    fun example2() {
        assertEquals(9, Solution().maxA(7))
    }

    @Test
    fun ten() {
        assertEquals(20, Solution().maxA(10))
    }

    @Test
    fun small() {
        assertEquals(1, Solution().maxA(1))
        assertEquals(6, Solution().maxA(6))
    }

    @Test
    fun larger() {
        assertEquals(27, Solution().maxA(11))
    }
}
