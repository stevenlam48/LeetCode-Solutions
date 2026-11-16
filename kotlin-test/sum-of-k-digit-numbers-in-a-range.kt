package sumofkdigitnumbersinarange

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfKDigitNumbersInARangeTest {
    @Test
    fun kEqualsOne() {
        assertEquals(3, Solution().sumOfNumbers(1, 2, 1))
        assertEquals(1, Solution().sumOfNumbers(1, 1, 1))
    }

    @Test
    fun twoValuesTwoBlocks() {
        assertEquals(66, Solution().sumOfNumbers(1, 2, 2))
    }

    @Test
    fun threeValuesTwoBlocks() {
        assertEquals(198, Solution().sumOfNumbers(1, 3, 2))
    }

    @Test
    fun singleValueRepeated() {
        assertEquals(555, Solution().sumOfNumbers(5, 5, 3))
    }
}
