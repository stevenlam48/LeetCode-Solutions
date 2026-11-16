package numberofuniquecategories

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUniqueCategoriesTest {
    private class FakeHandler(private val categories: IntArray) : CategoryHandler {
        override fun haveSameCategory(a: Int, b: Int): Boolean = categories[a] == categories[b]
    }

    @Test
    fun example() {
        assertEquals(3, Solution().numberOfCategories(5, FakeHandler(intArrayOf(0, 0, 1, 1, 2))))
    }

    @Test
    fun allSame() {
        assertEquals(1, Solution().numberOfCategories(4, FakeHandler(intArrayOf(7, 7, 7, 7))))
    }

    @Test
    fun allDistinct() {
        assertEquals(4, Solution().numberOfCategories(4, FakeHandler(intArrayOf(0, 1, 2, 3))))
    }

    @Test
    fun single() {
        assertEquals(1, Solution().numberOfCategories(1, FakeHandler(intArrayOf(0))))
    }
}
