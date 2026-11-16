package buildbinaryexpressiontreefrominfixexpression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuildBinaryExpressionTreeFromInfixExpressionTest {
    @Test
    fun multiplicationHasHigherPrecedence() {
        assertEquals("((3*4)-(2*5))", expression(Solution().expTree("3*4-2*5")))
    }

    @Test
    fun parenthesesOverridePrecedence() {
        assertEquals("((2+3)*((4+5)*2))", expression(Solution().expTree("(2+3)*((4+5)*2)")))
    }

    @Test
    fun subtractionIsLeftAssociative() {
        assertEquals("(((1+2)+3)-4)", expression(Solution().expTree("1+2+3-4")))
    }

    @Test
    fun divisionAndAddition() {
        assertEquals("((2-(3/(4+5)))+6)", expression(Solution().expTree("2-3/(4+5)+6")))
    }

    private fun expression(node: Node?): String {
        node ?: return ""
        if (node.left == null && node.right == null) {
            return node.`val`.toString()
        }
        return "(${expression(node.left)}${node.`val`}${expression(node.right)})"
    }
}
