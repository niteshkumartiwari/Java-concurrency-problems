package cp;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int moves=0;

    private int postOrder(TreeNode root, int moves){
        if(root == null) return 0;
        int l = postOrder(root.left,moves);
        int r = postOrder(root.right,moves);

        moves+= Math.abs(l)+Math.abs(r);

        return (root.val+l+r-1);
    }

    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;

        postOrder(root,moves);

        return moves;
    }
}