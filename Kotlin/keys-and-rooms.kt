package keysandrooms

// Time:  O(n!)
// Space: O(n)

class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val lookup = HashSet<Int>()
        lookup.add(0)
        val stack = ArrayList<Int>()
        stack.add(0)
        while (stack.isNotEmpty()) {
            val node = stack.removeAt(stack.size - 1)
            for (nei in rooms[node]) {
                if (nei !in lookup) {
                    lookup.add(nei)
                    if (lookup.size == rooms.size) {
                        return true
                    }
                    stack.add(nei)
                }
            }
        }
        return lookup.size == rooms.size
    }
}
