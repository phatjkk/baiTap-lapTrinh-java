package baiTapHam;

public class baiTapHam {

	public static void main(String[] args) {
		inCacSNT(10000);
		
	}
	public static void inCacSNT(int n) {
		for (int i = 0; i < n; i++) {
			if (checkSNT(i)) {
				System.out.println(i);
			}
		}
	}
	public static void inCacSoChiaHetCho3(int n) {
		for (int i = 0; i < n; i++) {
			if (checkChiaHet(3,i)) {
				System.out.println(i);
			}
		}
	}
	public static boolean checkChiaHet(int soChia,int soBiChia) {
		if (soBiChia%soChia==0) {
			return true;
		}
		else {
			return false; 
		}
	}
    public static boolean checkSNT(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int)Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
