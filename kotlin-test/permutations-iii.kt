package permutationsiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PermutationsIiiTest {
    @Test
    fun singleNumber() {
        assertEquals(listOf(listOf(1)), Solution().permute(1))
    }

    @Test
    fun twoNumbers() {
        assertEquals(listOf(listOf(1, 2), listOf(2, 1)), Solution().permute(2))
    }

    @Test
    fun threeNumbers() {
        assertEquals(
            listOf(listOf(1, 2, 3), listOf(3, 2, 1)),
            Solution().permute(3)
        )
    }

    @Test
    fun zeroNumbers() {
        assertEquals(listOf(emptyList<Int>()), Solution().permute(0))
    }
}
