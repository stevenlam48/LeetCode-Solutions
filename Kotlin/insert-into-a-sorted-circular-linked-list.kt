package insertintoasortedcircularlinkedlist
// Time:  O(n)
// Space: O(1)

class Node(var `val`: Int, var next: Node? = null)

class Solution {
    fun insert(head: Node?, insertVal: Int): Node {
        if (head == null) {
            val node = Node(insertVal)
            node.next = node
            return node
        }
        var current: Node = head
        while (true) {
            val next = current.next!!
            if (current.`val` < next.`val`) {
                if (current.`val` <= insertVal && insertVal <= next.`val`) {
                    insertAfter(current, insertVal)
                    break
                }
            } else if (current.`val` > next.`val`) {
                if (current.`val` <= insertVal || insertVal <= next.`val`) {
                    insertAfter(current, insertVal)
                    break
                }
            } else if (next === head) {
                insertAfter(current, insertVal)
                break
            }
            current = next
        }
        return head
    }

    private fun insertAfter(node: Node, `val`: Int) {
        node.next = Node(`val`, node.next)
    }
}
