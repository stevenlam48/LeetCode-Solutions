package p1bitand2bitcharacters

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class P1bitand2bitcharactersTest {
    @Test
    fun example1() {
        assertTrue(Solution().isOneBitCharacter(intArrayOf(1, 0, 0)))
    }

    @Test
    fun example2() {
        assertFalse(Solution().isOneBitCharacter(intArrayOf(1, 1, 1, 0)))
    }

    @Test
    fun singleZero() {
        assertTrue(Solution().isOneBitCharacter(intArrayOf(0)))
    }

    @Test
    fun singleOne() {
        assertTrue(Solution().isOneBitCharacter(intArrayOf(1)))
    }

    @Test
    fun trailingZeroAfterPair() {
        assertTrue(Solution().isOneBitCharacter(intArrayOf(1, 1, 0)))
    }

    @Test
    fun trailingZeroAfterTriple() {
        assertFalse(Solution().isOneBitCharacter(intArrayOf(1, 1, 1, 0)))
    }
}
