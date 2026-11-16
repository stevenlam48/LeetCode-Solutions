package thetwosneakynumbersofdigitville

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TheTwoSneakyNumbersOfDigitvilleTest {

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(0, 1), Solution().getSneakyNumbers(intArrayOf(0, 1, 1, 0)).sortedArray())
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(2, 3), Solution().getSneakyNumbers(intArrayOf(0, 3, 2, 1, 3, 2)).sortedArray())
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(4, 5),
            Solution().getSneakyNumbers(intArrayOf(7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2)).sortedArray()
        )
    }

    @Test
    fun testSmallest() {
        assertArrayEquals(intArrayOf(0, 1), Solution().getSneakyNumbers(intArrayOf(0, 0, 1, 1)).sortedArray())
    }

    @Test
    fun testLargerValues() {
        assertArrayEquals(
            intArrayOf(8, 9),
            Solution().getSneakyNumbers(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 9)).sortedArray()
        )
    }
}
