// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We get the pointer to each node by indexing on the preoder list and using Hash map we search for the root in inorder list
//we recursively calculate the left and right subtree of root using start and end indices on inorder list
//Recursion stops or returns null when start and end index cross each other
class Solution {
    int idx = 0; //pointer on preorder
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Hash map to store indorder index
        this.map = new HashMap<>();
        for(int i=0; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        //base
        if (start > end) return null;
        //logic
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        //get the root index
        int rootIdx = map.get(rootVal);
        //recursive call for left subtree
        root.left = helper(preorder, start, rootIdx-1);
        //recursive call for right subtree
        root.right = helper(preorder, rootIdx+1, end);

        return root;


    }
}
