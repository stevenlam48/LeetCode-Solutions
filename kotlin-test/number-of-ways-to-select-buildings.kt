package numberofwaystoselectbuildings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToSelectBuildingsTest {
    @Test
    fun firstExample() {
        assertEquals(6L, Solution().numberOfWays("001101"))
    }

    @Test
    fun secondExample() {
        assertEquals(0L, Solution().numberOfWays("11100"))
    }

    @Test
    fun alternatingTriplet() {
        assertEquals(1L, Solution().numberOfWays("010"))
        assertEquals(1L, Solution().numberOfWays("101"))
    }

    @Test
    fun repeatedBuildings() {
        assertEquals(0L, Solution().numberOfWays("000"))
    }
}
