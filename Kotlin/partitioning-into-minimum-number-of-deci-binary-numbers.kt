package partitioningintominimumnumberofdecibinarynumbers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minPartitions(n: String): Int = n.max() - '0'
}
