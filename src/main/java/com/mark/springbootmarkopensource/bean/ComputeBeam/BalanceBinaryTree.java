package com.mark.springbootmarkopensource.bean.ComputeBeam;

/**
 * ClassName:BalanceBinaryTree
 * Package:com.mark.springbootmarkopensource.bean.ComputeBeam
 * Description:
 *
 * @Date:2019/4/9 0009 23:12
 * @Author: mark
 */
public class BalanceBinaryTree {
    private final int LL = 1;
    private final int RR = 2;
    private final int LR = 3;
    private final int RL = 4;
    private TreeNode RootNode;

    public void insert(int value) {
        int choice = 0;
        TreeNode A = RootNode;
        TreeNode B = null;
        TreeNode C = null;
        TreeNode Father_A = null;
        TreeNode HelpNode = null;
        TreeNode CurrentNode = RootNode;

        //创建要插入的节点
        TreeNode node = new TreeNode(value, 0);
        //如果一开始根节点为空，直接将当前值设置为根节点
        if(RootNode == null) {
            RootNode = node;
            return;
        }
        //找到要插入的节点，并且找到最可能失去平衡点的节点A，Father_A为A的父节点
        while (CurrentNode != null) {
            if(CurrentNode.bf !=0 ) {
                A = CurrentNode;
                Father_A = HelpNode;
            }
            HelpNode = CurrentNode;
            if(CurrentNode.value < value) {
                CurrentNode = CurrentNode.right_node;
            }
            else {
                CurrentNode = CurrentNode.left_node;
            }
        }

        //插入目标节点
        if(HelpNode.value < value) {
            HelpNode.right_node = node;
        }
        else {
            HelpNode.left_node = node;
        }

        //确定B节点，并修改A的平衡因子bf
        if(value < A.value) {
            B = A.left_node;
            A.bf = A.bf + 1;
        } else {
            B = A.right_node;
            A.bf = A.bf - 1;
        }

        //修改其它节点的平衡因子bf
        CurrentNode = B;
        while (CurrentNode != node) {
            if(value < CurrentNode.value) {
                CurrentNode.bf = 1;
                CurrentNode = CurrentNode.left_node;
            } else {
                CurrentNode.bf = -1;
                CurrentNode = CurrentNode.right_node;
            }
        }

        if(A.bf == 2 && B.bf == 1) {
            choice = LL;
        }
        else if(A.bf == -2 && B.bf == -1) {
            choice = RR;
        }
        else if(A.bf == 2 && B.bf == -1) {
            choice = LR;
        }
        else if(A.bf == -2 && B.bf == 1) {
            choice = RL;
        }
        else {
            choice = 0;
        }

        switch (choice) {
            case LL:
                B = A.left_node;
                A.left_node = B.right_node;
                B.right_node = A;
                A.bf = B.bf = 0;
                if(Father_A == null) {
                    RootNode = B;
                }
                else if (A == Father_A.left_node) {
                    Father_A.left_node = B;
                }
                else {
                    Father_A.left_node = B;
                }
                break;
            case LR:
                B = A.left_node;
                C = B.right_node;
                B.right_node = C.left_node;
                A.left_node = C.right_node;
                C.left_node = B;
                C.right_node = A;
                if(node.value < C.value) {
                    A.bf = -1;
                    B.bf = 0;
                    C.bf = 0;
                }
                else if(node.value > C.value) {
                    A.bf = 0;
                    B.bf = 1;
                    C.bf = 0;
                }
                else {
                    A.bf = 0;
                    B.bf = 0;
                }
                if(Father_A == null) RootNode = C;
                else if(A == Father_A.left_node) {
                    Father_A.left_node = C;
                }
                else {
                    Father_A.right_node = C;
                }
                break;
            case RL:
                B = A.right_node;
                C = B.left_node;
                B.left_node = C.right_node;
                A.right_node = C.left_node;
                C.left_node = A;
                C.right_node = B;
                if(node.value < C.value) {
                    A.bf = 0;
                    B.bf = -1;
                    C.bf = 0;
                }
                else if(node.value > C.value) {
                    A.bf = 1;
                    B.bf = 0;
                    C.bf = 0;
                }
                else {
                    A.bf = 0;
                    B.bf = 0;
                }
                if(Father_A == null) RootNode = C;
                else if(A == Father_A.left_node) {
                    Father_A.left_node = C;
                }
                else {
                    Father_A.right_node = C;
                }
                break;
            case RR:
                B = A.right_node;
                A.right_node = B.left_node;
                B.left_node = A;
                A.bf = B.bf = 0;
                if(Father_A == null) RootNode = B;
                else if(A==Father_A.left_node) {
                    Father_A.left_node = B;
                }
                else {
                    Father_A.right_node = B;
                }
                break;
            default:
                System.out.println("插入一个节点时没有破坏原有的平衡状态");
                break;
        }

        return ;
    }

    private void FirstOrder(TreeNode node) {
        if(node != null) {
            System.out.print(node.value + " ");
            FirstOrder(node.left_node);
            FirstOrder(node.right_node);
        }
    }

    private void InOrder(TreeNode node) {
        if(node != null) {
            FirstOrder(node.left_node);
            System.out.print(node.value + " ");
            FirstOrder(node.right_node);
        }
    }

    private void PostOrder(TreeNode node) {
        if(node != null) {
            PostOrder(node.right_node);
            System.out.print(node.value + " ");
            PostOrder(node.left_node);
        }
    }

    //搜索节点
    private TreeNode Search(TreeNode rootNode, int value) {
        while (rootNode != null) {
            if(rootNode.value == value) {
                return rootNode;
            }
            else if(rootNode.value > value) {
                rootNode = rootNode.left_node;
            }
            else {
                rootNode = rootNode.right_node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BalanceBinaryTree balanceBinaryTree = new BalanceBinaryTree();
        balanceBinaryTree.insert(20);
        balanceBinaryTree.insert(30);
        balanceBinaryTree.insert(25);
        balanceBinaryTree.insert(40);
        balanceBinaryTree.insert(60);
        System.out.print("先序遍历：");
        balanceBinaryTree.FirstOrder(balanceBinaryTree.RootNode);
        System.out.println();
        System.out.print("中序遍历：");
        balanceBinaryTree.InOrder(balanceBinaryTree.RootNode);
        System.out.println();
        System.out.print("后序遍历：");
        balanceBinaryTree.PostOrder(balanceBinaryTree.RootNode);
        System.out.println();
    }



}
