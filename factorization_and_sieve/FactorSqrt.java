
public class FactorSqrt {
	public static List<Integer> factorSqrt(int a) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				if (a / i == i) {
					list.add(i);
				} else {
					list.add(i);
					list.add(a / i);
				}
			}
		}

		return list;
	}
}
