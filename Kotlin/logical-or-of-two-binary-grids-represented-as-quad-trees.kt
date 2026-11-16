package logicaloroftwobinarygridsrepresentedasquadtrees

// Time:  O(n)
// Space: O(h)

class Node(
    var `val`: Boolean = false,
    var isLeaf: Boolean = false,
    var topLeft: Node? = null,
    var topRight: Node? = null,
    var bottomLeft: Node? = null,
    var bottomRight: Node? = null
)

class Solution {
    fun intersect(quadTree1: Node, quadTree2: Node): Node {
        if (quadTree1.isLeaf) {
            return if (quadTree1.`val`) quadTree1 else quadTree2
        } else if (quadTree2.isLeaf) {
            return if (quadTree2.`val`) quadTree2 else quadTree1
        }
        val topLeftNode = intersect(quadTree1.topLeft!!, quadTree2.topLeft!!)
        val topRightNode = intersect(quadTree1.topRight!!, quadTree2.topRight!!)
        val bottomLeftNode = intersect(quadTree1.bottomLeft!!, quadTree2.bottomLeft!!)
        val bottomRightNode = intersect(quadTree1.bottomRight!!, quadTree2.bottomRight!!)
        if (topLeftNode.isLeaf && topRightNode.isLeaf &&
            bottomLeftNode.isLeaf && bottomRightNode.isLeaf &&
            topLeftNode.`val` == topRightNode.`val` &&
            topRightNode.`val` == bottomLeftNode.`val` &&
            bottomLeftNode.`val` == bottomRightNode.`val`) {
            return Node(topLeftNode.`val`, true, null, null, null, null)
        }
        return Node(true, false, topLeftNode, topRightNode, bottomLeftNode, bottomRightNode)
    }
}
