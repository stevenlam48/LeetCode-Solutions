package maximizegreatnessofanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeGreatnessOfAnArrayTest {
    @Test
    fun leetCodeExample() {
        assertEquals(6, Solution().maximizeGreatness(intArrayOf(1, 3, 5, 2, 1, 3, 6, 6)))
    }

    @Test
    fun allDistinctValues() {
        assertEquals(3, Solution().maximizeGreatness(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun allDuplicateValues() {
        assertEquals(0, Solution().maximizeGreatness(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun duplicatesAndNegativeValues() {
        assertEquals(2, Solution().maximizeGreatness(intArrayOf(-2, -2, 0, 1)))
    }
}
