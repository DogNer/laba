import University.UniversityMenu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UniversityMenu menu = new UniversityMenu();
        menu.runMenu();
    }

    private static void outputAAArr(String[][] arr, int n, int m){
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

