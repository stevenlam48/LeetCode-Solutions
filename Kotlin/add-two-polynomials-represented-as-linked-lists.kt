package addtwopolynomialsrepresentedaslinkedlists

// Time:  O(m + n)
// Space: O(1)

class PolyNode(var coefficient: Int, var power: Int) {
    var next: PolyNode? = null
}

class Solution {
    fun addPoly(poly1: PolyNode?, poly2: PolyNode?): PolyNode? {
        val dummy = PolyNode(0, 0)
        var curr = dummy
        var first = poly1
        var second = poly2
        while (first != null && second != null) {
            if (first.power > second.power) {
                curr.next = first
                curr = curr.next!!
                first = first.next
            } else if (first.power < second.power) {
                curr.next = second
                curr = curr.next!!
                second = second.next
            } else {
                val coefficient = first.coefficient + second.coefficient
                if (coefficient != 0) {
                    curr.next = PolyNode(coefficient, first.power)
                    curr = curr.next!!
                }
                first = first.next
                second = second.next
            }
        }
        curr.next = first ?: second
        return dummy.next
    }
}
