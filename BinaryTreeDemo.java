package TreeBinaryTree01;


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTreeDemo {


    //对称二叉树
    //判断一棵树是否对称，可以看看左右子树是否是镜像关系
    public boolean isSymmetry (TreeNode root){
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        //1.如果t1 t2为空则算镜像
        if(t1 == null && t2 == null){
            return true;
        }
        //2.如果两个树，一个空一个非空则返回false
        if(t1 == null || t2 == null){
            return false;
        }
        //3.两个都非空
        //a）比较根结点是否相同
        //b）递归比较子树，t1.left和t2.right;t1.right和t2.letf
        if(t1.val != t2.val){
            return false;
        }
        return isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    //求一个二叉树的镜像:遍历+交换每个结点的左右子树
    public TreeNode makeMirror(TreeNode root){
        if(root == null){
            return null;
        }
        //交换就是此处的“访问”操作
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        makeMirror(root.left);
        makeMirror(root.right);
        return root;
    }

    //给定两个树，找最近公共祖先
    //最关键的点：从最近公共祖先开始去找两个结点，一定都能找到，但一定不在同一个子树中
   private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
    private boolean findNode(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return false;
        }
        int left = findNode(root.left,p,q)?1:0;
        int right = findNode(root.right,p,q)?1:0;
        int mid = (root == p || root == q)?1:0;
        if(left + right + mid >= 2){
            lca = root;
        }
        return (left + right + mid)>0;
    }
    //二叉搜索树转换为排序双向链表
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while(pRootOfTree.left != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        if(left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null?pRootOfTree:left;
    }
    //根据一棵树的先序遍历和中序遍历构建二叉树
    private int index = 0;
    public TreeNode buildTree01(int[] preorder,int[] inorder){
        index = 0;
        return buildTreeHelper(preorder,inorder,0,inorder.length);
    }
    private TreeNode buildTreeHelper(int[] preorder,int[] inorder,int inorderLeft,int inorderRight){
        //先处理非法情况
        if(inorderLeft >= inorderRight){
            return null;
        }
        if(index >= preorder.length){
            return null;
        }
        //取出当前值，构造当前子树的根节点
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        //需要找到这个结点在中序遍历处的位置
        int pos = find(inorder,inorderLeft,inorderRight,root.val);
        root.left = buildTreeHelper(preorder,inorder,inorderLeft,pos);
        root.right = buildTreeHelper(preorder,inorder,pos+1,inorderRight);
        return root;
    }
    private int find(int[] inorder,int inorderLeft,int inorderRight,int val){
        for(int i = inorderLeft;i < inorderRight;i++){
            if(inorder[i] == val){
                return i;
            }
            return -1;
        }
    }
    //二叉树创建字符串
    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2Str(TreeNode t){
        if(t == null){
            return "";
        tree2StrHelper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
    private void tree2StrHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(root.val);
        tree2StrHelper(root.left);
        if(root.left == null && root.right != null){
            stringBuilder.append("()");
        }
        tree2StrHelper(root.right);
        stringBuilder.append(")");
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = 0;
        return buildTreeHelp(inorder,postorder,0,inorder.length);
    }
    private TreeNode buildTreeHelp(int[] inorder,int[] postorder,int inorderLeft,int inorderRight){
        if(inorderLeft >= inorderRight){
            return null;
        }
        if(index >= postorder.length){
            return null;
        }
        root.left
    }
}
