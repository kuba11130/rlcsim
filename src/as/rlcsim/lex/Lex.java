package as.rlcsim.lex;

/**
 * @author Agnieszka
 * 
 */
public class Lex {

	public static final String[] bigNames = { "", "k", "M", "G", "T", "peta",
			"eksa", "zetta", "jotta" };
	public static final String[] smallNames = { "mili", "mikro", "nano",
			"piko", "femto", "atto", "zepto", "jokto" };

	public static void main(String[] args) {

		String str = Lex.addUnit(3434.3);
		System.out.println(str);
	}

	/**
	 * @param arg0
	 * @return
	 */
	public static String addUnit(Double arg0) {

		if (arg0 >= 1) {
			if (arg0 >= Math.pow(10, 3 * bigNames.length)) {
				Double n = arg0 / Math.pow(10, 3 * (bigNames.length - 1));
				n = round(n, 2);
				String str = addZero(n);
				return str + bigNames[bigNames.length - 1];
			}
			for (int i = 0; i < bigNames.length; i++) {
				if (arg0 >= Math.pow(10, 3 * i)
						&& arg0 < Math.pow(10, 3 * (i + 1))) {
					Double n = arg0 / Math.pow(10, 3 * i);
					n = round(n, 2);
					String str = addZero(n);
					return str + bigNames[i];
				}
			}
		} else {

			if (arg0 <= Math.pow(10, -3 * smallNames.length)) {
				Double n = arg0 / Math.pow(10, 3 * (smallNames.length - 1));
				n = round(n, 2);
				String str = addZero(n);
				return str + smallNames[smallNames.length - 1];
			}

			for (int i = 0; i < smallNames.length; i++) {
				if (arg0 <= Math.pow(10, -3 * i)
						&& arg0 > Math.pow(10, 3 * -(i + 1))) {
					Double n = arg0 / Math.pow(10, -3 * (i + 1));
					n = round(n, 2);
					String str = addZero(n);
					return str + smallNames[i];
				}
			}
		}
		return "ERROR";
	}

	public static String addUnit(Integer arg0) {

		if (arg0 >= 1) {
			if (arg0 >= Math.pow(10, 3 * bigNames.length)) {
				Double n = arg0 / Math.pow(10, 3 * (bigNames.length - 1));
				n = round(n, 2);
				String str = addZero(n);
				return str + bigNames[bigNames.length - 1];
			}
			for (int i = 0; i < bigNames.length; i++) {
				if (arg0 >= Math.pow(10, 3 * i)
						&& arg0 < Math.pow(10, 3 * (i + 1))) {
					Double n = arg0 / Math.pow(10, 3 * i);
					n = round(n, 2);
					String str = addZero(n);
					return str + bigNames[i];
				}
			}
		} else {

			if (arg0 <= Math.pow(10, -3 * smallNames.length)) {
				Double n = arg0 / Math.pow(10, 3 * (smallNames.length - 1));
				n = round(n, 2);
				String str = addZero(n);
				return str + smallNames[smallNames.length - 1];
			}

			for (int i = 0; i < smallNames.length; i++) {
				if (arg0 <= Math.pow(10, -3 * i)
						&& arg0 > Math.pow(10, 3 * -(i + 1))) {
					Double n = arg0 / Math.pow(10, -3 * (i + 1));
					n = round(n, 2);
					String str = addZero(n);
					return str + smallNames[i];
				}
			}
		}
		return "ERROR";
	}

	public static String addZero(Double arg0) {
		if (arg0 < 10) {
			System.out.println("1");
			return arg0.toString() + "00";
		}
		if (arg0 < 100) {
			System.out.println("2");
			return arg0.toString() + "0";
		}
		if (arg0 < 1000) {
			return arg0.toString() + "";
		}
		return "ERROR";
	}

	public static double round(double f, int places) {
		System.out.println("round");
		double temp = (f * (Math.pow(10, places)));
		temp = (Math.round(temp));
		temp = temp / (Math.pow(10, places));
		return temp;
	}

}
