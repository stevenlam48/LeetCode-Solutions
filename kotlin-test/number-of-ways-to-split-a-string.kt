package numberofwaystosplitastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToSplitAStringTest {
    @Test
    fun firstExample() {
        assertEquals(4, Solution().numWays("10101"))
    }

    @Test
    fun indivisibleOnes() {
        assertEquals(0, Solution().numWays("1001"))
    }

    @Test
    fun zerosOnly() {
        assertEquals(3, Solution().numWays("0000"))
    }

    @Test
    fun exactlyOneOnePerPart() {
        assertEquals(1, Solution().numWays("111"))
    }
}
