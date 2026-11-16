package timeneededtoinformallemployees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TimeNeededToInformAllEmployeesTest {
    private val solution = Solution()

    @Test
    fun singleEmployee() {
        assertEquals(0, solution.numOfMinutes(1, 0, intArrayOf(-1), intArrayOf(0)))
    }

    @Test
    fun oneHeadInformsEveryone() {
        assertEquals(1, solution.numOfMinutes(6, 2, intArrayOf(2, 2, -1, 2, 2, 2), intArrayOf(0, 0, 1, 0, 0, 0)))
    }

    @Test
    fun deepestChainDeterminesTime() {
        assertEquals(6, solution.numOfMinutes(4, 0, intArrayOf(-1, 0, 1, 2), intArrayOf(1, 2, 3, 0)))
    }

    @Test
    fun laterBranchTakesLonger() {
        assertEquals(7, solution.numOfMinutes(5, 0, intArrayOf(-1, 0, 0, 1, 2), intArrayOf(1, 1, 5, 5, 0)))
    }
}
