/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tinh.tien.taxi;

import java.util.Scanner;

/**
 *
 * @author phatjk
 */
public class TinhTienTaxi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("TINH TIEN TAXI");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhập so km di duoc:");
        float km,sotien;
        float tien1=15000;
        float tien2=9/(float)0.2*2500+tien1;
        km = sc.nextFloat();
        
        //nhap
        
        if(0<km&&km<=1){
            sotien=km*15000;
        }
        else if(km<=10){
            sotien=tien1+(2500*((km-1)/(float)0.2));
        }
        else if(km>10){
            sotien=tien2+(10000*(km-10));
        }
        else{
            sotien=0;
        }
        System.out.println("So tien la:"+sotien);
    }
    
}
