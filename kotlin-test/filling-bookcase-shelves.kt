package fillingbookcaseshelves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FillingBookcaseShelvesTest {
    @Test
    fun placesBooksAcrossThreeShelves() {
        val books = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 3),
            intArrayOf(2, 3),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 2)
        )
        assertEquals(6, Solution().minHeightShelves(books, 4))
    }

    @Test
    fun putsEachBookOnItsOwnShelfWhenNeeded() {
        val books = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(3, 2)
        )
        assertEquals(4, Solution().minHeightShelves(books, 6))
    }

    @Test
    fun sharesShelvesWithoutChangingBookOrder() {
        val books = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 4),
            intArrayOf(2, 3)
        )
        assertEquals(6, Solution().minHeightShelves(books, 4))
    }

    @Test
    fun handlesSingleBookAndEmptyInput() {
        assertEquals(5, Solution().minHeightShelves(arrayOf(intArrayOf(2, 5)), 2))
        assertEquals(0, Solution().minHeightShelves(emptyArray(), 2))
    }
}
