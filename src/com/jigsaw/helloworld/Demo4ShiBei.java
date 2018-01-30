package com.jigsaw.helloworld;

// ªÓ‘æ∂»≤‚ ‘
public class Demo4ShiBei {

	public static void main(String[] args) {

		int[] count = { 111, 222, 333, 222, 333, 444, 555, 666, 777, 666, 555, 999 };
		int top = 20, bottom = 10;

		int couontAvg = getAverage(count);
		int resultAvg = 15;
		int b = couontAvg / 15;

		System.out.println("count avg=" + couontAvg + " ressult avg=" + resultAvg);
		System.out.println("±∂ ˝£∫" + b);
	}

	public static int getAverage(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum / arr.length;
	}
}
