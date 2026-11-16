package kthsmallestnumberinmultiplicationtable

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthSmallestNumberInMultiplicationTableTest {
    @Test
    fun exampleTable() {
        assertEquals(3, Solution().findKthNumber(3, 3, 5))
        assertEquals(9, Solution().findKthNumber(3, 3, 9))
    }

    @Test
    fun rectangularTable() {
        assertEquals(6, Solution().findKthNumber(2, 3, 6))
        assertEquals(2, Solution().findKthNumber(2, 3, 2))
    }

    @Test
    fun singleRowAndColumn() {
        assertEquals(4, Solution().findKthNumber(1, 5, 4))
        assertEquals(4, Solution().findKthNumber(5, 1, 4))
    }
}
