/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadratic;

/**
 *
 * @author thanglongsp
 */
public class Quadratic {
    public void Quadratic(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        double x1, x2;
        if (delta < 0) {
            System.out.print("PT vo nghiem : \n");
        }
        if (delta == 0) {
            System.out.print("\nPT co nghiem duy nhat : x = " + (-b / (2 * a)));
            System.out.print("\n");
        }
        if (delta > 0) {
            System.out.print("PT co 2 nghiem : ");
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.print("\nx1 = " + x1);
            System.out.print("\nx2 = " + x2);
            System.out.print("\n");
        }
    }
}
