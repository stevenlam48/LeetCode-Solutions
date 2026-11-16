package sumofdigitsofstringafterconvert

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDigitsOfStringAfterConvertTest {
    @Test
    fun exampleOne() {
        assertEquals(36, Solution().getLucky("iiii", 1))
    }

    @Test
    fun exampleTwo() {
        assertEquals(6, Solution().getLucky("leetcode", 2))
    }

    @Test
    fun exampleThree() {
        assertEquals(8, Solution().getLucky("zbax", 2))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().getLucky("a", 1))
    }
}
