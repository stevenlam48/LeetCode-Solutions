package minimumadditiontomakeintegerbeautiful

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdditionToMakeIntegerBeautifulTest {
    @Test
    fun example1() {
        assertEquals(4L, Solution().makeIntegerBeautiful(16L, 6))
    }

    @Test
    fun alreadyBeautiful() {
        assertEquals(0L, Solution().makeIntegerBeautiful(467L, 20))
    }

    @Test
    fun singleDigit() {
        assertEquals(0L, Solution().makeIntegerBeautiful(1L, 1))
    }

    @Test
    fun carryChain() {
        assertEquals(81L, Solution().makeIntegerBeautiful(19L, 1))
    }

    @Test
    fun allNines() {
        assertEquals(1L, Solution().makeIntegerBeautiful(999L, 1))
    }
}
