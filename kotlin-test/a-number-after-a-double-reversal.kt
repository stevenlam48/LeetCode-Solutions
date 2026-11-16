package anumberafteradoublereversal

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PanumberafteradoublereversalTest {
    @Test
    fun example1() {
        assertTrue(Solution().isSameAfterReversals(526))
    }

    @Test
    fun example2() {
        assertFalse(Solution().isSameAfterReversals(1800))
    }

    @Test
    fun example3() {
        assertTrue(Solution().isSameAfterReversals(0))
    }

    @Test
    fun trailingZero() {
        assertFalse(Solution().isSameAfterReversals(10))
    }

    @Test
    fun singleDigit() {
        assertTrue(Solution().isSameAfterReversals(7))
    }
}
