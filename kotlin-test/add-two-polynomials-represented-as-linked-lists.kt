package addtwopolynomialsrepresentedaslinkedlists

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class AddTwoPolynomialsRepresentedAsLinkedListsTest {
    private val solution = Solution()

    @Test
    fun differentPowers() {
        val result = solution.addPoly(polyOf(1 to 2, 3 to 1), polyOf(2 to 3, 4 to 0))
        assertEquals(listOf(2 to 3, 1 to 2, 3 to 1, 4 to 0), toTerms(result))
    }

    @Test
    fun combineEqualPowers() {
        val result = solution.addPoly(polyOf(1 to 1), polyOf(1 to 1))
        assertEquals(listOf(2 to 1), toTerms(result))
    }

    @Test
    fun cancellationRemovesTerm() {
        val result = solution.addPoly(polyOf(3 to 2, 2 to 1), polyOf(-3 to 2, 4 to 0))
        assertEquals(listOf(2 to 1, 4 to 0), toTerms(result))
    }

    @Test
    fun allTermsCancel() {
        assertNull(solution.addPoly(polyOf(1 to 2, -1 to 0), polyOf(-1 to 2, 1 to 0)))
    }

    @Test
    fun emptyPolynomials() {
        assertNull(solution.addPoly(null, null))
    }
}

private fun polyOf(vararg terms: Pair<Int, Int>): PolyNode? {
    val dummy = PolyNode(0, 0)
    var tail = dummy
    for ((coefficient, power) in terms) {
        tail.next = PolyNode(coefficient, power)
        tail = tail.next!!
    }
    return dummy.next
}

private fun toTerms(head: PolyNode?): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()
    var node = head
    while (node != null) {
        result.add(node.coefficient to node.power)
        node = node.next
    }
    return result
}
