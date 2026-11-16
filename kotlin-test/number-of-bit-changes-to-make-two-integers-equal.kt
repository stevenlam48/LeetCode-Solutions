package numberofbitchangestomaketwointegersequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfBitChangesToMakeTwoIntegersEqualTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minChanges(13, 4))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().minChanges(21, 21))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().minChanges(14, 13))
    }

    @Test
    fun bothZero() {
        assertEquals(0, Solution().minChanges(0, 0))
    }

    @Test
    fun clearSingleBit() {
        assertEquals(1, Solution().minChanges(1, 0))
    }

    @Test
    fun clearSeveralBits() {
        assertEquals(3, Solution().minChanges(7, 0))
    }
}
