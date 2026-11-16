package minimumincreasetomaximizespecialindices
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIncreaseToMaximizeSpecialIndicesTest {
    @Test
    fun oddLengthExample() {
        assertEquals(4L, Solution().minIncrease(intArrayOf(1, 2, 3, 2, 1)))
    }

    @Test
    fun evenLengthRequiresIncrease() {
        assertEquals(1L, Solution().minIncrease(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun alternatingPeaksNeedNoIncrease() {
        assertEquals(0L, Solution().minIncrease(intArrayOf(1, 2, 1, 2, 1, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, Solution().minIncrease(intArrayOf(7)))
    }

    @Test
    fun twoElements() {
        assertEquals(0L, Solution().minIncrease(intArrayOf(1, 1)))
    }
}
