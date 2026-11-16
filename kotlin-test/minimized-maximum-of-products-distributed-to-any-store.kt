package minimizedmaximumofproductsdistributedtoanystore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizedMaximumOfProductsDistributedToAnyStoreTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minimizedMaximum(6, intArrayOf(11, 6)))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().minimizedMaximum(7, intArrayOf(15, 10, 10)))
    }

    @Test
    fun singleStore() {
        assertEquals(100000, Solution().minimizedMaximum(1, intArrayOf(100000)))
    }

    @Test
    fun oneEach() {
        assertEquals(1, Solution().minimizedMaximum(3, intArrayOf(1, 1, 1)))
    }

    @Test
    fun twoStores() {
        assertEquals(1, Solution().minimizedMaximum(4, intArrayOf(2, 2)))
    }
}
