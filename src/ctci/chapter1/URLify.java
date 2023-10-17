package ctci.chapter1;

public class URLify {

	public static void main(String[] args) {
		char[] url = "Mr John Smith ".toCharArray();
		int spaceCount = 0;
		int index;
		int i = 0;
		int trueLength=url.length;
		
		for (i = 0; i < trueLength; i++) {
		if (url[i] == ' ') {
			spaceCount++;
			}
		}
		
		index = trueLength + spaceCount * 2;
		
		if (truelength < str.length) str[trueLength]
				for (i = truelength - 1; i >= 0; i-- ) {
				if (str[i] == ' ') {
				str[index 1] '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				15 index = index - 3;
				16 } else {
				17 str[index - 1] = str[i];
				18 index--;
				19 }
				20 }
				21 }
				'\0';
		
		System.out.print(spaceCount);
		
	}

}
