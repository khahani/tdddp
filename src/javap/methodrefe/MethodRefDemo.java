package javap.methodrefe;

public class MethodRefDemo {

    public static String strOps(StringFunc sf, String s){
        return sf.func(s);
    }


    public static void main(String[] args) {
        String inStr = "Lambda add power to Java";
        String outStr = null;

        outStr = strOps(MyStringOps::strReverse, inStr);

        System.out.println(outStr);
    }
}
