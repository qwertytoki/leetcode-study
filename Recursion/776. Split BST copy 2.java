//公式の回答よりも長いけど無骨でわかりやすいやつ
// これでも難しいと思う
class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {
        List<TreeNode> smalls=new ArrayList();
        List<TreeNode> bigs=new ArrayList();
        split(root,target,smalls,bigs);
        // ここまでで、右に入るものはbigs 左に入るものはsmallsに分けられている。
        // まだTreeになっていない、NodeのListがBig Smallに入っている
        TreeNode[] res=new TreeNode[2];
        res[0]=parse(smalls); // 上記で振り分けたNodeのリストを1つのリストに結合していく
        res[1]=parse(bigs);
        return res;
    }
    
    private void split(TreeNode root,int target,List<TreeNode> smalls,List<TreeNode> bigs){
        if(root==null){
            return;
        }
        if(root.val<=target){ // targetのほうが大きい→もっと右側でスプリットが起きる
            smalls.add(root); // 根本からsmallに入れる
            TreeNode right=root.right; //rightは判断できないのでそのままとっておく(この段階ではどっちにも入れない)
            root.right=null; //smallに入れたrightはnullにして切り取る
            split(right,target,smalls,bigs); //左側はもう用無しなので右について再帰する 
        }else{
            bigs.add(root); //左側にスプリットが起きるので、rootはbigsに
            TreeNode left=root.left;
            root.left=null;
            split(left,target,smalls,bigs); //上記とは逆の現象
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