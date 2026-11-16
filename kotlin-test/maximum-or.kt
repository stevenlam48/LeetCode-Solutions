package maximumor

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumOrTest {
    @Test
    fun firstExample() {
        assertEquals(30L, Solution().maximumOr(intArrayOf(12, 9), 1))
    }

    @Test
    fun secondExample() {
        assertEquals(35L, Solution().maximumOr(intArrayOf(8, 1, 2), 2))
    }

    @Test
    fun singleElementUsesLongResult() {
        assertEquals(56L, Solution().maximumOr(intArrayOf(7), 3))
    }

    @Test
    fun zeros() {
        assertEquals(0L, Solution().maximumOr(intArrayOf(0, 0), 2))
    }
}
