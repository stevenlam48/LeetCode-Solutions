package finding3digitevennumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Finding3DigitEvenNumbersTest {
    @Test
    fun exampleOne() {
        assertEquals(
            listOf(102, 120, 130, 132, 210, 230, 302, 310, 312, 320),
            Solution().findEvenNumbers(intArrayOf(2, 1, 3, 0))
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            listOf(222, 228, 282, 288, 822, 828, 882),
            Solution().findEvenNumbers(intArrayOf(2, 2, 8, 8, 2))
        )
    }

    @Test
    fun noEvenDigit() {
        assertEquals(emptyList<Int>(), Solution().findEvenNumbers(intArrayOf(3, 7, 5)))
    }

    @Test
    fun repeatedZeroDigits() {
        assertEquals(listOf(200), Solution().findEvenNumbers(intArrayOf(0, 0, 2)))
    }
}
