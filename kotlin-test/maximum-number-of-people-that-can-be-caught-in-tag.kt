package maximumnumberofpeoplethatcanbecaughtintag

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofpeoplethatcanbecaughtintagTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().catchMaximumAmountofPeople(intArrayOf(0, 1, 0, 1, 0), 3))
    }

    @Test
    fun oneCatcher() {
        assertEquals(1, Solution().catchMaximumAmountofPeople(intArrayOf(1, 0, 0), 1))
    }

    @Test
    fun zeroDistance() {
        assertEquals(0, Solution().catchMaximumAmountofPeople(intArrayOf(1, 1, 0), 0))
    }

    @Test
    fun noTargets() {
        assertEquals(0, Solution().catchMaximumAmountofPeople(intArrayOf(0, 0, 0), 2))
    }

    @Test
    fun noCatchers() {
        assertEquals(0, Solution().catchMaximumAmountofPeople(intArrayOf(1, 1, 1), 2))
    }
}
