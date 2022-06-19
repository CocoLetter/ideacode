import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "[]";
          StringBuilder res = new StringBuilder("[");
          Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};
        while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                      res.append(node.val+",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else res.append("null,");
        }
          res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] split = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!split[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(split[index]));
                queue.add(node.left);
            }
            index++;
            if (!split[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(split[index]));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }

}
