import java.util.Scanner;  
  
public class Main {  
  
    interface Cloneable{  
        public abstract String toString();  
    }  
    static class Complex implements Cloneable{  
        private double a, b;  
        private double integer, real;  
  
        public Complex(){  
  
        }  
        public Complex(double a, double b){  
            this.a = a;  
            this.b = b;  
        }  
  
        public String add(Complex cpx2){  
            integer = this.a + cpx2.a;  
            real = this.b + cpx2.b;  
  
            integer *= 10000;  
            real *= 10000;  
            integer = (int)integer;  
            real = (int)real;  
            integer /= 10000;  
            real /= 10000;  
  
            if(integer == 0 && real == 0){  
                return "0";  
            }  
            else if(integer == 0){  
                return String.valueOf(real) + "i";  
            }  
            else if(real == 0){  
                return String.valueOf(integer);  
            }  
            else{  
                if(real < 0){  
                    return String.valueOf(integer) + " - " + String.valueOf((Math.abs(real)) + "i");  
                }  
                else{  
                    return String.valueOf(integer) + " + " + String.valueOf(real) + "i";  
                }  
            }  
        }  
  
        public String substract(Complex cpx2){  
            integer = this.a - cpx2.a;  
            real = this.b - cpx2.b;  
  
            integer *= 10000;  
            real *= 10000;  
            integer = (int)integer;  
            real = (int)real;  
            integer /= 10000;  
            real /= 10000;  
  
  
            if(integer == 0 && real == 0){  
                return "0";  
            }  
            else if(integer == 0){  
                return String.valueOf(real) + "i";  
            }  
            else if(real == 0){  
                return String.valueOf(integer);  
            }  
            else{  
                if(real < 0){  
                    return String.valueOf(integer) + " - " + String.valueOf((Math.abs(real)) + "i");  
                }  
                else{  
                    return String.valueOf(integer) + " + " + String.valueOf(real) + "i";  
                }  
            }  
        }  
  
        public String multiply(Complex cpx2){  
            integer = (this.a * cpx2.a - this.b * cpx2.b);  
            real = (this.b * cpx2.a + this.a * cpx2.b);  
  
            integer *= 10000;  
            real *= 10000;  
            integer = (int)integer;  
            real = (int)real;  
            integer /= 10000;  
            real /= 10000;  
  
            if(integer == 0 && real == 0){  
                return "0";  
            }  
            else if(integer == 0){  
                return String.valueOf(real) + "i";  
            }  
            else if(real == 0){  
                return String.valueOf(integer);  
            }  
            else{  
                if(real < 0){  
                    return String.valueOf(integer) + " - " + String.valueOf((Math.abs(real)) + "i");  
                }  
                else{  
                    return String.valueOf(integer) + " + " + String.valueOf(real) + "i";  
                }  
            }  
        }  
  
        public String divide(Complex cpx2){  
            integer = (this.a * cpx2.a + this.b * cpx2.b)/(cpx2.a * cpx2.a + cpx2.b * cpx2.b);  
            real = (this.b * cpx2.a - this.a * cpx2.b)/(cpx2.a * cpx2.a + cpx2.b * cpx2.b);  
  
            integer *= 10000;  
            real *= 10000;  
            integer = (int)integer;  
            real = (int)real;  
            integer /= 10000;  
            real /= 10000;  
  
            if(integer == 0 && real == 0){  
                return "0";  
            }  
            else if(integer == 0){  
                return String.valueOf(real) + "i";  
            }  
            else if(real == 0){  
                return String.valueOf(integer);  
            }  
            else{  
                if(real < 0){  
                    return String.valueOf(integer) + " - " + String.valueOf((Math.abs(real)) + "i");  
                }  
                else{  
                    return String.valueOf(integer) + " + " + String.valueOf(real) + "i";  
                }  
            }  
        }  
  
        public String abs(){  
            double ans = Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));  
  
            ans *= 10000;  
            ans = (int)ans;  
            ans /= 10000;  
  
            return String.valueOf(ans);  
        }  
  
        public String toString(){  
            double tmpa = a, tmpb = b;  
            tmpa *= 10000;  
            tmpa = (int)tmpa;  
            tmpa /= 10000;  
  
            tmpb *= 10000;  
            tmpb = (int)tmpb;  
            tmpb /= 10000;  
  
            String as = String.valueOf(tmpa);  
  
            if(tmpb < 0){  
                String bs = String.valueOf(Math.abs(tmpb));  
                return "(" + as + " - " + bs + "i)";  
            }  
            else{  
                String bs = String.valueOf(tmpb);  
                return "(" + as + " + " + bs + "i)";  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  
        double[] num = new double[4];  
        boolean flag = false;  
  
        while(input.hasNextDouble()){  
            for(int i = 0; i < 4; i++){  
                num[i] = input.nextDouble();  
            }  
  
            Complex cpx1 = new Complex(num[0], num[1]);  
            Complex cpx2 = new Complex(num[2], num[3]);  
  
            if(flag){  
                System.out.println();  
            }  
  
            System.out.println(cpx1.toString() + " + " + cpx2.toString() + " = " + cpx1.add(cpx2));  
            System.out.println(cpx1.toString() + " - " + cpx2.toString() + " = " + cpx1.substract(cpx2));  
            System.out.println(cpx1.toString() + " * " + cpx2.toString() + " = " + cpx1.multiply(cpx2));  
            System.out.println(cpx1.toString() + " / " + cpx2.toString() + " = " + cpx1.divide(cpx2));  
  
            double tmpa = cpx1.a, tmpb = cpx1.b;  
            tmpa *= 10000;  
            tmpa = (int)tmpa;  
            tmpa /= 10000;  
            tmpb *= 10000;  
            tmpb = (int)tmpb;  
            tmpb /= 10000;  
  
            if(cpx1.b < 0){  
                System.out.println("|" + tmpa + " - " + Math.abs(tmpb) + "i| = " + cpx1.abs());  
            }  
            else{  
                System.out.println("|" + tmpa + " + " + Math.abs(tmpb) + "i| = " + cpx1.abs());  
            }  
  
            flag = true;  
        }  
    }  
}  