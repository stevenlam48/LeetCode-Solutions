package minimumflipstomakebinarystringcoherent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFlipsToMakeBinaryStringCoherentTest {
    @Test
    fun singleZero() {
        assertEquals(0, Solution().minFlips("0"))
    }

    @Test
    fun singleOne() {
        assertEquals(0, Solution().minFlips("1"))
    }

    @Test
    fun alternatingString() {
        assertEquals(0, Solution().minFlips("010"))
    }

    @Test
    fun manyOnesBetweenOnes() {
        assertEquals(1, Solution().minFlips("11011"))
    }

    @Test
    fun onesBetweenZeros() {
        assertEquals(2, Solution().minFlips("01110"))
    }

    @Test
    fun longerMixedString() {
        assertEquals(2, Solution().minFlips("1011101"))
    }
}
