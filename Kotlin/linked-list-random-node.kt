package linkedlistrandomnode

// Time:  ctor:      O(1)
//        getRandom: O(n)
// Space: O(1)

import common.ListNode
import java.util.Random

class Solution(private val head: ListNode?) {
    private val random = Random()

    fun getRandom(): Int {
        var reservoir = -1
        var n = 0
        var curr = head
        while (curr != null) {
            ++n
            if (random.nextInt(n) == 0) {
                reservoir = curr.`val`
            }
            curr = curr.next
        }
        return reservoir
    }
}
