package maximumnumberofgroupsgettingfreshdonuts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfGroupsGettingFreshDonutsTest {
    private val solution = Solution()

    @Test
    fun standardExampleWithBatchSizeThree() {
        assertEquals(4, solution.maxHappyGroups(3, intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun standardExampleWithBatchSizeFour() {
        assertEquals(3, solution.maxHappyGroups(4, intArrayOf(1, 3, 2, 5, 2, 1)))
    }

    @Test
    fun complementaryRemainders() {
        assertEquals(4, solution.maxHappyGroups(7, intArrayOf(1, 2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun allGroupsAreFreshImmediately() {
        assertEquals(3, solution.maxHappyGroups(3, intArrayOf(3, 6, 9)))
    }

    @Test
    fun singleNonDivisibleGroup() {
        assertEquals(1, solution.maxHappyGroups(3, intArrayOf(1)))
    }

    @Test
    fun evenBatchSizeWithOnlyHalfRemainders() {
        assertEquals(2, solution.maxHappyGroups(4, intArrayOf(2, 2, 2, 2)))
    }
}
