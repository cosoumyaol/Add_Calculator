
public class Operation {
    private double input1;
    private double input2;
    private double output;


    public double addition(double p,double q) {
        input1=p;
        input2=q;
        output = input1+input2;
        return output;
    }
    public double substraction(double p,double q) {
        input1=p;
        input2=q;
        output = input1-input2;
        return output;
    }
    public double multiplication(double p,double q) {
        input1=p;
        input2=q;
        output = input1 * input2;
        return output;
    }
    public double division(double p,double q) {
        input1=p;
        input2=q;
        output = input1 / input2;
        return output;
    }

}