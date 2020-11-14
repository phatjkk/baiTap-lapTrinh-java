/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xep.loai.hoc.tap;

import java.util.Scanner;

/**
 *
 * @author phatjk
 */
public class XepLoaiHocTap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("TÍNH XẾP LOẠI HỌC LỰC");
        float dcs,dcn;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số điểm cơ sở:");
        dcs= sc.nextFloat();
        System.out.println("Nhập số điểm chuyên ngành:");
        dcn= sc.nextFloat();
        //tinh toan
        float dtb = (dcs+dcn*2)/3;
        if (dtb<5) {
            System.out.println("ĐIỂM TRUNG BÌNH LÀ:" + dtb);
            System.out.println("XẾP LOẠI HỌC LỰC YẾU");
        }
        else if(dtb>5 && dtb <7){
            System.out.println("ĐIỂM TRUNG BÌNH LÀ:" + dtb);
            System.out.println("XẾP LOẠI HỌC LỰC TRUNH BÌNH");
        }
        else if(dtb>=7 && dtb <8.5){
            System.out.println("ĐIỂM TRUNG BÌNH LÀ:" + dtb);
            System.out.println("XẾP LOẠI HỌC LỰC KHÁ");
        }
        else if(dtb>=8.5 && dtb <=10){
            System.out.println("ĐIỂM TRUNG BÌNH LÀ:" + dtb);
            System.out.println("XẾP LOẠI HỌC LỰC GIỎI");
        }
    }
    
}
