package designafilesharingsystem

import java.util.PriorityQueue

// Time:  ctor:    O(1)
//        join:    O(logu + c), u is the number of total joined users
//        leave:   O(logu + c), c is the number of chunks
//        request: O(u)
// Space: O(u * c)

class FileSharing(m: Int) {
    private val users = mutableListOf<MutableSet<Int>>()
    private val lookup = HashSet<Int>()
    private val minHeap = PriorityQueue<Int>()

    fun join(ownedChunks: List<Int>): Int {
        var userID = users.size + 1
        if (minHeap.isNotEmpty()) {
            userID = minHeap.poll()
        } else {
            users.add(mutableSetOf())
        }
        for (chunk in ownedChunks) {
            users[userID - 1].add(chunk)
        }
        lookup.add(userID)
        return userID
    }

    fun leave(userID: Int) {
        if (!lookup.contains(userID)) {
            return
        }
        lookup.remove(userID)
        users[userID - 1].clear()
        minHeap.add(userID)
    }

    fun request(userID: Int, chunkID: Int): List<Int> {
        val result = mutableListOf<Int>()
        for (i in users.indices) {
            if (users[i].contains(chunkID)) {
                result.add(i + 1)
            }
        }
        if (result.isNotEmpty()) {
            users[userID - 1].add(chunkID)
        }
        return result
    }
}
