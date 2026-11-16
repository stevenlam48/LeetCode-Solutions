package removingminimumnumberofmagicbeans

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovingMinimumNumberOfMagicBeansTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(4L, solution.minimumRemoval(intArrayOf(4, 1, 6, 5)))
    }

    @Test
    fun secondExample() {
        assertEquals(7L, solution.minimumRemoval(intArrayOf(2, 10, 3, 2)))
    }

    @Test
    fun singleBagNeedsNoRemoval() {
        assertEquals(0L, solution.minimumRemoval(intArrayOf(1)))
    }

    @Test
    fun equalBagSizesNeedNoRemoval() {
        assertEquals(0L, solution.minimumRemoval(intArrayOf(5, 5, 5)))
    }
}
