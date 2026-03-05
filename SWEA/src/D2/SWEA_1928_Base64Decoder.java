package D2;

import java.util.Scanner;

public class SWEA_1928_Base64Decoder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc = 1; tc <= T; tc++) {
			String line = sc.next();
			int bin = 0;
			int cBin = 0;
			int value = 0;
			System.out.print("#" + tc + " ");
			for(int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if(c >= 'A' && c <= 'Z')
					value = c - 'A';
				else if (c >= 'a' && c <= 'z')
					value = c - 'a' + 26;
				else if(c >= '0' && c <= '9')
					value = c - '0' + 52;
				else if(c == '+')
					value = 62;
				else if(c == '/')
					value = 63;
				
				bin = (bin << 6) | value;
				cBin += 6;
				while(cBin >= 8) {
					cBin -= 8;
					int ch = (bin >> cBin) & 0xFF;
					System.out.print((char)ch);
				}
			}
			
			System.out.println();
		}
	}
}
