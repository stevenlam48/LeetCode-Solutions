package uniquemiddleelement

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniqueMiddleElementTest {
    @Test
    fun uniqueMiddleValue() {
        assertTrue(Solution().isMiddleElementUnique(intArrayOf(1, 4, 3, 2, 4)))
    }

    @Test
    fun repeatedMiddleValue() {
        assertFalse(Solution().isMiddleElementUnique(intArrayOf(1, 2, 3, 3, 4)))
    }

    @Test
    fun evenLengthWithRepeatedMiddleValue() {
        assertFalse(Solution().isMiddleElementUnique(intArrayOf(5, 6, 5, 7)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().isMiddleElementUnique(intArrayOf(42)))
    }
}
