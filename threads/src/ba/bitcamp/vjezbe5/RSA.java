package ba.bitcamp.vjezbe5;

import java.math.BigInteger;

public class RSA {

	// private static boolean isPrime(BigInteger num) {
	//
	// BigInteger remainder = num.remainder(new BigInteger(2 + ""));
	//
	// if (num.equals(2)) {
	//
	// return true;
	//
	// } else if (remainder.equals(0)) {
	//
	// return false;
	//
	// } else {
	//
	// int j = 3;
	//
	// BigInteger i = new BigInteger(j + "");
	//
	// while (i.compareTo(sqrt(num)) <= 0) {
	//
	// // System.out.println(i);
	//
	// remainder = num.remainder(i);
	//
	// if (remainder.equals(0)) {
	//
	// return false;
	//
	// } else {
	//
	// j += 2;
	//
	// i = new BigInteger(j + "");
	//
	// }
	//
	// }
	//
	// return true;
	//
	// }
	//
	// }

	public static String findPrimeNums(BigInteger number) {

		String result = null;

		BigInteger a;

		BigInteger remainder;

		int j = 2;

		BigInteger i = new BigInteger(j + "");

		while (i.compareTo(number.divide(new BigInteger(2 + ""))) <= 0) {

//			if (isPrime(i)) {

				remainder = number.remainder(i);

				if (remainder.equals(new BigInteger("0"))) {

					a = number.divide(i);

					result = a + " " + i;

					break;

				}

			//}

			j++;

			i = new BigInteger(j + "");

		}

		return result;

	}

	public static void main(String[] args) {

		System.out.println(findPrimeNums(new BigInteger("400050471579413")));

	}

	public static BigInteger sqrt(BigInteger x) {

		BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
		BigInteger div2 = div;
		// Loop until we hit the same value twice in a row, or wind
		// up alternating.

		for (;;) {

			BigInteger y = div.add(x.divide(div)).shiftRight(1);

			if (y.equals(div) || y.equals(div2))

				return y;

			div2 = div;

			div = y;

		}

	}

}
