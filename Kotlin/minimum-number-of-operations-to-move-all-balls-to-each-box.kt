package minimumnumberofoperationstomoveallballstoeachbox

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(boxes: String): IntArray {
        val result = IntArray(boxes.length)
        var accu = 0
        var cnt = 0
        for (i in boxes.indices) {
            result[i] += accu
            cnt += if (boxes[i] == '1') 1 else 0
            accu += cnt
        }
        accu = 0
        cnt = 0
        for (i in boxes.length - 1 downTo 0) {
            result[i] += accu
            cnt += if (boxes[i] == '1') 1 else 0
            accu += cnt
        }
        return result
    }
}
