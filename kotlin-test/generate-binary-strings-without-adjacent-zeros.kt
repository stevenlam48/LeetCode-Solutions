package generatebinarystringswithoutadjacentzeros

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class GenerateBinaryStringsWithoutAdjacentZerosTest {
    @Test
    fun oneBit() {
        assertEquals(setOf("0", "1"), Solution().validStrings(1).toSet())
    }

    @Test
    fun twoBits() {
        assertEquals(setOf("01", "10", "11"), Solution().validStrings(2).toSet())
    }

    @Test
    fun threeBits() {
        assertEquals(
            setOf("010", "011", "101", "110", "111"),
            Solution().validStrings(3).toSet()
        )
    }

    @Test
    fun fourBits() {
        val expected = setOf(
            "0101", "0110", "0111", "1010",
            "1011", "1101", "1110", "1111"
        )
        val actual = Solution().validStrings(4)
        assertEquals(8, actual.size)
        assertEquals(expected, actual.toSet())
    }

    @Test
    fun noAdjacentZerosForRange() {
        for (n in 1..8) {
            val result = Solution().validStrings(n)
            for (s in result) {
                assertEquals(n, s.length)
                assertFalse(s.contains("00"))
            }
        }
    }
}
