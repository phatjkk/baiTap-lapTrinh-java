package ontap;

import java.util.ArrayList;
import java.util.Scanner;

public class bt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<GiaSuc> list = new ArrayList<GiaSuc>();
		int chon=0;
		while(chon !=4)	{
			System.out.println("*****************************************************");
			System.out.println("1/ Nhap danh sach vat nuoi");
			System.out.println("2/ Nhung tien kieu co the nghe duoc khi nong trai doi");
			System.out.println("3/ Thong ke");
			System.out.println("4/ Thoat");
			System.out.println("*****************************************************");
			System.out.print("Nhap tac vu ma ban muon thuc hien: ");
			
			chon = sc.nextInt();
			switch (chon) {
				case 1:
					GiaSuc convat;
					System.out.println("*****************************************************");
					System.out.println("So luong vat nuoi muon nhap:");
					int soLuong = sc.nextInt();
					SinhVien sinhVien;
					for(int i=0;i<soLuong;i++) {
						System.out.println("*****************************************************");
						System.out.println("Chon loai cua dong vat thu "+(i+1));
						System.out.println("1/ Bo");
						System.out.println("2/ Cuu");
						System.out.println("3/ De");
						System.out.println("*****************************************************");
						System.out.println("Chon :");
						int loaiConVat = sc.nextInt();
						int Con ;
						double Milk;
						switch(loaiConVat) {
							case 1:
								while(true) {
									System.out.println("So luong sua cua con Bo:"+"("+(i+1)+")");
									Milk = sc.nextDouble();
									System.out.println("So luong con cua con Bo:"+"("+(i+1)+")");
									Con = sc.nextInt();
									if(Con<=10 && Con>0 && Milk<=20 && Milk>0) {
										break;
									}
									else {
										System.out.println("Sl con < 10 va Sl sua <=20");
									}
								}
								Bo conbo = new Bo(Con, Milk);
								list.add(conbo);
							break;
							case 2:
								while(true) {
									System.out.println("So luong sua cua con De:"+"("+(i+1)+")");
									Milk = sc.nextDouble();
									System.out.println("So luong con cua con De:"+"("+(i+1)+")");
									Con = sc.nextInt();
									if(Con<=10 && Con>0 && Milk<=10 && Milk>0) {
										break;
									}
									else {
										System.out.println("Sl con < 10 va Sl sua <=10");
									}
								}
								De conde = new De(Con, Milk);
								list.add(conde);
							break;
							case 3:
								while(true) {
									System.out.println("So luong sua cua con Cuu:"+"("+(i+1)+")");
									Milk = sc.nextDouble();
									System.out.println("So luong con cua con Cuu:"+"("+(i+1)+")");
									Con = sc.nextInt();
									if(Con<=10 && Con>0 && Milk<=5 && Milk>0) {
										break;
									}
									else {
										System.out.println("Sl con < 10 va Sl sua <=5");
									}
								}
								Cuu concuu = new Cuu(Con, Milk);
								list.add(concuu);
							break;
						}
					}
					break;
				case 2:
					String tiengKeu="";
					for(GiaSuc itemGs : list) {
						tiengKeu += itemGs.keu+", ";
					}
					System.out.println("*****************************************************");
					System.out.println("Nhung tieng keu nghe duoc la:");
					System.out.println(tiengKeu);
				break;
				case 3:
					double TotalSuaBo = 0;
					double TotalSuaDe = 0;
					double TotalSuaCuu = 0;
					int TotalBoCon = 0;
					int TotalDeCon = 0;
					int TotalCuuCon = 0;
					for(GiaSuc itemGs : list) {
						if(itemGs instanceof Bo) {
							TotalSuaBo += ((Bo)itemGs).getMilk();
							TotalBoCon += ((Bo)itemGs).getCon();
						}
						if(itemGs instanceof De) {
							TotalSuaDe += ((De)itemGs).getMilk();
							TotalDeCon += ((De)itemGs).getCon();
						}
						if(itemGs instanceof Cuu) {
							TotalSuaCuu += ((Cuu)itemGs).getMilk();
							TotalCuuCon += ((Cuu)itemGs).getCon();
						}
					}
					System.out.println("*****************************************************");
					System.out.println("Thong ke:");
					System.out.println("So luong sua Bo:"+TotalSuaBo+"(lit)");
					System.out.println("So luong sua De:"+TotalSuaDe+"(lit)");
					System.out.println("So luong sua Cuu:"+TotalSuaCuu+"(lit)");
					System.out.println("So luong Bo con:"+TotalBoCon+"(con)");
					System.out.println("So luong De con:"+TotalDeCon+"(con)");
					System.out.println("So luong Cuu con:"+TotalCuuCon+"(con)");
				break;
					
		}

	}
	}
}
abstract class GiaSuc{
	protected double maxMilk;
	protected double Milk;
	protected int Con;
	protected String keu;
}
class Bo extends GiaSuc{
	public Bo(int con,double milk){
		this.Milk = milk;
		this.Con = con;
		this.maxMilk = 20;
		this.keu = "um bo";
	}
	public double getMilk(){
		return this.Milk;
	}
	public double getCon(){
		return this.Con;
	}
}
class Cuu extends GiaSuc{
	Cuu(int con,double milk){
		this.Milk = milk;
		this.Con = con;
		this.maxMilk = 5;
		this.keu = "be be";
	}
	double getMilk(){
		return this.Milk;
	}
	double getCon(){
		return this.Con;
	}
}
class De extends GiaSuc{
	De(int con,double milk){
		this.Milk = milk;
		this.Con = con;
		this.maxMilk = 10;
		this.keu = "eeee eeee";
	}
	double getMilk(){
		return this.Milk;
	}
	double getCon(){
		return this.Con;
	}
}