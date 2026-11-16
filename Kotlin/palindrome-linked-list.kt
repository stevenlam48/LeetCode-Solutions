package palindromelinkedlist
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var reverse: ListNode? = null
        var current = head
        var fast = current
        while (fast != null && fast.next != null) {
            fast = fast.next?.next
            val headNext = current!!.next
            current.next = reverse
            reverse = current
            current = headNext
        }
        var tail = if (fast != null) current?.next else current
        var isPalindrome = true
        while (reverse != null) {
            isPalindrome = isPalindrome && reverse.`val` == tail!!.`val`
            val reverseNext = reverse.next
            reverse.next = current
            current = reverse
            reverse = reverseNext
            tail = tail!!.next
        }
        return isPalindrome
    }
}
