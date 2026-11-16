package replacethesubstringforbalancedstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReplaceTheSubstringForBalancedStringTest {
    @Test
    fun alreadyBalanced() {
        assertEquals(0, Solution().balancedString("QWER"))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().balancedString("QQWE"))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().balancedString("QQQW"))
    }

    @Test
    fun example4() {
        assertEquals(3, Solution().balancedString("QQQQ"))
    }

    @Test
    fun singleChar() {
        assertEquals(1, Solution().balancedString("Q"))
    }

    @Test
    fun needsMiddleWindow() {
        assertEquals(3, Solution().balancedString("WQWRQQQW"))
    }
}
