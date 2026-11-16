package beautifularrangementii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BeautifulArrangementIiTest {
    private val solution = Solution()

    @Test
    fun oneDifferenceProducesAscendingOrder() {
        assertArrayEquals(intArrayOf(1, 2, 3), solution.constructArray(3, 1))
    }

    @Test
    fun smallAlternatingCase() {
        assertArrayEquals(intArrayOf(3, 1, 2), solution.constructArray(3, 2))
    }

    @Test
    fun maximumDifferenceCount() {
        assertArrayEquals(intArrayOf(5, 1, 4, 2, 3), solution.constructArray(5, 4))
    }

    @Test
    fun alternationEndsAfterRequestedDifferences() {
        assertArrayEquals(intArrayOf(5, 1, 2, 3, 4), solution.constructArray(5, 2))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(1), solution.constructArray(1, 1))
    }
}
