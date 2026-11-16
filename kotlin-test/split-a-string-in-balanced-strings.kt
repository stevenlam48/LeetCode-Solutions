package splitastringinbalancedstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SplitAStringInBalancedStringsTest {
    @Test
    fun exampleOne() {
        assertEquals(4, Solution().balancedStringSplit("RLRRLLRLRL"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, Solution().balancedStringSplit("RLRRRLLRLL"))
    }

    @Test
    fun allLeftThenAllRight() {
        assertEquals(1, Solution().balancedStringSplit("LLLLRRRR"))
    }

    @Test
    fun minimalBalanced() {
        assertEquals(1, Solution().balancedStringSplit("RL"))
        assertEquals(3, Solution().balancedStringSplit("RLRLRL"))
    }
}
