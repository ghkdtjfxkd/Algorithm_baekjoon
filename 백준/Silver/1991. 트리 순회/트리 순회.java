
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new Node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new Node((char) ('A' + i));
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int rootIdx = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left != '.') tree[rootIdx].left = tree[left - 'A'];
            if(right != '.') tree[rootIdx].right = tree[right - 'A'];
        }

        preOrder(tree[0]); System.out.println();
        inOrder(tree[0]); System.out.println();
        postOrder(tree[0]);
    }

    static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }
}
