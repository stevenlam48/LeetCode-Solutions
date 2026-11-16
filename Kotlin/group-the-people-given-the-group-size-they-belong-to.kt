package groupthepeoplegiventhegroupsizetheybelongto

// Time:  O(n)
// Space: O(n)

class Solution {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val groups = HashMap<Int, MutableList<Int>>()
        for (i in groupSizes.indices) {
            val size = groupSizes[i]
            val group = groups.getOrPut(size) { ArrayList() }
            group.add(i)
            if (group.size == size) {
                result.add(group)
                groups[size] = ArrayList()
            }
        }
        return result
    }
}
