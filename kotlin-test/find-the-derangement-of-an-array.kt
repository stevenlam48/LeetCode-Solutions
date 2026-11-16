package findthederangementofanarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDerangementOfAnArrayTest {
    @Test
    fun countsDerangementsOfThreeElements() {
        assertEquals(2, Solution().findDerangement(3))
    }

    @Test
    fun countsDerangementsOfFourElements() {
        assertEquals(9, Solution().findDerangement(4))
    }

    @Test
    fun handlesZeroAndOneElement() {
        assertEquals(1, Solution().findDerangement(0))
        assertEquals(0, Solution().findDerangement(1))
    }

    @Test
    fun handlesTenElements() {
        assertEquals(1334961, Solution().findDerangement(10))
    }
}
