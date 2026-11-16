package findallkdistantindicesinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllKDistantIndicesInAnArrayTest {
    @Test
    fun example1() {
        assertEquals(
            listOf(1, 2, 3, 4, 5, 6),
            Solution().findKDistantIndices(intArrayOf(3, 4, 9, 1, 3, 9, 5), 9, 1)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf(0, 1, 2, 3, 4),
            Solution().findKDistantIndices(intArrayOf(2, 2, 2, 2, 2), 2, 2)
        )
    }

    @Test
    fun example3() {
        assertEquals(
            listOf(2),
            Solution().findKDistantIndices(intArrayOf(1, 2, 3, 4, 5), 3, 0)
        )
    }

    @Test
    fun singleElementMatch() {
        assertEquals(listOf(0), Solution().findKDistantIndices(intArrayOf(1), 1, 5))
    }

    @Test
    fun noKeyPresent() {
        assertEquals(emptyList<Int>(), Solution().findKDistantIndices(intArrayOf(1, 2), 5, 1))
    }
}
