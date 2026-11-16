package selfdividingnumbers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SelfDividingNumbersTest {
    @Test
    fun exampleOneToTwentyTwo() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22),
            Solution().selfDividingNumbers(1, 22),
        )
    }

    @Test
    fun exampleFortySevenToEightyFive() {
        assertArrayEquals(intArrayOf(48, 55, 66, 77), Solution().selfDividingNumbers(47, 85))
    }

    @Test
    fun singleValueDividesItself() {
        assertArrayEquals(intArrayOf(1), Solution().selfDividingNumbers(1, 1))
    }

    @Test
    fun valueContainingZeroIsExcluded() {
        assertArrayEquals(intArrayOf(), Solution().selfDividingNumbers(10, 10))
    }

    @Test
    fun rangeWithoutCandidates() {
        assertArrayEquals(intArrayOf(), Solution().selfDividingNumbers(13, 13))
    }
}
