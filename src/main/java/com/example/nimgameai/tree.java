package com.example.nimgameai;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;
public class tree {
  //  public static void generateTree(MNode head) {
  //      if (!head.isLeaf) {
   //         generateChildren(head);
//
   //         for (MNode child : head.Childrens) {
    //            generateTree(child);
     //       }
     //   }
   // }
  static List<Integer> stickCounts;
  static int nimSum =16;
  static version1_6_3_2_5 obj  = new version1_6_3_2_5();
    public static void generateTree(NODE head, int depth) {
        if (!head.isTerminal(head) && depth > 0) {
            generateChildren(head);

            for (NODE child : head.children) {
                generateTree(child, depth - 1);
            }
        }
    }
    public static void generateChildren(NODE head) {
        for(int i=0; i<obj.rows.size(); i++)
            stickCounts.set(i, NODE.sticksNumber(i));
        List<NODE> newChildren = new ArrayList<>();

        int numberOfHeaps = stickCounts.size();

        for (int i = 0; i < obj.rows.size(); i++) {
            int sizeOfSingleHeap = stickCounts.get(i);

            for (int j = 0; j < obj.rows.get(i).size(); j++) {
                List<Integer> tempList = new ArrayList<>(stickCounts);
                tempList.set(i, j);

                //int actualSum = head.ActualSum - (sizeOfSingleHeap - j);
                    boolean isLeaf = NODE.isTerminal(head);

                    //NODE tempMNode = new NODE(nimSum, tempList, isLeaf);
                   // newChildren.add(tempMNode);
                }
            }
        }
        //head.children = newChildren;
    }
