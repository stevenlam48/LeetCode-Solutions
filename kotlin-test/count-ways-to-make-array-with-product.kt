package countwaystomakearraywithproduct

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountWaysToMakeArrayWithProductTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(4, 1, 3),
            Solution().waysToFillArray(
                arrayOf(intArrayOf(2, 6), intArrayOf(5, 1), intArrayOf(3, 2))
            )
        )
    }

    @Test
    fun kEqualOne() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().waysToFillArray(arrayOf(intArrayOf(1, 1)))
        )
    }

    @Test
    fun compositeProduct() {
        assertArrayEquals(
            intArrayOf(15, 20),
            Solution().waysToFillArray(arrayOf(intArrayOf(5, 4), intArrayOf(4, 8)))
        )
    }

    @Test
    fun primeProduct() {
        assertArrayEquals(
            intArrayOf(3),
            Solution().waysToFillArray(arrayOf(intArrayOf(3, 2)))
        )
    }

    @Test
    fun distinctPrimeFactors() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().waysToFillArray(arrayOf(intArrayOf(1, 10)))
        )
    }
}
