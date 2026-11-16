package findthekbeautyofanumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKBeautyOfANumberTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().divisorSubstrings(240, 2))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().divisorSubstrings(430043, 2))
    }

    @Test
    fun singleDigit() {
        assertEquals(1, Solution().divisorSubstrings(1, 1))
    }

    @Test
    fun zerosAreSkipped() {
        assertEquals(1, Solution().divisorSubstrings(100, 1))
    }

    @Test
    fun wholeNumber() {
        assertEquals(1, Solution().divisorSubstrings(10, 2))
    }
}
