public class RomanNumeral{
	
	private static String romanNum;
	private static int arabicNum;
	
	public RomanNumeral(String r) {
			romanNum = r;
			for(int i = 0; i < r.length(); i++) {
				if(r.charAt(i) != 'I' && r.charAt(i) != 'V' && r.charAt(i) != 'X' && r.charAt(i) != 'L' && r.charAt(i) != 'C' && r.charAt(i) != 'D' && r.charAt(i) != 'M') {
					throw new IllegalRomanNumeralException("This letter is not a Roman Numeral!");
				}
			}
		arabicNum = 0;
		
		for(int i = r.length() - 1; i >= 0; i--) {
			if(r.charAt(i) == 'I') {
				arabicNum += 1;
			}
			
			if(r.charAt(i) == 'V') {
				arabicNum += 5;
			}
			
			if(r.charAt(i) == 'X') {
				arabicNum += 10;
			}
			
			if(r.charAt(i) == 'L') {
				arabicNum += 50;
			}
			
			if(r.charAt(i) == 'C') {
				arabicNum += 100;
			}
			
			if(r.charAt(i) == 'D') {
				arabicNum += 500;
			}
			
			if(r.charAt(i) == 'M') {
				arabicNum += 1000;
			}
			
			if(i <= r.length() - 2) {
			
				if((r.charAt(i) == 'I' && r.charAt(i + 1) == 'V') || (r.charAt(i) == 'I' && r.charAt(i + 1) == 'X')) {
					arabicNum -= 2;
				}
			
				if((r.charAt(i) == 'X' && r.charAt(i + 1) == 'L') || (r.charAt(i) == 'X' && r.charAt(i + 1) == 'C')) {
					arabicNum -= 20;
				}
			
				if((r.charAt(i) == 'C' && r.charAt(i + 1) == 'D') || (r.charAt(i) == 'C' && r.charAt(i + 1) == 'M')) {
					arabicNum -= 200;
				}
				
			}
		}
		
	}
	
	public String getRomanNumeral() {
		return romanNum;
	}
	
	public void setRomanNumeral(String r) {
		romanNum = r;
	}
	
	public int getArabicNumeral() {
		return arabicNum;
	}
	
	public int compareTo(RomanNumeral other) {
		return this.getArabicNumeral() - other.getArabicNumeral();
	}

		
	
}