import java.io.*;
import java.util.*;
 
public class Main {
 
    static final long INF = Long.MAX_VALUE / 4;
 
    static int n, q, x;
    static int size;
    static int SZ;
 
    static int[] d;
    static int[] s;
 
    // Segment tree matrices stored in one flat array.
    // Each node contains x * x values.
    static long[] tree;
 
    // Length of each segment, capped at x.
    static byte[] len;
 
    static void makeLeaf(int node, int d, int s) {
        int base = node * SZ;
 
        // Initially everything is INF.
        Arrays.fill(tree, base, base + SZ, INF);
 
        int limit = Math.min(d, x);
 
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < x; j++) {
 
                // ceil((d + j - i) / x) - 1
                long jumps = (d + j - i + x - 1L) / x - 1;
 
                tree[base + i * x + j] = jumps * s;
            }
        }
 
        len[node] = (byte) limit;
    }
 
    static void makeIdentity(int node) {
        int base = node * SZ;
 
        Arrays.fill(tree, base, base + SZ, INF);
 
        for (int i = 0; i < x; i++) {
            tree[base + i * x + i] = 0;
        }
 
        len[node] = 0;
    }
 
    /*
     * C = A * B  (min-plus matrix multiplication)
     *
     * lenA = length of A, capped at x
     * lenB = length of B, capped at x
     */
    static void mergeNode(int node, int left, int right) {
 
        int baseC = node * SZ;
        int baseA = left * SZ;
        int baseB = right * SZ;
 
        int lenA = len[left] & 255;
        int lenB = len[right] & 255;
 
        int lenC = Math.min(x, lenA + lenB);
        len[node] = (byte) lenC;
 
        // Only valid starting positions need to be calculated.
        for (int i = 0; i < lenC; i++) {
 
            for (int j = 0; j < x; j++) {
 
                long best = INF;
 
                /*
                 * If the starting position is already inside B,
                 * we can directly use B.
                 */
                if (i >= lenA) {
                    best = tree[baseB + (i - lenA) * x + j];
                }
 
                /*
                 * Normal transition:
                 *
                 * A[i][k] + B[k][j]
                 */
                int aRow = baseA + i * x;
                int bCol = baseB + j;
 
                for (int k = 0; k < x; k++) {
 
                    long a = tree[aRow + k];
                    long b = tree[baseB + k * x + j];
 
                    if (a != INF && b != INF) {
                        long value = a + b;
 
                        if (value < best) {
                            best = value;
                        }
                    }
                }
 
                tree[baseC + i * x + j] = best;
            }
        }
 
        // Invalid rows remain INF.
    }
 
    static void build() {
 
        size = 1;
        while (size < n) {
            size <<= 1;
        }
 
        tree = new long[2 * size * SZ];
        len = new byte[2 * size];
 
        // Everything starts as INF.
        Arrays.fill(tree, INF);
 
        // Real leaves.
        for (int i = 0; i < n; i++) {
            makeLeaf(size + i, d[i], s[i]);
        }
 
        // Empty leaves = identity matrix.
        for (int i = n; i < size; i++) {
            makeIdentity(size + i);
        }
 
        // Build tree.
        for (int node = size - 1; node >= 1; node--) {
            mergeNode(node, node << 1, node << 1 | 1);
        }
    }
 
    static void update(int index) {
 
        int node = size + index;
 
        makeLeaf(node, d[index], s[index]);
 
        node >>= 1;
 
        while (node > 0) {
            mergeNode(node, node << 1, node << 1 | 1);
            node >>= 1;
        }
    }
 
    /*
     * Merge matrices:
     *
     * C = A * B
     *
     * A and B are temporary matrices, not tree nodes.
     */
    static void mergeTemp(
            long[] C,
            long[] A,
            int lenA,
            long[] B,
            int lenB
    ) {
 
        Arrays.fill(C, INF);
 
        int lenC = Math.min(x, lenA + lenB);
 
        for (int i = 0; i < lenC; i++) {
 
            for (int j = 0; j < x; j++) {
 
                long best = INF;
 
                // Start directly inside B.
                if (i >= lenA) {
                    best = B[(i - lenA) * x + j];
                }
 
                for (int k = 0; k < x; k++) {
 
                    long a = A[i * x + k];
                    long b = B[k * x + j];
 
                    if (a != INF && b != INF) {
                        long value = a + b;
 
                        if (value < best) {
                            best = value;
                        }
                    }
                }
 
                C[i * x + j] = best;
            }
        }
    }
 
    static long query(int l, int r) {
 
        // Identity matrix.
        long[] leftMatrix = new long[SZ];
        long[] rightMatrix = new long[SZ];
        long[] temp = new long[SZ];
 
        Arrays.fill(leftMatrix, INF);
        Arrays.fill(rightMatrix, INF);
 
        for (int i = 0; i < x; i++) {
            leftMatrix[i * x + i] = 0;
            rightMatrix[i * x + i] = 0;
        }
 
        int leftLen = 0;
        int rightLen = 0;
 
        l += size;
        r += size + 1;
 
        while (l < r) {
 
            if ((l & 1) == 1) {
 
                int base = l * SZ;
 
                long[] nodeMatrix = new long[SZ];
 
                System.arraycopy(
                        tree,
                        base,
                        nodeMatrix,
                        0,
                        SZ
                );
 
                mergeTemp(
                        temp,
                        leftMatrix,
                        leftLen,
                        nodeMatrix,
                        len[l] & 255
                );
 
                long[] swap = leftMatrix;
                leftMatrix = temp;
                temp = swap;
 
                leftLen = Math.min(
                        x,
                        leftLen + (len[l] & 255)
                );
 
                l++;
            }
 
            if ((r & 1) == 1) {
 
                --r;
 
                int base = r * SZ;
 
                long[] nodeMatrix = new long[SZ];
 
                System.arraycopy(
                        tree,
                        base,
                        nodeMatrix,
                        0,
                        SZ
                );
 
                mergeTemp(
                        temp,
                        nodeMatrix,
                        len[r] & 255,
                        rightMatrix,
                        rightLen
                );
 
                long[] swap = rightMatrix;
                rightMatrix = temp;
                temp = swap;
 
                rightLen = Math.min(
                        x,
                        (len[r] & 255) + rightLen
                );
            }
 
            l >>= 1;
            r >>= 1;
        }
 
        mergeTemp(
                temp,
                leftMatrix,
                leftLen,
                rightMatrix,
                rightLen
        );
 
        // We only need the first row for the final answer.
        return temp[0];
    }
 
    static long solveQuery(int l, int r) {
 
        // Same platform.
        if (l == r) {
 
            // Number of jumps from first cell to last cell.
            long jumps = (d[l] - 1L + x - 1L) / x;
 
            return jumps * s[l];
        }
 
        /*
         * Get matrix for platforms [l, r-1].
         */
        long[] matrix = getQueryMatrix(l, r - 1);
 
        long answer = INF;
 
        /*
         * i = first landing position on platform r.
         */
        int limit = Math.min(x, d[r]);
 
        for (int i = 0; i < limit; i++) {
 
            long firstPart = matrix[i];
 
            if (firstPart == INF) {
                continue;
            }
 
            /*
             * From position i of platform r
             * to its last cell.
             *
             * ceil((d[r] - i - 1) / x)
             */
            long jumps =
                    (d[r] - i - 1L + x - 1L) / x;
 
            long cost = firstPart + jumps * s[r];
 
            answer = Math.min(answer, cost);
        }
 
        return answer;
    }
 
    static long[] getQueryMatrix(int l, int r) {
 
        long[] leftMatrix = new long[SZ];
        long[] rightMatrix = new long[SZ];
        long[] temp = new long[SZ];
 
        Arrays.fill(leftMatrix, INF);
        Arrays.fill(rightMatrix, INF);
 
        for (int i = 0; i < x; i++) {
            leftMatrix[i * x + i] = 0;
            rightMatrix[i * x + i] = 0;
        }
 
        int leftLen = 0;
        int rightLen = 0;
 
        l += size;
        r += size + 1;
 
        while (l < r) {
 
            if ((l & 1) == 1) {
 
                mergeTreeToTemp(
                        temp,
                        leftMatrix,
                        leftLen,
                        l
                );
 
                long[] swap = leftMatrix;
                leftMatrix = temp;
                temp = swap;
 
                leftLen = Math.min(
                        x,
                        leftLen + (len[l] & 255)
                );
 
                l++;
            }
 
            if ((r & 1) == 1) {
 
                --r;
 
                mergeTreeToTempRight(
                        temp,
                        r,
                        rightMatrix,
                        rightLen
                );
 
                long[] swap = rightMatrix;
                rightMatrix = temp;
                temp = swap;
 
                rightLen = Math.min(
                        x,
                        (len[r] & 255) + rightLen
                );
            }
 
            l >>= 1;
            r >>= 1;
        }
 
        mergeTemp(
                temp,
                leftMatrix,
                leftLen,
                rightMatrix,
                rightLen
        );
 
        return temp;
    }
 
    static void mergeTreeToTemp(
            long[] C,
            long[] A,
            int lenA,
            int node
    ) {
 
        Arrays.fill(C, INF);
 
        int baseB = node * SZ;
        int lenB = len[node] & 255;
 
        int lenC = Math.min(x, lenA + lenB);
 
        for (int i = 0; i < lenC; i++) {
 
            for (int j = 0; j < x; j++) {
 
                long best = INF;
 
                if (i >= lenA) {
                    best = tree[
                            baseB + (i - lenA) * x + j
                    ];
                }
 
                for (int k = 0; k < x; k++) {
 
                    long a = A[i * x + k];
                    long b = tree[baseB + k * x + j];
 
                    if (a != INF && b != INF) {
                        best = Math.min(best, a + b);
                    }
                }
 
                C[i * x + j] = best;
            }
        }
    }
 
    static void mergeTreeToTempRight(
            long[] C,
            int node,
            long[] B,
            int lenB
    ) {
 
        Arrays.fill(C, INF);
 
        int baseA = node * SZ;
        int lenA = len[node] & 255;
 
        int lenC = Math.min(x, lenA + lenB);
 
        for (int i = 0; i < lenC; i++) {
 
            for (int j = 0; j < x; j++) {
 
                long best = INF;
 
                if (i >= lenA) {
                    best = B[(i - lenA) * x + j];
                }
 
                for (int k = 0; k < x; k++) {
 
                    long a = tree[baseA + i * x + k];
                    long b = B[k * x + j];
 
                    if (a != INF && b != INF) {
                        best = Math.min(best, a + b);
                    }
                }
 
                C[i * x + j] = best;
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
 
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();
 
        n = fs.nextInt();
        q = fs.nextInt();
        x = fs.nextInt();
 
        SZ = x * x;
 
        d = new int[n];
        s = new int[n];
 
        for (int i = 0; i < n; i++) {
            d[i] = fs.nextInt();
        }
 
        for (int i = 0; i < n; i++) {
            s[i] = fs.nextInt();
        }
 
        build();
 
        while (q-- > 0) {
 
            String type = fs.next();
 
            if (type.charAt(0) == '1') {
 
                int i = fs.nextInt() - 1;
                int v = fs.nextInt();
 
                d[i] = v;
 
                update(i);
 
            } else if (type.charAt(0) == '2') {
 
                int i = fs.nextInt() - 1;
                int v = fs.nextInt();
 
                s[i] = v;
 
                update(i);
 
            } else {
 
                int l = fs.nextInt() - 1;
                int r = fs.nextInt() - 1;
 
                out.append(solveQuery(l, r)).append('
');
            }
        }
 
        System.out.print(out);
    }
 
    // Fast input for Codeforces.
    static class FastScanner {
 
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;
 
        FastScanner(InputStream in) {
            this.in = in;
        }
 
        private int read() throws IOException {
 
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
 
                if (len <= 0) {
                    return -1;
                }
            }
 
            return buffer[ptr++];
        }
 
        String next() throws IOException {
 
            StringBuilder sb = new StringBuilder();
 
            int c;
 
            do {
                c = read();
            } while (c <= ' ');
 
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
 
            return sb.toString();
        }
 
        int nextInt() throws IOException {
 
            int c;
 
            do {
                c = read();
            } while (c <= ' ');
 
            int sign = 1;
 
            if (c == '-') {
                sign = -1;
                c = read();
            }
 
            int res = 0;
 
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
 
            return res * sign;
        }
    }
}