package uglynumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UglyNumberTest {
    @Test
    fun example() {
        assertTrue(Solution().isUgly(6))
    }

    @Test
    fun one() {
        assertTrue(Solution().isUgly(1))
    }

    @Test
    fun exampleFalse() {
        assertFalse(Solution().isUgly(14))
    }

    @Test
    fun zero() {
        assertFalse(Solution().isUgly(0))
    }

    @Test
    fun negative() {
        assertFalse(Solution().isUgly(-6))
    }

    @Test
    fun powers() {
        assertTrue(Solution().isUgly(8))
        assertTrue(Solution().isUgly(30))
    }
}
