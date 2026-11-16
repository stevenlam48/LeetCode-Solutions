package countitemsmatchingarule

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountItemsMatchingARuleTest {
    private val solution = Solution()

    @Test
    fun matchesColorInFirstExample() {
        val items = listOf(
            listOf("phone", "blue", "pixel"),
            listOf("computer", "silver", "lenovo"),
            listOf("phone", "gold", "iphone")
        )
        assertEquals(1, solution.countMatches(items, "color", "silver"))
    }

    @Test
    fun matchesTypeInSecondExample() {
        val items = listOf(
            listOf("phone", "blue", "pixel"),
            listOf("computer", "silver", "phone"),
            listOf("phone", "gold", "iphone")
        )
        assertEquals(2, solution.countMatches(items, "type", "phone"))
    }

    @Test
    fun returnsZeroWhenNothingMatches() {
        assertEquals(0, solution.countMatches(emptyList(), "name", "anything"))
    }
}
