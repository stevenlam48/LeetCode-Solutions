package partitionstringintosubstringswithvaluesatmostk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionStringIntoSubstringsWithValuesAtMostKTest {
    private val solution = Solution()

    @Test
    fun greedilyBuildsLargestValidSubstrings() {
        assertEquals(4, solution.minimumPartition("165462", 60))
    }

    @Test
    fun separatesValuesForSmallLimit() {
        assertEquals(6, solution.minimumPartition("238182", 9))
    }

    @Test
    fun rejectsDigitLargerThanLimit() {
        assertEquals(-1, solution.minimumPartition("9", 3))
    }

    @Test
    fun handlesSingleValidDigit() {
        assertEquals(1, solution.minimumPartition("7", 7))
    }
}
