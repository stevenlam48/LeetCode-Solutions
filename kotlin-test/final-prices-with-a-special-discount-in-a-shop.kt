package finalpriceswithaspecialdiscountinashop

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FinalPricesWithASpecialDiscountInAShopTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(4, 2, 4, 2, 3),
            Solution().finalPrices(intArrayOf(8, 4, 6, 2, 3))
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5),
            Solution().finalPrices(intArrayOf(1, 2, 3, 4, 5))
        )
    }

    @Test
    fun example3() {
        assertArrayEquals(
            intArrayOf(9, 0, 1, 6),
            Solution().finalPrices(intArrayOf(10, 1, 1, 6))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(5), Solution().finalPrices(intArrayOf(5)))
    }

    @Test
    fun equalPricesDiscountToZero() {
        assertArrayEquals(
            intArrayOf(0, 3, 7),
            Solution().finalPrices(intArrayOf(3, 3, 7))
        )
    }
}
