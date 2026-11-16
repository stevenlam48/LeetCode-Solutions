package bulbswitcheriv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BulbSwitcherIvTest {
    @Test
    fun alternatingWithRepeatedSuffix() {
        assertEquals(3, Solution().minFlips("10111"))
    }

    @Test
    fun alreadyAllOff() {
        assertEquals(0, Solution().minFlips("00000"))
    }

    @Test
    fun singleTransition() {
        assertEquals(1, Solution().minFlips("0011"))
    }

    @Test
    fun everyCharacterChanges() {
        assertEquals(5, Solution().minFlips("10101"))
    }
}
