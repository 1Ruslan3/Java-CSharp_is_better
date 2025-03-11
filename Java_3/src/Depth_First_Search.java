import java.util.Arrays;
import static java.lang.Math.max;


public class Depth_First_Search
{
    private int[][] _matrix;
    private Boolean[][] _isVisited = new Boolean[3][3];

    public Depth_First_Search(int[][] matrix)
    {
        _matrix = matrix;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                _isVisited[i][j] = false;
            }
        }
    }
    public int solve()
    {
        int maxv = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                maxv = max(maxv, DFS(cloneArray(_isVisited), 0, i, j));
            }
        }
        return maxv;
    }

    private int DFS(Boolean[][] isVisited, int retval, int i, int j)
    {
        retval = retval * 10 + _matrix[i][j];
        isVisited[i][j] = true;
        int maxretval = retval;
        if (i > 0 && !isVisited[i-1][j])
        {
            maxretval = max(maxretval, DFS(cloneArray(isVisited), retval, i-1, j));
        }
        if (i < 2 && !isVisited[i+1][j])
        {
            maxretval = max(maxretval, DFS(cloneArray(isVisited), retval, i+1, j));
        }
        if (j > 0 && !isVisited[i][j-1])
        {
            maxretval = max(maxretval, DFS(cloneArray(isVisited), retval, i, j-1));
        }
        if (j < 2 && !isVisited[i][j+1])
        {
            maxretval = max(maxretval, DFS(cloneArray(isVisited), retval, i, j+1));
        }
        return maxretval;
    }

    private Boolean[][] cloneArray(Boolean[][] array)
    {
        return Arrays.stream(array).map(a -> Arrays.copyOf(a, a.length)).toArray(Boolean[][]::new);
    }
}
