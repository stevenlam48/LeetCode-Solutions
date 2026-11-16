package divisorgame

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DivisorGameTest {
    @Test
    fun one() {
        assertFalse(Solution().divisorGame(1))
    }

    @Test
    fun two() {
        assertTrue(Solution().divisorGame(2))
    }

    @Test
    fun three() {
        assertFalse(Solution().divisorGame(3))
    }

    @Test
    fun four() {
        assertTrue(Solution().divisorGame(4))
    }

    @Test
    fun largeEven() {
        assertTrue(Solution().divisorGame(1000))
    }

    @Test
    fun largeOdd() {
        assertFalse(Solution().divisorGame(999))
    }
}
