package p2keyskeyboard

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class P2keyskeyboardTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minSteps(3))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().minSteps(1))
    }

    @Test
    fun prime() {
        assertEquals(7, Solution().minSteps(7))
    }

    @Test
    fun composite() {
        assertEquals(6, Solution().minSteps(9))
    }

    @Test
    fun powerOfTwo() {
        assertEquals(8, Solution().minSteps(16))
    }
}
