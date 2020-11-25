/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dt.cv.hinhtron;

import java.util.Scanner;

/**
 *
 * @author phatjk
 */
public class DtCvHinhtron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("TINH DT,CV HINH TRON");
        Scanner sc = new Scanner(System.in);
        final float pi=(float)3.14;
        float r,cv,dt;
        //nhap
        System.out.println("Nhập ban kinh:");
        r = sc.nextFloat();
        // tinh toan
        cv = 2*pi*r;
        dt = pi*r*r;
        //xuat
        System.out.println("Chu vi ="+cv+";Dien tich ="+dt);
    }
    
}
