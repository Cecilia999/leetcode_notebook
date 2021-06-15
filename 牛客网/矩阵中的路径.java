import java.util.*;


public class Solution {
    
    private int rows;
    private int cols;
    private boolean[][] visited;
    
    public boolean hasPath (char[][] matrix, String word) {
        rows = matrix.length;
        cols=matrix[0].length;
        
        //visisted的作用是每一次找到第一个字母正确的时候去dfs路径的时候，
        //用来判断已经visit过的index
        visited = new boolean[rows][cols];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++)
                if(matrix[i][j]==word.charAt(0))
                    //必须checkpath==true就马上返回，如果是用一个variable存的话会覆盖
                    if(checkPath(i, j, matrix, word, 0))
                        return true;
        }
        
        return false;
    }
    
    private boolean checkPath(int i, int j, char[][] matrix, String word, int cur){
        if(i<0 || i>=rows || j<0 || j>=cols || visited[i][j]==true || matrix[i][j]!=word.charAt(cur)){
            return false;
        }
        if(cur == word.length()-1){
            return true;
        }
        
        visited[i][j] = true;
        
        //res判断任意方向有没有path！！！
        boolean res = checkPath(i+1, j, matrix, word, cur+1) ||
        checkPath(i, j+1, matrix, word, cur+1) ||
        checkPath(i-1, j, matrix, word, cur+1) ||
        checkPath(i, j-1, matrix, word, cur+1);
        visited[i][j] = false;
        
        return res;
    }
    
}