package replaceelementswithgreatestelementonrightside

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReplaceElementsWithGreatestElementOnRightSideTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertArrayEquals(
            intArrayOf(18, 6, 6, 6, 1, -1),
            solution.replaceElements(intArrayOf(17, 18, 5, 4, 6, 1))
        )
    }

    @Test
    fun singleElementBecomesMinusOne() {
        assertArrayEquals(intArrayOf(-1), solution.replaceElements(intArrayOf(400)))
    }

    @Test
    fun strictlyDecreasingArrayUsesImmediateNeighbor() {
        assertArrayEquals(
            intArrayOf(4, 3, 2, 1, -1),
            solution.replaceElements(intArrayOf(5, 4, 3, 2, 1))
        )
    }

    @Test
    fun negativeValuesFollowReferenceInitialization() {
        assertArrayEquals(
            intArrayOf(-1, -1, -1),
            solution.replaceElements(intArrayOf(-1, -2, -3))
        )
    }
}
