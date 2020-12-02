package ntphat;

import java.util.Scanner;

public class ntphat {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tinhnang=0,maxcp,n;
		do {
			
		
		System.out.println("MENU CHUONG TRINH:");
		System.out.println("1. In cac so chinh phuong tu 1->n");
		System.out.println("2. In cac chu so của n");
		System.out.println("3. Cho biet n gom bao nhieu chu so");
		System.out.println("4. Mo phong may ban hang");
		System.out.println("5. Thoat");
		Scanner nhap=new Scanner(System.in);
		tinhnang=nhap.nextInt();
		if(tinhnang==1) {
			System.out.println("In cac so chinh phuong tu 1->n");
			System.out.println("Nhap n:");
			maxcp = nhap.nextInt();
			for(int i = 1;i<=maxcp;i++) {
				if(Math.sqrt(i)-(int)Math.sqrt(i)==0) {
					System.out.println(i);
				}
			}
		}
		else if(tinhnang==2) {
			System.out.println("In cac chu so của n");
			System.out.println("Nhap n:");
			n = nhap.nextInt();
			while(n>0) {
				System.out.println(n%10);
				n=n/10;
			}
		}
		else if(tinhnang==3) {
			System.out.println("Cho biet n gom bao nhieu chu so");
			System.out.println("Nhap n:");
			int dem =0;
			n = nhap.nextInt();
			while(n>0) {
				dem+=1;
				n=n/10;
			}
			System.out.println(dem);
		}
		else if(tinhnang==4){
			int sl1=0;
			int sl2=0;
			do {
				System.out.println("MENU:");
				System.out.println("1. Coca: 10k");
				System.out.println("2. Poca: 5k");
				System.out.println("3. Thoat");
				System.out.println("Ban chon:");
				tinhnang = nhap.nextInt();
				if(tinhnang==1) {
					sl1+=1;
				}
				if(tinhnang==2) {
					sl2+=1;
				}
			}while(tinhnang!=3);
			int tienthanhtoan=sl1*10000+sl2*5000;
			System.out.println("TONG SO TIEN CUA BAN LA:" +tienthanhtoan);
			System.out.println("Nhap so tien cua ban:");
			int tienmua = nhap.nextInt();
			if(tienmua>=tienthanhtoan) {
				System.out.println("++ THANH TOAN THANH CONG!! ++");
				System.out.println("Tra lai ban:"+(tienmua-tienthanhtoan));
			}
			else {
				System.out.println("++ THANH TOAN KHONG THANH CONG!! ++");
				System.out.println("Ban con thieu:"+(tienthanhtoan-tienmua));
			}
		}
		}while(tinhnang!=5);
	}
	
}
