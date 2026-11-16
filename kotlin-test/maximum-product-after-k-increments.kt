package maximumproductafterkincrements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductAfterKIncrementsTest {
    @Test
    fun example1() {
        assertEquals(20, Solution().maximumProduct(intArrayOf(0, 4), 5))
    }

    @Test
    fun example2() {
        assertEquals(162, Solution().maximumProduct(intArrayOf(6, 3, 3, 2), 1))
    }

    @Test
    fun singleElement() {
        assertEquals(11, Solution().maximumProduct(intArrayOf(1), 10))
    }

    @Test
    fun equalElements() {
        assertEquals(27, Solution().maximumProduct(intArrayOf(2, 2, 2), 3))
    }

    @Test
    fun zeroIncrements() {
        assertEquals(6, Solution().maximumProduct(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun largeK() {
        assertEquals(40460, Solution().maximumProduct(intArrayOf(1, 1, 1), 100))
    }
}
