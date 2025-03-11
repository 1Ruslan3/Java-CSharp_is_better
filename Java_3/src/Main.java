import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите матрицу 3x3:");
            int[][] matrix = new int[3][3];
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    matrix[i][j] = in.nextInt();
                }
            }
            Depth_First_Search dfs = new Depth_First_Search(matrix);
            System.out.println(dfs.solve());
        } catch (Exception exception)
        {
            System.out.println(exception.toString());
        }
    }
}