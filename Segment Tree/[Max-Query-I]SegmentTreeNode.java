package codingblock.SegmentTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SegmentTreeNode {
    long[] originalArr;
    Node root;

    static class Node {
        public long[] sortedArray;
        public int start;
        public int end;
        public Node left;
        public Node right;

        public Node(int s, int e, long[] sortedArray) {
            start = s;
            end = e;
            this.sortedArray = sortedArray;
        }

        public Node(int s, int e) {
            start = s;
            end = e;
        }
    }

    public SegmentTreeNode(long[] nums) {
        originalArr = nums;
        root = buildTree(0, nums.length - 1);
    }

    private Node buildTree(int s, int e) {
        if (s == e) {
            return new Node(s, e, new long[]{originalArr[s]});
        }
        int mid = s + (e - s) / 2;
        Node node = new Node(s, e);
        node.left = buildTree(s, mid);
        node.right = buildTree(mid + 1, e);
        long[] left, right;
        left = node.left.sortedArray;
        right = node.right.sortedArray;
        node.sortedArray = merge(left, right);
        return node;
    }

    public static long[] merge(long[] arr1, long[] arr2) {
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        long[] arr3 = new long[n1 + n2];
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        while (i < n1)
            arr3[k++] = arr1[i++];
        while (j < n2)
            arr3[k++] = arr2[j++];
        return arr3;
    }

    @Override
    public String toString() {
        return bfs(root);
    }

    private String bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Node node = q.poll();
            sb.append(Arrays.toString(node.sortedArray)).append(" ");
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }

        return sb.toString();
    }

    public int query(int start, int end, int k) {
        return queryUtil(root, start, end, k);
    }

    private int queryUtil(Node root, int start, int end, int max) {
        if (root.sortedArray[root.sortedArray.length - 1] < max || root.end < start || root.start > end) {
            return 0;
        }
        if (root.start == root.end) {
            return 1;
        }
        if (start <= root.start && end >= root.end) {
            int idx = lowerBound(root.sortedArray, max);
            return root.sortedArray.length - idx;
        }
        return queryUtil(root.left, start, end, max) +
                queryUtil(root.right, start, end, max);
    }

    public static int lowerBound(long[] array, long value) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SegmentTreeNode tree = new SegmentTreeNode(arr);
//        System.out.println(tree);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int k = sc.nextInt();
            System.out.println(tree.query(l, r, k));
        }
    }
}
