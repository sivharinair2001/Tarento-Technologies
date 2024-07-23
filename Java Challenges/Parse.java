public class Parse {

    public static void main(String[] args) {

        String str = "25000";
        System.out.println("The given string is : " + str);

        int i = Integer.parseInt(str);
        System.out.println("Converting string to integer : " + i);

        double d = Double.parseDouble(str);
        System.out.println("Converting string to double : " + d);

        float f = Float.parseFloat(str);
        System.out.println("Converting string to float :  " + f);

        String s = "true";
        System.out.println("The string : " + s);
        boolean b = Boolean.parseBoolean(s);
        System.out.println("Converting string to boolean : " + b);

        String n = String.valueOf(i);
        System.out.println("Converting int " + i + " back to string : " + n);

        String m = String.valueOf(d);
        System.out.println("Converting double " + d + " back to string : " + m);

        String x = String.valueOf(f);
        System.out.println("Converting float " + f + " back to string : " + x);

        String y = String.valueOf(b);
        System.out.println("Converting boolean " + b + " back to string : " + y);
    }
}
