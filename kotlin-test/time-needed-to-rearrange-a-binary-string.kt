package timeneededtorearrangeabinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeNeededToRearrangeABinaryStringTest {
    private val solution = Solution()

    @Test
    fun standardInput() {
        assertEquals(4, solution.secondsToRemoveOccurrences("0110101"))
    }

    @Test
    fun noOccurrences() {
        assertEquals(0, solution.secondsToRemoveOccurrences("11100"))
    }

    @Test
    fun separateOccurrences() {
        assertEquals(3, solution.secondsToRemoveOccurrences("0011"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.secondsToRemoveOccurrences(""))
    }
}
