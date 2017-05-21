package com.github.easai.math.prime;
// Mersenne.java  -- Calculate Mersenne prime number

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Copyright (c) 2016 easai

// Author: easai 
// Created: Wed Jun 29 20:56:11 2016
// Keywords: 

// Commentary:
// Compile as (does not require any additional library):
// javac Mersenne.java
//
// Run as:
// java Mersenne n

// Code:
import java.math.BigInteger;

public class Mersenne {
	public static BigInteger mersenne(int p) {
		return (BigInteger.ONE.shiftLeft(p)).subtract(BigInteger.ONE);
	}

	public static void main(String args[]) {
		int n = 1;

		try {
			if (args.length == 0) {
				System.out.print("Enter a number: ");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String str = reader.readLine();
				n = Integer.parseInt(str);
			} else {
				n = Integer.parseInt(args[0]);
			}
			BigInteger mp = mersenne(n);
			System.out.println(mp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

// Mersenne.java ends here
