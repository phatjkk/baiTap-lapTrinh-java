package ontap;
import java.util.Scanner;

public class bt3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//Nhap ma tran
		System.out.println("Ma tran A");
		//int a[][] = {{3,0,9}, {0,2,0}, {0, 0,8}};
		JMatrix A = new JMatrix();
		A.NhapMaTran();
		A.ShowMaTran();

		System.out.println("Ma tran B");
		//int b[][] = {{5,3,9}, {4,2,5}, {1, 0,8}};
		JMatrix B = new JMatrix();
		B.NhapMaTran();
		B.ShowMaTran();
		
		//Cong ma tran
		System.out.println("KetQua A + B :");
		A.CongMaTran(B).ShowMaTran();
		//Nhan ma tran
		System.out.println("KetQua A x B :");
		A.NhanMaTran(B).ShowMaTran();
		//Check Ma Tran A
		if(A.CheckTamGiac()) {
			System.out.println("A la ma tran TAM GIAC");
		}
		if(A.CheckDonVi()) {
			System.out.println("A la ma tran DON VI");
		}
		if(A.CheckDoiXung()) {
			System.out.println("A la ma tran DOI XUNG");
		}
		System.out.println("Nhap so nguyen muon nhan:");
		int soNguyen = sc.nextInt();
		//Nhan Ma Tran A voi mot so nguyen
		A.NhanVoHuong(soNguyen).ShowMaTran();
		
	
	}
}
class JMatrix{
	int[][] Array;
	public int soCot = 0;
	public int soDong = 0;
	public JMatrix(){
	}
	public JMatrix(int [][] _Array){
		this.Array = _Array;
		soDong = this.Array.length;
		soCot = this.Array[0].length;
		
	}
	public JMatrix(int soDong,int soCot){
		this.Array = new int[soDong][soCot];
	}
	
	public JMatrix CongMaTran(JMatrix input){
		if(input.soCot == this.soCot && input.soDong == this.soDong) {
			JMatrix KetQua = new JMatrix(this.soCot,this.soDong);
			for(int i=0;i<soDong;i++) {
				for(int j=0;j<soCot;j++) {
					KetQua.setValue(i,j,this.Array[i][j] + input.Array[i][j]);
				}
			}
			return KetQua;
		}
		else {
			JMatrix KetQua = new JMatrix(0,0);
			return KetQua;
		}
	}
	public JMatrix NhanMaTran(JMatrix input) {
		if(this.soCot == input.soDong) {
			int C[][] = new int[this.soDong][input.soCot];
			for (int i = 0; i < this.soDong; i++) {
	            for (int j = 0; j < input.soCot; j++) {
	                C[i][j] = 0;
	                for (int k = 0; k < this.soCot; k++) {
	                    C[i][j] = C[i][j] + this.Array[i][k] * input.getValue(k, j);
	                }
	            }
	        }
			JMatrix KetQua = new JMatrix(C);
			return KetQua;
		}
		else {
			JMatrix KetQua = new JMatrix(0,0);
			return KetQua;
		}
		
	}
	public int[][] NhapMaTran(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap So dong ma tran:");
		int soDong = sc.nextInt();
		System.out.println("Nhap So cot ma tran:");
		int soCot = sc.nextInt();
		this.Array = new int[soDong][soCot];
		for(int i=0;i<soDong;i++) {
			for(int j=0;j<soCot;j++) {
				ShowMaTran();
				System.out.println("Nhap So (dong "+(i+1)+", cot "+(j+1)+"):");
				this.Array[i][j] = sc.nextInt();
			}
		}
		this.soCot = soCot;
		this.soDong = soDong;
		return this.Array;
	}
	public void ShowMaTran() {
		System.out.println("[");
		for(int i=0;i<this.Array.length;i++) {
			for(int j=0;j<(this.Array[0].length);j++) {
				System.out.print(this.Array[i][j]+"\t");
			}
			System.out.print("\n");
		}
		System.out.println("]");
	}
	public JMatrix NhanVoHuong(int soHang) {
		int KetQua[][] = new int[this.soDong][this.soCot];
		for(int i=0;i<this.Array.length;i++) {
			for(int j=0;j<(this.Array[0].length);j++) {
				KetQua[i][j] = (this.Array[i][j])*soHang;
			}
		}
		JMatrix C = new JMatrix(KetQua);
		return C;
	}
	public boolean CheckDonVi() {
		if(this.soCot == this.soDong) {
			for(int i=0;i<this.Array.length;i++) {
				for(int j=0;j<(this.Array[0].length);j++) {
					if(!(this.Array[i][i]==1 || this.Array[i][j]==0)) {
						return false;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	public boolean CheckDoiXung() {
		   for (int i = 0; i < this.soDong; i++) {
		        for (int j = 0; j < i; j++) {
		            if (Array[i][j] != Array[j][i]) {
		            	return false;
		            }
		        }
		    }
		   return true;
	}
	public boolean CheckTamGiac() {
		int dem;
		if(this.soCot == this.soDong) {
			if(this.Array[0][this.soCot-1]==0) {
				dem = this.soCot-1;
				for(int i=0;i<this.Array.length;i++) {
					for(int j=(soCot - dem);j<soCot;j++) {
						if(this.Array[i][j]!=0) {
							return false;
						}
					}
					dem--;
				}
				return true;
			}else if(this.Array[this.soDong-1][0]==0) {
				dem = soCot - 1;
				for(int i=this.Array.length-1;i>0;i--) {
					dem--;
					for(int j=0;j<=dem;j++) {
						if(this.Array[i][j]!=0) {
							return false;
						}
					}
					
				}
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean[] XacDinhLoaiMaTran() {
		boolean checkTamGiac = false;
		boolean checkDoiXung = false;
		boolean checkDonVi = false;
		//check ma tran don vi
		checkDonVi = CheckDonVi();
		//check ma tran tam giac
		checkDoiXung = CheckDoiXung();
		checkTamGiac = CheckTamGiac();
		boolean KetQua[] = {checkTamGiac,checkDoiXung,checkDonVi};
		return KetQua;
	}
	public void setValue(int soDong,int soCot,int value) {
		this.Array[soDong][soCot] = value;
	}
	public int getValue(int soDong,int soCot) {
		return this.Array[soDong][soCot];
	}
	public int[][]getArray() {
		return this.Array;
	}
}