class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] nums) {
        n = nums.length;
        tree = new int[n * 4];
        build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int treeIndex, int lo, int hi) {
        if (lo == hi) {
            tree[treeIndex] = nums[lo];
            return;
        }
        int mid = (lo + hi) / 2;
        build(nums, 2 * treeIndex + 1, lo, mid);
        build(nums, 2 * treeIndex + 2, mid + 1, hi);
        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public void update(int i, int val) {
        update(0, 0, n - 1, i, val);
    }

    private void update(int treeIndex, int lo, int hi, int i, int val) {
        if (lo == hi) {
            tree[treeIndex] = val;
            return;
        }
        int mid = (lo + hi) / 2;
        if (i <= mid)
            update(2 * treeIndex + 1, lo, mid, i, val);
        else
            update(2 * treeIndex + 2, mid + 1, hi, i, val);
        tree[treeIndex] = Math.max(tree[2 * treeIndex + 1], tree[2 * treeIndex + 2]);
    }

    public int queryFirst(int target) {
        return queryFirst(0, 0, n - 1, target);
    }

    private int queryFirst(int treeIndex, int lo, int hi, int target) {
        if (tree[treeIndex] < target)
            return -1;
        if (lo == hi) {
            update(lo, -1); 
            return lo;
        }
        int mid = (lo + hi) / 2;
        int leftChild = tree[2 * treeIndex + 1];
        if (leftChild >= target)
            return queryFirst(2 * treeIndex + 1, lo, mid, target);
        else
            return queryFirst(2 * treeIndex + 2, mid + 1, hi, target);
    }
}

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        SegmentTree tree = new SegmentTree(baskets);

        for (int fruit : fruits) {
            if (tree.queryFirst(fruit) == -1)
                unplaced++;
        }

        return unplaced;
    }
}
