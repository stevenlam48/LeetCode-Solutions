package fairdistributionofcookies

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FairDistributionOfCookiesTest {
    private val solution = Solution()

    @Test
    fun twoChildrenExample() {
        assertEquals(
            31,
            solution.distributeCookies(intArrayOf(8, 15, 10, 20, 8), 2)
        )
    }

    @Test
    fun threeChildrenExample() {
        assertEquals(
            7,
            solution.distributeCookies(intArrayOf(6, 1, 3, 2, 2, 4, 1, 2), 3)
        )
    }

    @Test
    fun oneChildReceivesEveryBag() {
        assertEquals(14, solution.distributeCookies(intArrayOf(4, 7, 3), 1))
    }

    @Test
    fun oneBagPerChildUsesLargestBag() {
        assertEquals(10, solution.distributeCookies(intArrayOf(3, 10, 5), 3))
    }
}
