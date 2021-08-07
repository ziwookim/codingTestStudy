import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public String solution7(String str) {
        String result = "NO";

        str = str.toUpperCase();

        int lt = 0, rt = str.length() - 1;
        boolean palindrome = true;

        // while solution
        while(lt < rt) {
            if(str.charAt(lt) != str.charAt(rt)) {
                palindrome = false;
                break;
            } else{
                lt++;
                rt--;
            }
        }

        // for solution
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(lt+i) != str.charAt(rt-i)) {
                palindrome = false;
                break;
            }
        }

        if(palindrome) result = "YES";

        return result;

        /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.print(T.solution7(str));
         */
    }

    public String solution8(String str) {
        String result = "YES";

        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        int lt = 0, rt = str.length() - 1;

        while(lt < rt) {
            if(str.charAt(lt) != str.charAt(rt)) {
                return "NO";
            } else if(str.charAt(lt) == str.charAt(rt)){
                lt++;
                rt--;
            }
        }

        return result;

        /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution8(str));
         */
    }

    public int solution9(String str) {
        int result = 0;

        str = str.replaceAll("[^0-9]", "");

        result = Integer.parseInt(str);

        return result;

        /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.print(T.solution9(str));
         */
    }

    public ArrayList<Integer> solution10(String str, char t) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == t) arr.add(i);
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<str.length(); i++) {
           result.add(Math.abs(i-arr.get(0)));
        }

        for(int i=1; i<arr.size(); i++) {
            for(int j=0; j<str.length(); j++) {
                if(result.get(j) > (Math.abs(j-arr.get(i))))
                    result.set(j, Math.abs(j-arr.get(i)));
            }
        }
        return result;

        /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);

        ArrayList<Integer> result = T.solution10(s, t);

        for(int i=0; i<result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
         */
    }

    public String solution11(String str) {
        int cnt = 1;
        char tmp = str.charAt(0);

        String result = "";

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == tmp) {
                cnt++;
            } else{
                if(cnt > 1) {
                    result += String.valueOf(tmp) + cnt;
                    cnt = 1;
                    tmp = str.charAt(i);
                } else{
                    result += String.valueOf(str.charAt(i-1));
                    cnt = 1;
                    tmp = str.charAt(i);
                }
            }
        }

        if(cnt == 1) result += String.valueOf(tmp);
        else result += String.valueOf(tmp) + cnt;

        return result;

        /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.print(T.solution11(str));
         */
    }

    public String solution12(String password) {
        String result = "";

        password = password.replace('#', '1').replace('*','0');

        int len = password.length()/7;
        int k=0;

        for(int i=0; i<len; i++) {
            int tmp = 0;
            int digitNo = 1;
            for(int j=6; j>=0; j--) {
                tmp += digitNo * Integer.parseInt(String.valueOf(password.charAt(7*i+j)));
                digitNo *= 2;
            }
            result += String.valueOf((char)tmp);
        }

        return result;

         /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int spellCnt = Integer.parseInt(sc.next());
        String password = sc.next();

        System.out.print(T.solution12(password));
          */
    }

    public ArrayList<Integer> solution13(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(arr.get(0));
        int tmp = arr.get(0);

        for(int i=1; i<arr.size(); i++) {
            tmp = arr.get(i-1);
            if(arr.get(i) > tmp) result.add(arr.get(i));
        }
        return result;

        /* ******** main
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<tc; i++) {
           arr.add(sc.nextInt());
        }

        ArrayList<Integer> result = T.solution13(arr);
        for(int i=0; i<result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        */
    }

    public int solution14(ArrayList<Integer> arr) {
        int cnt = 1;

        int k=0;
        for(int i=1; i<arr.size(); i++) {
            boolean isVisible = false;
            for(int j=0; j<i-1; j++) {
                if(arr.get(i) > arr.get(j)) {
                    isVisible = true;
                }
                else {
                    System.out.println(arr.get(i));
                    isVisible = false;
                    break;
                }
            }
            if(isVisible) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<tc; i++) {
           arr.add(sc.nextInt());
        }

        System.out.print(T.solution14(arr));

    }
}
