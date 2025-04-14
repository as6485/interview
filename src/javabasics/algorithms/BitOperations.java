package javabasics.algorithms;

public class BitOperations {

	public static void main(String[] args) {
		// Initial values
		int a = 5;
		int b = 7;
		int c = 21;
		int d = -21;
		int x = 10, y = 20;

		System.out.println("1's complement of 5 is " + onesComplement(5));

		// bitwise and
		// 0101 & 0111=0101 = 5
		System.out.println("a&b = " + (a & b));

		// bitwise or
		// 0101 | 0111=0111 = 7
		System.out.println("a|b = " + (a | b));

		// bitwise xor
		// 0101 ^ 0111=0010 = 2
		System.out.println("a^b = " + (a ^ b));

		// bitwise not
		// ~00000000 00000000 00000000 00000101=11111111 11111111 11111111 11111010
		// will give 2's complement (32 bit) of 5 = -6
		System.out.println("~a = " + ~a);

		// Signed Left Shift (Sign bit at the extreme left is retained)
		// Each shift multiples by 2. So 2 shifts is multiplication by 4. i.e. 5*4=20
		System.out.println("a << 2 = " + (a << 2));
		System.out.println("-a << 2 = " + (-a << 2));

		// Signed Right Shift (Sign bit at the extreme left is retained)
		// Each shift divides by 2 (roughly). So 2 shifts is division by 4. i.e. 21/4=5
		System.out.println("c >> 2 = " + (c >> 2));
		System.out.println("-c >> 2 = " + (-c >> 2));

		// unsigned Right Shift (Sign bit at the extreme left is replaced with zero)
		// Each shift divides by 2 (roughly). So 2 shifts is division by 4. i.e. 21/4=5
		// for a negative number the sign bit 1 is shifted right
		System.out.println("c >>> 2 = " + (c >>> 2));
		System.out.println("-c >>> 2 = " + (-c >>> 2));

		// get bit
		System.out.println("get 3rd bit of 5 (101) : " + getBit(5, 2));

		// set bit
		System.out.println("set 2nd bit of 5 (101) to 7 (111) : " + setBit(5, 1));

		// clear bit
		System.out.println("clear 2nd bit of 7 (111) to 5 (101) : " + clearBit(7, 1));

		// update bit
		System.out.println("update 2nd bit of 5 (101) with 1 to make 7 (111) : " + updateBit(5, 1, 1));




		//swap without a third variable
		System.out.println("Before swap x : " + x + " y : " + y);
		x ^= y;
		y ^= x;
		x ^= y;
		System.out.println("After swap x : " + x + " y : " + y);
	}

	private static int getBit(int num, int bit) {
		int bitMask = 1 << bit;
		if ((num & bitMask) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	private static int setBit(int num, int bit) {
		int bitMask = 1 << bit;
		return num|bitMask;
	}
	
	
	private static int clearBit(int num, int bit) {
		int bitMask = 1 << bit;
		return num&(~bitMask);
	}
	
	private static int updateBit(int num, int bit, int value) {
		if(value == 1)
			num=setBit(num, bit);
		else if(value == 0)
			num=clearBit(num, bit);
		
		return num;
	}

	private static int onesComplement (int n){
		if(n==0) return 1;
		int countBits = 0;
		int y = n;
		//count the number of bits. For 5(101) its 3
		while(y > 0){
			countBits++;
			y = y >> 1;
		}
		//we need to get 7(111) here. 2 pow 3 minus 1
		int allSetBits = (int) (Math.pow(2, countBits) - 1);
		//5(101) ^ 7(111) will give 2(010)
		return n ^ allSetBits;
	}

}
