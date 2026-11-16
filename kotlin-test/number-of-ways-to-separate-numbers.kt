package numberofwaystoseparatenumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToSeparateNumbersTest {
    @Test
    fun firstExample() {
        assertEquals(2, Solution().numberOfCombinations("327"))
    }

    @Test
    fun leadingZero() {
        assertEquals(0, Solution().numberOfCombinations("094"))
    }

    @Test
    fun zeroOnly() {
        assertEquals(0, Solution().numberOfCombinations("0"))
    }

    @Test
    fun equalParts() {
        assertEquals(3, Solution().numberOfCombinations("111"))
    }

    @Test
    fun increasingParts() {
        assertEquals(3, Solution().numberOfCombinations("123"))
    }
}
