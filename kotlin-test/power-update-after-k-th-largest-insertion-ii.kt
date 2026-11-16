package powerupdateafterkthlargestinsertionii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PowerUpdateAfterKthLargestInsertionIITest {
    @Test
    fun example() {
        val nums = intArrayOf(1, 2)
        val queries = arrayOf(intArrayOf(3, 1), intArrayOf(4, 2))
        assertArrayEquals(intArrayOf(8, 512), Solution().powerUpdate(nums, 2, queries))
    }

    @Test
    fun duplicates() {
        val nums = intArrayOf(5, 5)
        val queries = arrayOf(intArrayOf(5, 1))
        assertArrayEquals(intArrayOf(243), Solution().powerUpdate(nums, 3, queries))
    }

    @Test
    fun kEqualsSize() {
        val nums = intArrayOf(1, 2, 3)
        val queries = arrayOf(intArrayOf(0, 4))
        assertArrayEquals(intArrayOf(1), Solution().powerUpdate(nums, 2, queries))
    }

    @Test
    fun moduloExponent() {
        val nums = intArrayOf(30)
        val queries = arrayOf(intArrayOf(30, 1))
        assertArrayEquals(intArrayOf(73741817), Solution().powerUpdate(nums, 2, queries))
    }

    @Test
    fun baseOne() {
        val nums = intArrayOf(7)
        val queries = arrayOf(intArrayOf(9, 1), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(1, 1), Solution().powerUpdate(nums, 1, queries))
    }
}
