package firstuniqueevenelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstUniqueEvenElementTest {
    @Test
    fun example() {
        assertEquals(2, Solution().firstUniqueEven(intArrayOf(3, 4, 2, 4, 3)))
    }

    @Test
    fun skipsRepeatedEven() {
        assertEquals(4, Solution().firstUniqueEven(intArrayOf(1, 2, 2, 3, 4)))
    }

    @Test
    fun noEvenElement() {
        assertEquals(-1, Solution().firstUniqueEven(intArrayOf(1, 3, 5)))
    }

    @Test
    fun singleEven() {
        assertEquals(2, Solution().firstUniqueEven(intArrayOf(2)))
    }

    @Test
    fun zeroIsEven() {
        assertEquals(2, Solution().firstUniqueEven(intArrayOf(0, 0, 2)))
    }
}
