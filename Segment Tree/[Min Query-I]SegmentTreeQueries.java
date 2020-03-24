package codingblock.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTreeQueries {
    private final int n;
    private final int[] tree;
    private final int[] orignalArray;
    /*
     * false -> min
     * true -> max
     * */
    private boolean type = false;

    public SegmentTreeQueries(int n, int[] arr, boolean type) {
        this.n = n;
        this.type = type;
        tree = new int[4 * n + 1];
        orignalArray = arr;
        buildTree(arr, 0, n - 1, 1);
    }

    // A utility function to get the middle index from corner indexes.
    int getM(int s, int e) {
        return s + (e - s) / 2;
    }

    // A recursive function that constructs Segment Tree for array[start..end].
    // idx is index of current node in segment tree st
    void buildTree(int[] arr, int start, int end, int idx) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (start == end) {
            tree[idx] = arr[start];
            return;
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getM(start, end);
        buildTree(arr, start, mid, idx * 2);
        buildTree(arr, mid + 1, end, idx * 2 + 1);
        if (type)
            tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
        else
            tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
    }

    // Return sum of elements in range from index start (quey start) to
    // end (query end).  It mainly uses getSumUtil()
    int query(int start, int end) {
        // Check for erroneous input values
        if (start < 0 || end > n - 1 || start > end) {
            System.out.println("Invalid Input");
            return -1;
        }
        return queryUtil(0, n - 1, start, end, 1);
    }

    private int queryUtil(int ss, int se, int qs, int qe, int idx) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
            return tree[idx];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return type ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int mid = getM(ss, se);
        if (type)
            return Math.max(
                    queryUtil(ss, mid, qs, qe, 2 * idx),
                    queryUtil(mid + 1, se, qs, qe, 2 * idx + 1)
            );
        else return Math.min(
                queryUtil(ss, mid, qs, qe, 2 * idx),
                queryUtil(mid + 1, se, qs, qe, 2 * idx + 1)
        );
    }

    /* A recursive function to update the nodes which have the given
       index in their range. The following are parameters
        st, idx, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    void updateValueUtil(int ss, int se, int i, int diff, int idx) {
        // Base Case: If the input index lies outside the range of
        // this segment
        if (i < ss || i > se)
            return;

        if (ss == se) {
            tree[idx] += diff;
            return;
        }

        int mid = getM(ss, se);
        updateValueUtil(ss, mid, i, diff, 2 * idx);
        updateValueUtil(mid + 1, se, i, diff, 2 * idx + 1);
        if (type)
            tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
        else
            tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    void updateValue(int idx, int new_val) {
        // Check for erroneous input index
        if (idx < 0 || idx > n - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - orignalArray[idx];

        // Update the value in array
        orignalArray[idx] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, n - 1, idx, diff, 1);
    }

    public int[] getTree() {
        return tree;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SegmentTreeQueries tree = new SegmentTreeQueries(n, arr, false);
        System.out.println(Arrays.toString(tree.getTree()));
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (x == 1) {
                System.out.println(tree.query(sc.nextInt() - 1, sc.nextInt() - 1));
            } else if (x == 2) {
                tree.updateValue(sc.nextInt() - 1, sc.nextInt());
            }

        }
    }

}
