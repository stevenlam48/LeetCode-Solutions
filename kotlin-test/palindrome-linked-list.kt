package palindromelinkedlist

import common.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeLinkedListTest {
    private val solution = Solution()

    @Test
    fun examples() {
        val head = listOf(1, 2, 2, 1)
        assertTrue(solution.isPalindrome(head))
        assertEquals(intArrayOf(1, 2, 2, 1).toList(), toArray(head).toList())
        assertFalse(solution.isPalindrome(listOf(1, 2)))
    }

    @Test
    fun oddLengthPalindrome() {
        assertTrue(solution.isPalindrome(listOf(1, 2, 3, 2, 1)))
    }

    @Test
    fun emptyAndSingleNode() {
        assertTrue(solution.isPalindrome(null))
        assertTrue(solution.isPalindrome(listOf(7)))
    }

    @Test
    fun oddLengthNonPalindrome() {
        assertFalse(solution.isPalindrome(listOf(1, 2, 3, 4, 1)))
    }
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

private fun toArray(head: ListNode?): IntArray {
    val values = mutableListOf<Int>()
    var current = head
    while (current != null) {
        values.add(current.`val`)
        current = current.next
    }
    return values.toIntArray()
}
