package choosenumbersfromtwoarraysinrange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ChooseNumbersFromTwoArraysInRangeTest {
    private val solution = Solution()

    @Test
    fun singleElementWithoutZeroSum() {
        assertEquals(0, solution.countSubranges(intArrayOf(1), intArrayOf(2)))
    }

    @Test
    fun equalPositiveElementsDoNotProduceZeroSum() {
        assertEquals(0, solution.countSubranges(intArrayOf(3), intArrayOf(3)))
    }

    @Test
    fun zeroSumAcrossAdjacentElements() {
        assertEquals(
            1,
            solution.countSubranges(intArrayOf(1, 1), intArrayOf(1, 2))
        )
    }

    @Test
    fun zeroChoicesExtendExistingSubranges() {
        assertEquals(
            8,
            solution.countSubranges(intArrayOf(0, 0), intArrayOf(0, 0))
        )
    }
}
