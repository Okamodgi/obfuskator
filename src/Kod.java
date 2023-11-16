import java.util.Arrays;
import java.util.Scanner;

public class Kod {
    public static void main(String[] args) {






        Scanner in = new Scanner(System.in);
        System.out.print("Длина: ");
        int n = in.nextInt();



        //qwertyuiokjhgfdsdfgbhnj




        int[] mass = new int[n];

        for (int i = 0; i < mass.length; i++){



            mass[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(mass));

        for (int i = 0; i < mass.length - 1; i++){








            for (int j = 0; j < mass.length - i-1; j++){
                if (mass[j]>mass[j+1]){   //sdfghjbytfd4rftgyh
                    int temp = mass[j];



                    mass[j]= mass[j+1];
                    mass[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(mass));
    }
}
