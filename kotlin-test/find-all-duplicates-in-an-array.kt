package findallduplicatesinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllDuplicatesInAnArrayTest {
    @Test
    fun example1() {
        assertEquals(listOf(2, 3), Solution().findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
    }

    @Test
    fun example2() {
        assertEquals(listOf(1), Solution().findDuplicates(intArrayOf(1, 1, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(emptyList<Int>(), Solution().findDuplicates(intArrayOf(1)))
    }

    @Test
    fun allDistinct() {
        assertEquals(emptyList<Int>(), Solution().findDuplicates(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun pairOfDuplicates() {
        assertEquals(listOf(2), Solution().findDuplicates(intArrayOf(2, 2)))
    }
}
