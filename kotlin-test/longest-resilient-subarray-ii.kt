package longestresilientsubarrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestResilientSubarrayIiTest {
    @Test
    fun allValuesFormAResilientSubarray() {
        assertEquals(3, Solution().resilientSubarray(intArrayOf(2, 4, 6), 2))
    }

    @Test
    fun changingRemaindersResetTheWindow() {
        assertEquals(1, Solution().resilientSubarray(intArrayOf(1, 2, 3, 4), 2))
    }

    @Test
    fun longerWindowIsCheckedAfterAShorterFailure() {
        assertEquals(3, Solution().resilientSubarray(intArrayOf(2, 6, 10), 4))
    }

    @Test
    fun pairMayFailTheResilienceCondition() {
        assertEquals(1, Solution().resilientSubarray(intArrayOf(2, 6), 4))
    }
}
