package powerofheroes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PowerOfHeroesTest {
    @Test
    fun standardExample() {
        assertEquals(141, Solution().sumOfPower(intArrayOf(2, 1, 4)))
    }

    @Test
    fun duplicateValues() {
        assertEquals(7, Solution().sumOfPower(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleHero() {
        assertEquals(125, Solution().sumOfPower(intArrayOf(5)))
    }

    @Test
    fun zeroPower() {
        assertEquals(0, Solution().sumOfPower(intArrayOf(0)))
    }
}
