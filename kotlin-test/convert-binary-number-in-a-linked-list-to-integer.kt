package convertbinarynumberinalinkedlisttointeger

import common.ListNode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertBinaryNumberInALinkedListToIntegerTest {
    @Test
    fun binaryOneZeroOne() {
        assertEquals(5, Solution().getDecimalValue(listOf(1, 0, 1)))
    }

    @Test
    fun singleZero() {
        assertEquals(0, Solution().getDecimalValue(listOf(0)))
    }

    @Test
    fun fourOnes() {
        assertEquals(15, Solution().getDecimalValue(listOf(1, 1, 1, 1)))
    }

    @Test
    fun nullHead() {
        assertEquals(0, Solution().getDecimalValue(null))
    }

    private fun listOf(vararg values: Int): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        for (value in values) {
            tail.next = ListNode(value)
            tail = tail.next!!
        }
        return dummy.next
    }
}
