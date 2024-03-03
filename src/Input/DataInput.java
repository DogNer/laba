package Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataInput {
    public static Long getLong(){
        Long value = null;
        String s = "";
        while(value == null) {
            try {
                s = getString();
            } catch (IOException e) {
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }

            try {
                value = Long.valueOf(s);
            }catch (NumberFormatException e){
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }
        }
        return value;
    }

    public static Character getChar() {
        Character value = null;
        String s = "";
        while(value == null) {
            try {
                s = getString();
            } catch (IOException e) {
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }
            if (s.length() > 1)
                System.out.println("Неправильний ввід.");
            else value = s.charAt(0);
        }
        return value;
    }

    public static Integer getInt(){
        Integer value = null;
        String s = "";
        while(value == null) {
            try {
                s = getString();
            } catch (IOException e) {
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }

            try {
                value = Integer.valueOf(s);
            }catch (NumberFormatException e){
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }
        }
        return value;
    }

    public int getInt(String s){
        System.out.print(s);
        return getInt();
    }

    public String getString(String s){
        System.out.print(s);
        return getStrings();
    }

    public static Double getDouble(){
        Double value = null;
        String s = "";
        while(value == null) {
            try {
                s = getString();
            } catch (IOException e) {
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }

            try {
                value = Double.valueOf(s);
            }catch (NumberFormatException e){
                System.out.println("Неправильний ввід.");
                //e.printStackTrace();
            }
        }
        return value;
    }

    public static String getStrings(){
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            System.out.println("Неправильний ввід.");
            e.printStackTrace();
        }
        return s;
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
