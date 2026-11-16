package lexicographicallysmallestnegatedpermutationthatsumstotarget

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestNegatedPermutationThatSumsToTargetTest {
    @Test
    fun threeZero() {
        assertArrayEquals(intArrayOf(-3, 1, 2), Solution().lexSmallestNegatedPerm(3, 0L))
    }

    @Test
    fun twoOne() {
        assertArrayEquals(intArrayOf(-1, 2), Solution().lexSmallestNegatedPerm(2, 1L))
    }

    @Test
    fun twoZeroImpossible() {
        assertArrayEquals(IntArray(0), Solution().lexSmallestNegatedPerm(2, 0L))
    }

    @Test
    fun oneNegative() {
        assertArrayEquals(intArrayOf(-1), Solution().lexSmallestNegatedPerm(1, -1L))
    }

    @Test
    fun fourZero() {
        assertArrayEquals(intArrayOf(-4, -1, 2, 3), Solution().lexSmallestNegatedPerm(4, 0L))
    }
}
