package categorizeboxaccordingtocriteria

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CategorizeBoxAccordingToCriteriaTest {
    private val solution = Solution()

    @Test
    fun bothCategories() {
        assertEquals("Both", solution.categorizeBox(10_000, 35, 700, 300))
    }

    @Test
    fun bulkyByDimension() {
        assertEquals("Bulky", solution.categorizeBox(10_000, 1, 1, 1))
    }

    @Test
    fun heavyOnly() {
        assertEquals("Heavy", solution.categorizeBox(999, 999, 1, 100))
    }

    @Test
    fun volumeProductUsesLong() {
        assertEquals("Bulky", solution.categorizeBox(50_000, 50_000, 50_000, 1))
        assertEquals("Neither", solution.categorizeBox(290, 200, 50, 10))
    }
}
