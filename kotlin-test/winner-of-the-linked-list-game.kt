package winnerofthelinkedlistgame

import common.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerOfTheLinkedListGameTest {
    private fun listOf(vararg values: Int): ListNode? {
        val dummy = ListNode(0)
        var tail = dummy
        for (value in values) {
            tail.next = ListNode(value)
            tail = tail.next!!
        }
        return dummy.next
    }

    @Test
    fun evenWins() {
        assertEquals("Even", Solution().gameResult(listOf(2, 1)))
    }

    @Test
    fun oddWins() {
        assertEquals("Odd", Solution().gameResult(listOf(1, 2)))
    }

    @Test
    fun tie() {
        assertEquals("Tie", Solution().gameResult(listOf(2, 1, 1, 2, 3, 3)))
    }

    @Test
    fun multipleRounds() {
        assertEquals("Even", Solution().gameResult(listOf(4, 1, 2, 3, 5, 0)))
    }
}
