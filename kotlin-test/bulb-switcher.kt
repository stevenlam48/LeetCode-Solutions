package bulbswitcher

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BulbSwitcherTest {
    @Test
    fun zeroBulbs() {
        assertEquals(0, Solution().bulbSwitch(0))
    }

    @Test
    fun oneBulb() {
        assertEquals(1, Solution().bulbSwitch(1))
    }

    @Test
    fun threeBulbs() {
        assertEquals(1, Solution().bulbSwitch(3))
    }

    @Test
    fun countsPerfectSquares() {
        assertEquals(3, Solution().bulbSwitch(9))
        assertEquals(3, Solution().bulbSwitch(15))
        assertEquals(4, Solution().bulbSwitch(16))
    }
}
