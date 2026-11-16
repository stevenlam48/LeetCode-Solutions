package numberofwaystodividealongcorridor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToDivideALongCorridorTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().numberOfWays("SSPPSPS"))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().numberOfWays("PPSPSP"))
    }

    @Test
    fun singleSeat() {
        assertEquals(0, Solution().numberOfWays("S"))
    }

    @Test
    fun fourSeats() {
        assertEquals(1, Solution().numberOfWays("SSSS"))
    }

    @Test
    fun gapOfTwo() {
        assertEquals(2, Solution().numberOfWays("SSPSS"))
    }
}
