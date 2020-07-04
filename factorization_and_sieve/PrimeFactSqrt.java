public class PrimeFactSqrt {
    public List<Integer> primefact(int a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                list.add(i);
                while (a % i == 0) {
                    a /= i;
                }
            }
            if (a > 2)
                list.add(a);
        }
        return list;
    }
}
