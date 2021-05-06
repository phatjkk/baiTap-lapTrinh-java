package ontap;
import java.util.Scanner;
import java.util.ArrayList;

public class bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chon = 0;
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		while(chon !=4)	{
			System.out.println("1/ Nhap danh sach sinh vien");
			System.out.println("2/ Xet danh sach sinh vien tot nghiep");
			System.out.println("3/ Tim sinh vien dai hoc co diem trung binh cao nhat");
			System.out.println("4/ Thoat");
			System.out.print("Nhap tac vu ma ban muon thuc hien: ");
			chon = sc.nextInt();
			switch (chon) {
				case 1:
					System.out.println("So luong sinh vien muon nhap:");
					int soLuong = sc.nextInt();
					SinhVien sinhVien;
					for(int i=0;i<soLuong;i++) {
						System.out.println("Chon he cua sinh vien thu"+(i+1));
						System.out.println("1/ He dai hoc");
						System.out.println("2/ He cao dang");
						System.out.println("Chon :");
						int he = sc.nextInt();
						System.out.println("Nhap MSSV :");
						String MSSV = sc.nextLine();
						System.out.println("Nhap Ho ten :");
						String hoTen = sc.nextLine();
						System.out.println("Nhap dia chi :");
						String diaChi = sc.nextLine();
						System.out.println("Nhap tong so tin chi :");
						int tongTinChi = sc.nextInt();
						System.out.println("Nhap Diem trung binh :");
						double DTB = sc.nextDouble();
						switch (he) {
							case 1:
								System.out.println("Nhap Ten luan van :");
								String tenLuanVan = sc.nextLine();
								System.out.println("Nhap Ten luan van :");
								double diemLuanVan = sc.nextDouble();
								sinhVien = new SVDaiHoc(MSSV, hoTen, diaChi, tongTinChi, DTB, tenLuanVan, diemLuanVan);
								list.add(sinhVien);
							break;
							case 2:
								System.out.print("Nhap diem tot nghiep: ");
								double diemTotNghiep = sc.nextDouble();								
								sinhVien = new SVCaoDang(MSSV, hoTen, diaChi, tongTinChi, DTB, diemTotNghiep);
								list.add(sinhVien);
							break;
						}
					}
				break;
				case 2:
					int slTotNghiep = 0;
					for(SinhVien itemSv:list) {
						if(itemSv instanceof SVCaoDang) {
							if ((itemSv.tongSoTinChi >= 120) && (itemSv.diemTrungBinh >= 5) && (((SVCaoDang)itemSv).getDiemTotNghiep() >= 5)) slTotNghiep++;
						}
						else if (itemSv instanceof SVDaiHoc) {
							if ((itemSv.tongSoTinChi >= 170) && (itemSv.diemTrungBinh >= 5) && (((SVDaiHoc) itemSv).getDiemLuanVan() >= 5)) slTotNghiep++;	
						}
					}
					System.out.println("So luong sinh vien du dieu kien tot nghiep: " + slTotNghiep);
				break;
				case 3:
					SVDaiHoc sinhVienDH = null;
					double diemTrungBinhLonNhat = -1;
					for(SinhVien itemSv:list) {//duyet qua cac phan tu cua arraylist
						if (itemSv instanceof SVDaiHoc) {
							if (itemSv.diemTrungBinh > diemTrungBinhLonNhat){
								diemTrungBinhLonNhat = itemSv.diemTrungBinh;
								sinhVienDH = (SVDaiHoc)itemSv;
							}
						}
					}
					System.out.println("Sinh vien " + sinhVienDH.hoTen + " co diem trung binh cao nhat la " + sinhVienDH.diemTrungBinh);
				break;
			}
		}
			
			

		sc.close();
	}
}

abstract class SinhVien {
	protected String MSSV;
	protected String hoTen;
	protected String diaChi;
	protected int tongSoTinChi;
	protected double diemTrungBinh;
}

class SVCaoDang extends SinhVien {
	private double diemTotNghiep;
	
	public SVCaoDang(String MSSV, String hoTen, String diaChi, int tongSoTinChi, double diemTrungBinh, double diemTotNghiep) {
		this.MSSV = MSSV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.tongSoTinChi = tongSoTinChi;
		this.diemTrungBinh = diemTrungBinh;
		this.diemTotNghiep = diemTotNghiep;
	}
	
	public double getDiemTotNghiep() {
		return diemTotNghiep;
	}
}

class SVDaiHoc extends SinhVien {
	private String tenLuanVan;
	private double diemLuanVan;
	
	public SVDaiHoc(String MSSV, String hoTen, String diaChi, int tongSoTinChi, double diemTrungBinh, String tenLuanVan, double diemLuanVan) {
		this.MSSV = MSSV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.tongSoTinChi = tongSoTinChi;
		this.diemTrungBinh = diemTrungBinh;
		this.tenLuanVan = tenLuanVan;
		this.diemLuanVan = diemLuanVan;
	}
	
	public double getDiemLuanVan() {
		return diemLuanVan;
	}
}
