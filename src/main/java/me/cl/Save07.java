package me.cl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Save07 {

    public static class TreeNode {
        TreeNode left, right;
        String val;

        TreeNode(String val) {
            this.val = val;
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        System.out.print(root.val + "#");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeNode> map = new HashMap<>();
        TreeNode treeRoot = null;

        int n = Integer.parseInt(br.readLine());
        for (int l = 0; l < n; l++) {
            String[] info = br.readLine().split(" ");
            TreeNode root;
            if (!map.containsKey(info[0])) {
                root = new TreeNode(info[0]);
                map.put(info[0], root);
            } else {
                root = map.get(info[0]);
            }
            if (treeRoot == null) treeRoot = root; // remember root

            if (!info[1].equals("0")) {
                TreeNode left;
                if (map.containsKey(info[1])) {
                    left = map.get(info[1]);
                } else {
                    left = new TreeNode(info[1]);
                    map.put(info[1], left);
                }
                root.left = left;
            }

            if (!info[2].equals("0")) {
                TreeNode right;
                if (map.containsKey(info[2])) {
                    right = map.get(info[2]);
                } else {
                    right = new TreeNode(info[2]);
                    map.put(info[2], right);
                }
                root.right = right;
            }
        }
        postOrder(treeRoot);
        System.out.println();
    }
}
