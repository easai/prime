package com.github.easai.math.prime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Prime {
	public static boolean testLucasLehmer(int p) throws Exception {
		if (!isPrime(p) || p % 2 == 0)
			throw new Exception();
		BigInteger mp = Mersenne(p);
		System.out.println("Mersenne number of " + p + " is " + mp);
		return _f(p - 2).mod(mp).equals(BigInteger.ZERO);
	}

	public static BigInteger _f(int p) {
		BigInteger f = new BigInteger("4");
		if (0 < p) {
			BigInteger t = _f(p - 1);
			f = t.multiply(t).subtract(new BigInteger("2"));
		}
		return f;
	}

	public static BigInteger Mersenne(int p) {
		return (BigInteger.ONE.shiftLeft(p)).subtract(BigInteger.ONE);
	}

	public static boolean isPrime(int n) {
		if (n == 1)
			return false;

		int max = (int) Math.sqrt(n);
		int i = 1;
		while ((n % (i + 1)) != 0 && ++i < max)
			;

		return !(i < max);
	}

	public static boolean isPrime(BigInteger n) {
		if (n.equals(BigInteger.ONE))
			return false;

		BigInteger max = n;
		BigInteger i = BigInteger.ONE;
		while (!(n.mod(i.add(BigInteger.ONE))).equals(BigInteger.ZERO)
				&& (i = i.add(BigInteger.ONE)).compareTo(max) == -1)
			;
		// it evaluates before assigning the value, therefore the value ends
		// with max-1

		return i.compareTo(max.subtract(BigInteger.ONE)) == 0;
	}

	public static void factor(int n) {
		int max = (int) Math.sqrt(n);
		for (int i = 1; i <= max; i++) {
			if ((n % i) == 0) {
				System.out.print(i + " ");
				if (i != n / i)
					System.out.print(n / i + " ");
			}
		}
	}

	public static int[] sushu(int n) {
		int prime[] = new int[n];
		prime[0] = 1;
		int max = (int) Math.sqrt(n);
		for (int i = 1; i < max; i++) {
			if (prime[i] == 0) {
				int ii = i + 1;
				for (int j = ii + ii - 1; j < n; j += ii) {
					prime[j] = 1;
				}
			}
		}
		return prime;
	}

	public static void main(String args[]) {
		System.out.print("Enter a number: ");
		int n = 1;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String str = reader.readLine();
			n = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(n + " is divisible by:");
		factor(n);

		/*
		 * for(int i=1;i<100;i++) { if(isPrime(i)) System.out.print(i+" "); }
		 * System.out.println();
		 */
		/*
		 * try { String fileName="sushu.txt"; PrintWriter out=new
		 * PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		 * 
		 * int array[]=sushu(10000000);
		 * 
		 * for(int i=0;i<array.length;i++) { if(array[i]==0) out.print((i+1)+" "
		 * ); } out.close(); } catch(Exception e){e.printStackTrace();}
		 */

		/*
		 * int p[]={2,3,5,7,13,17,19,31}; for(int i=0;i<p.length;i++) { int n=(1
		 * << p[i])-1; if(isPrime(n)) System.out.println(n+" is a prime number"
		 * ); else System.out.println(n+" is not a prime number"); }
		 */
		/*
		 * int P[]={61}; for(int i=0;i<p.length;i++) { BigInteger
		 * n=(BigInteger.ONE.shiftRight(P[i])).subtract(BigInteger.ONE);
		 * if(isPrime(n)) System.out.println(n+" is a prime number"); else
		 * System.out.println(n+" is not a prime number"); }
		 */
		/*
		 * int p[]={2,3,5,7,13,17,19,31,61}; for(int i=0;i<p.length;i++) { int
		 * n=p[i]; System.out.println(n); try { if(testLucasLehmer(n))
		 * System.out.println("Mersenne("+n+") is a prime number"); else
		 * System.out.println("Mersenne("+n+") is not a prime number"); }
		 * catch(Exception e){e.printStackTrace();} }
		 */
		// for(int i=0;i<10;i++)
		// System.out.println(i+" "+_f(i));
	}
}
