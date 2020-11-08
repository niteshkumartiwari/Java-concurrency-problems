package cp;

public class Driver {
    public static void main(String[] args) {
        Solution sol= new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        System.out.println(sol.distributeCoins(root));
    }
}
