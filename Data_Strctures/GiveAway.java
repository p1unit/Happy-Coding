// @uthor -: puneet
// TimeStamp -: 2:14 PM - 06/11/19
// Qlink - https://www.codechef.com/problems/GIVEAWAY

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class GiveAway implements Runnable {
    long MOD = (long) 1E9 + 7;
    int MAX = 1000001;
    public void solve() {
        int n=in.ni();
        int[] arr=in.intarr(n);
        int BUCKET_SIZE=(int)Math.sqrt(n*1.0)+1;
        int[][] preArr=new int[BUCKET_SIZE][BUCKET_SIZE];

        for(int i=0;i<n;++i){
            preArr[i/BUCKET_SIZE][i%BUCKET_SIZE]=arr[i];
        }

        for(int i=0;i<BUCKET_SIZE;++i){
            sort(preArr[i]);
        }

        int q=in.ni();
        while (q-->0){
            int t=in.ni();
            int ans=0;
            if(t==0){
                int l=in.ni()-1,r=in.ni()-1,c=in.ni();
                int BL=l/BUCKET_SIZE,BR=r/BUCKET_SIZE;
                if(BL==BR){
                    for(int i=l;i<=r;++i){
                        if(arr[i]>=c)
                            ++ans;
                    }
                }else {
                    int end=(BL+1)*BUCKET_SIZE-1;
                    for(int i=l;i<=Math.min(end,n-1);++i){
                        if(arr[i]>=c)
                            ++ans;
                    }
                    for(int i=BL+1;i<BR;++i){
                        ans+=lowerBound(preArr[i],0,BUCKET_SIZE,c);
                    }
                    for(int i=BR*BUCKET_SIZE;i<=r;++i){
                        if(arr[i]>=c)
                            ++ans;
                    }
                }
                out.println(ans);
            }else {
                int idx=in.ni()-1,val=in.ni();
                int B=idx/BUCKET_SIZE;
                for(int i=0;i<BUCKET_SIZE;++i){
                    if(preArr[B][i]==arr[idx]){
                        preArr[B][i]=val;
                        break;
                    }
                }
                sort(preArr[B]);
                arr[idx]=val;
            }

        }

    }

    int lowerBound(int[] arr,int low,int high,int c){
        int mid;
        while (low<high){
            mid=(low+high)>>1;
            if(arr[mid]<c){
                low=mid+1;
            }else {
                high=mid;
            }
        }

//        out.println(low+" "+high+" -> "+ Arrays.toString(arr));

        return Math.max((arr.length - low), 0);
    }

    /* -------------------- Templates and Input Classes -------------------------------*/
    @Override
    public void run() {
        long time = System.currentTimeMillis();
        try {
            init();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        solve();
        out.flush();
        System.err.println(System.currentTimeMillis() - time);
    }

    private FastInput in;
    private PrintWriter out;

    public static void main(String[] args) throws Exception {
        new Thread(null, new GiveAway(), "Main", 1 << 27).start();
    }

    private void init() throws FileNotFoundException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        try {
            if (System.getProperty("user.name").equals("puneet")) {
                outputStream = new FileOutputStream("/home/puneet/Desktop/output.txt");
                inputStream = new FileInputStream("/home/puneet/Desktop/input.txt");
            }
        } catch (Exception ignored) {
        }
        out = new PrintWriter(outputStream);
        in = new FastInput(inputStream);
    }

    private void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }

    private void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }

    public long ModPow(long x, long y, long MOD) {
        long res = 1L;
        x = x % MOD;
        while (y >= 1) {
            if ((y & 1) > 0) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static class FastInput {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public FastInput(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String ns() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(ns());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nc() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nd() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, ni());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, ni());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }


        public String next() {
            return ns();
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

        public int[] intarr(int n) {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = ni();
            }
            return arr;
        }

        public double[] doublearr(int n) {
            double arr[] = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nd();
            }
            return arr;
        }

        public double[][] doublearr(int n, int m) {
            double[][] arr = new double[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nd();
                }
            }
            return arr;
        }

        public int[][] intarr(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = ni();
                }
            }
            return arr;
        }


        public long[][] longarr(int n, int m) {
            long[][] arr = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nl();
                }
            }
            return arr;
        }

        public long[] longarr(int n) {
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nl();
            }
            return arr;
        }

    }

}