package maximumnumberthatmakesresultofbitwiseandzero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberthatmakesresultofbitwiseandzeroTest {
    @Test
    fun seven() {
        assertEquals(3L, Solution().maxNumber(7L))
    }

    @Test
    fun nine() {
        assertEquals(7L, Solution().maxNumber(9L))
    }

    @Test
    fun one() {
        assertEquals(0L, Solution().maxNumber(1L))
    }

    @Test
    fun fifteen() {
        assertEquals(7L, Solution().maxNumber(15L))
    }

    @Test
    fun powerOfTwo() {
        assertEquals(15L, Solution().maxNumber(16L))
    }

    @Test
    fun hundred() {
        assertEquals(63L, Solution().maxNumber(100L))
    }
}
