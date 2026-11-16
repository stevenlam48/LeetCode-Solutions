package findtheduplicatenumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDuplicateNumberTest {
    @Test
    fun findsDuplicateBesideCycle() {
        assertEquals(2, Solution().findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    }

    @Test
    fun findsDuplicateAtCycleEntry() {
        assertEquals(3, Solution().findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
    }

    @Test
    fun findsDuplicateRepeatedManyTimes() {
        assertEquals(3, Solution().findDuplicate(intArrayOf(3, 3, 3, 3, 3)))
    }

    @Test
    fun handlesThreeElementArray() {
        assertEquals(2, Solution().findDuplicate(intArrayOf(1, 2, 2)))
    }
}
