package basiccalculatoriv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BasicCalculatorIvTest {
    private val solution = Solution()

    @Test
    fun `substitutes variable in addition`() {
        assertEquals(
            listOf("9"),
            solution.basicCalculatorIV("e + 8", listOf("e"), intArrayOf(1))
        )
    }

    @Test
    fun `combines constants after subtraction`() {
        assertEquals(
            listOf("-2"),
            solution.basicCalculatorIV("e - temperature", listOf("e", "temperature"), intArrayOf(1, 3))
        )
    }

    @Test
    fun `distributes multiplication over parenthesized addition`() {
        assertEquals(
            listOf("9"),
            solution.basicCalculatorIV("(a + b) * c", listOf("a", "b", "c"), intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun `combines like products regardless of factor order`() {
        assertEquals(
            listOf("18"),
            solution.basicCalculatorIV(
                "a * b * c + b * a * c * 2",
                listOf("a", "b", "c"),
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun `evaluates nested polynomial expression`() {
        assertEquals(
            listOf("-1"),
            solution.basicCalculatorIV(
                "((a - b) * (b - c) + (c - a) * (a - b))",
                listOf("a", "b", "c"),
                intArrayOf(1, 2, 3)
            )
        )
    }

    @Test
    fun `sorts remaining symbolic terms by degree then lexically`() {
        assertEquals(
            listOf("1*a*b", "1*b*c", "1*a", "5"),
            solution.basicCalculatorIV("a + b * a + c * b + 5", emptyList(), intArrayOf())
        )
    }
}
