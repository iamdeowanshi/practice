package com.example.practice;

public class LCA {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ( root == null)
            return null;

        if(root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if (left != null && right != null)
            return root;


        return left != null ? left : right;

    }

    public static void main(String[] args) {
        System.out.println(LCA.powerJump("10000"));
    }
    public static int powerJump(String game) {
        char[] steps = game.toCharArray();

        int minPower = Integer.MIN_VALUE;
        int count = 1;
        char prev = 0;
        char last = steps[steps.length -1];

        for (Character step : steps) {
            if (step == last) {
                prev = step;
                if ( count > minPower)
                    minPower = count;
            } else {
                if (step.equals(prev))
                    count++;
                else
                    count = 2;
                prev = step;

            }
        }

        return minPower == Integer.MIN_VALUE ? 0 : minPower;
    }
}
