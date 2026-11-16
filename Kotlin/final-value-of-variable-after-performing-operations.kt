package finalvalueofvariableafterperformingoperations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        return operations.fold(0) { total, x -> total + if (x[1] == '+') 1 else -1 }
    }
}
