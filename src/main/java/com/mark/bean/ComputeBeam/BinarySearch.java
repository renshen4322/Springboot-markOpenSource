package com.mark.bean.ComputeBeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName:BinarySearch
 * Package:com.mark.springbootmarkopensource.bean.ComputeBeam
 * Description:
 *
 * @Date:2021/6/5 0005 6:27
 * @Author: mark 二叉查找树
 */
public class BinarySearch {
    public TreeNode2 rootNode;
    public static int count = 1;

    public void Add_Node_To_Tree(int value) {
        if (rootNode == null) {
            rootNode = new TreeNode2(value);
            return;
        }
        TreeNode2 currentNode = rootNode;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left_Node == null) {
                    currentNode.left_Node = new TreeNode2(value);
                    return;
                } else
                    currentNode = currentNode.left_Node;
            } else {
                if (currentNode.right_Node == null) {
                    currentNode.right_Node = new TreeNode2(value);
                    return;
                } else
                    currentNode = currentNode.right_Node;
            }
        }
    }

    public boolean findTree(TreeNode2 node, int value) {
        if (node == null) {
            return false;
        } else if (node.value == value) {
            System.out.printf("共搜索" + count + "次\n");
            return true;
        } else if (value < node.value) {
            count += 1;
            return findTree(node.left_Node, value);
        } else {
            count += 1;
            return findTree(node.right_Node, value);
        }
    }


    public static void main(String[] args) throws IOException {
        int i,value;
        int arr[]= {7,4,1,5,13,8,11,12,15,9,2};
        System.out.printf("原始数组的内容：\n");
        for (i=0;i<11;i++)
            System.out.printf("["+arr[i]+"]");
        System.out.println();
        BinarySearch tree = new BinarySearch();
        for(i=0;i<11;i++)  tree.Add_Node_To_Tree(arr[i]);
        System.out.print("请输入搜索值：");
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        value = Integer.parseInt(keyin.readLine());
        if(tree.findTree(tree.rootNode,value))
            System.out.print("您要找的值【"+value+"】已找到！！\n");
        else
            System.out.print("抱歉，没有找到。\n");
    }
}
