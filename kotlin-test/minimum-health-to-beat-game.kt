package minimumhealthtobeatgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumHealthToBeatGameTest {
    @Test
    fun example1() {
        assertEquals(13L, Solution().minimumHealth(intArrayOf(2, 7, 4, 3), 4))
    }

    @Test
    fun example2() {
        assertEquals(10L, Solution().minimumHealth(intArrayOf(2, 5, 3, 4), 7))
    }

    @Test
    fun noArmor() {
        assertEquals(10L, Solution().minimumHealth(intArrayOf(3, 3, 3), 0))
    }

    @Test
    fun singleDamageBlockedByArmor() {
        assertEquals(1L, Solution().minimumHealth(intArrayOf(1), 5))
    }
}
