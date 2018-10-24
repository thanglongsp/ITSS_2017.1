import java.util.ArrayList;
import java.util.List;

public class HePT2 implements DetCal {
//    private double a,b,c,d,e,f;
    @Override
    public double DetXCal(double b, double c, double e, double f) {
        return c*e-b*f;
    }

    @Override
    public double DetYCal(double a, double c, double d, double f) {
        return a*f-c*d;
    }

    @Override
    public double DetCal(double a, double b, double d, double e) {
        return a*e-d*b;
    }

    public double[] giaiHe(double a, double b, double c, double d, double e, double f){
        if(DetCal(a,b,d,e) == 0) return null;
        if(DetXCal(b,c,e,f) == 0 && DetXCal(b,c,e,f) == DetYCal(a,c,d,f)) return null;

//        List<Double> result = new ArrayList<>();
        double[] result = new double[]{DetXCal(b,c,e,f)/DetCal(a,b,d,e), DetYCal(a,c,d,f)/DetCal(a,b,d,e)};
        return result;
    }
}
