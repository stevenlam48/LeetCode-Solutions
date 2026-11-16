package checkifnumberisasumofpowersofthree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfNumberIsASumOfPowersOfThreeTest {
    private val solution = Solution()

    @Test
    fun sumOfNineAndThree() {
        assertTrue(solution.checkPowersOfThree(12))
    }

    @Test
    fun sumOfThreeDistinctPowers() {
        assertTrue(solution.checkPowersOfThree(91))
    }

    @Test
    fun repeatedPowerRequired() {
        assertFalse(solution.checkPowersOfThree(21))
    }

    @Test
    fun twoRequiresRepeatedOnes() {
        assertFalse(solution.checkPowersOfThree(2))
    }

    @Test
    fun oneIsPowerOfThree() {
        assertTrue(solution.checkPowersOfThree(1))
    }
}
