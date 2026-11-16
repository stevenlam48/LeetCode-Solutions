package throneinheritance
// Time:  ctor:    O(1)
//        birth:   O(1)
//        death:   O(1)
//        inherit: O(n)
// Space: O(n)

class ThroneInheritance(private val kingName: String) {
    private val familyTree = HashMap<String, MutableList<String>>()
    private val dead = HashSet<String>()

    fun birth(parentName: String, childName: String) {
        familyTree.getOrPut(parentName) { mutableListOf() }.add(childName)
    }

    fun death(name: String) {
        dead.add(name)
    }

    fun getInheritanceOrder(): List<String> {
        val result = mutableListOf<String>()
        val stack = mutableListOf(kingName)
        while (stack.isNotEmpty()) {
            val node = stack.removeAt(stack.lastIndex)
            if (node !in dead) {
                result.add(node)
            }
            val children = familyTree[node] ?: continue
            for (i in children.indices.reversed()) {
                stack.add(children[i])
            }
        }
        return result
    }
}
