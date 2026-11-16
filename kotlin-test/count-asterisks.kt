package countasterisks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAsterisksTest {
    @Test
    fun example() {
        assertEquals(1, Solution().countAsterisks("l|*e*et|c|o|*de|"))
    }

    @Test
    fun noPairsOrAsterisks() {
        assertEquals(0, Solution().countAsterisks("iamprogrammer"))
        assertEquals(0, Solution().countAsterisks(""))
    }

    @Test
    fun asterisksInsideAndOutsidePairs() {
        assertEquals(3, Solution().countAsterisks("***|**|"))
        assertEquals(0, Solution().countAsterisks("|***|"))
    }
}
