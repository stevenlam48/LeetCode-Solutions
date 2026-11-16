package maximumsplitofpositiveevenintegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSplitOfPositiveEvenIntegersTest {
    @Test
    fun example1() {
        assertEquals(listOf(2L, 4L, 6L), Solution().maximumEvenSplit(12))
    }

    @Test
    fun oddSum() {
        assertEquals(emptyList<Long>(), Solution().maximumEvenSplit(7))
    }

    @Test
    fun two() {
        assertEquals(listOf(2L), Solution().maximumEvenSplit(2))
    }

    @Test
    fun four() {
        assertEquals(listOf(4L), Solution().maximumEvenSplit(4))
    }

    @Test
    fun twentyEight() {
        assertEquals(listOf(2L, 4L, 6L, 16L), Solution().maximumEvenSplit(28))
    }
}
