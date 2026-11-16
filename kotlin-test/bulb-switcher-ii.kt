package bulbswitcherii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BulbSwitcherIiTest {
    @Test
    fun noPressesLeaveOneState() {
        assertEquals(1, Solution().flipLights(3, 0))
    }

    @Test
    fun oneBulbHasTwoStatesAfterPresses() {
        assertEquals(2, Solution().flipLights(1, 1))
        assertEquals(2, Solution().flipLights(1, 4))
    }

    @Test
    fun onePressOnTwoBulbsHasThreeStates() {
        assertEquals(3, Solution().flipLights(2, 1))
    }

    @Test
    fun remainingCases() {
        assertEquals(4, Solution().flipLights(3, 1))
        assertEquals(7, Solution().flipLights(3, 2))
        assertEquals(8, Solution().flipLights(4, 3))
    }
}
