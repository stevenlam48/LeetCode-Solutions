package killprocess

// Time:  O(n)
// Space: O(n)

class Solution {
    fun killProcess(pid: IntArray, ppid: IntArray, kill: Int): List<Int> {
        val result = ArrayList<Int>()
        val children = HashMap<Int, HashSet<Int>>()
        for (i in pid.indices) {
            children.getOrPut(ppid[i]) { HashSet() }.add(pid[i])
        }
        killAll(kill, children, result)
        return result
    }

    private fun killAll(pid: Int, children: HashMap<Int, HashSet<Int>>, killed: MutableList<Int>) {
        killed.add(pid)
        for (child in children[pid] ?: emptySet()) {
            killAll(child, children, killed)
        }
    }
}
