package kidswiththegreatestnumberofcandies

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KidsWithTheGreatestNumberOfCandiesTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(
            listOf(true, true, true, false, true),
            solution.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf(true, false, false, false, false),
            solution.kidsWithCandies(intArrayOf(4, 2, 1, 1, 2), 1)
        )
    }

    @Test
    fun tiesForMaximum() {
        assertEquals(
            listOf(true, false, true),
            solution.kidsWithCandies(intArrayOf(12, 1, 12), 10)
        )
    }

    @Test
    fun singleKid() {
        assertEquals(listOf(true), solution.kidsWithCandies(intArrayOf(1), 0))
    }

    @Test
    fun noExtraCandies() {
        assertEquals(
            listOf(true, false, false),
            solution.kidsWithCandies(intArrayOf(5, 1, 2), 0)
        )
    }
}
