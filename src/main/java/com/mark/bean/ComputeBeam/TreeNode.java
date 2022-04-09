package com.mark.bean.ComputeBeam;

/**
 * ClassName:TreeNode
 * Package:com.mark.springbootmarkopensource.bean.ComputeBeam
 * Description:
 *
 * @Date:2019/4/9 0009 23:11
 * @Author: mark
 */
public class TreeNode {
    int value;
    int bf; //平衡因子
    TreeNode left_node;
    TreeNode right_node;
    public TreeNode(int value, int bf) {
        this.bf = bf;
        this.value = value;
        this.left_node = null;
        this.right_node = null;
    }
/*---------------------
    作者：Healist
    来源：CSDN
    原文：https://blog.csdn.net/Healist/article/details/54972093
    版权声明：本文为博主原创文章，转载请附上博文链接！*/
}
