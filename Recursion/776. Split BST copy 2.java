//公式の回答よりも長いけど無骨でわかりやすいやつ
// これでも難しいと思う
class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        List<TreeNode> smalls=new ArrayList();
        List<TreeNode> bigs=new ArrayList();
        split(root,target,smalls,bigs);
        // ここまでで、右に入るものはbigs 左に入るものはsmallsに分けられている
        TreeNode[] res=new TreeNode[2];
        res[0]=parse(smalls); // parseメソッドでは、複数のTreeNodeを結合してる
        res[1]=parse(bigs);
        return res;
    }
    
    private void split(TreeNode root,int target,List<TreeNode> smalls,List<TreeNode> bigs){
        if(root==null){
            return;
        }
        if(root.val<=target){ // targetが根本より大きい→右側二スプリットが起きる
            smalls.add(root); // 根本はsmallに入る
            TreeNode right=root.right; //rightにスプリットが入るので
            root.right=null; //rightにスプリットが入るので
            split(right,target,smalls,bigs); //rightにスプリットが入るので
        }else{
            bigs.add(root); //左側にスプリットが起きるので、rootはbigsに
            TreeNode left=root.left;
            root.left=null;
            split(left,target,smalls,bigs);
        }
    }
    
    private TreeNode parse(List<TreeNode> list){
        if(list.isEmpty()){
            return null;
        }
        TreeNode root=list.get(0);
        for(int i=1;i<list.size();i++){
            TreeNode node=list.get(i);
            combine(root,node);
        }
        return root;
    }
    
    private void combine(TreeNode root,TreeNode node){
        if(node.val>root.val){ 
            //  大小比較して結合処理してく  (読めばわかるから説明省略)
            if(root.right==null){
                root.right=node;
            }else{
                combine(root.right,node);
            }
        }else {
            if(root.left==null){
                root.left=node;
            }else{
                combine(root.left,node);
            }
        }
    }
}