// https://leetcode.com/problems/surrounded-regions/
public class Solution {
    int N,M;
    char[][] b;
    public void solve(char[][] board) {
        b = board;
        int n = board.length;
        int m = board[0].length;
        N = n;
        M = m;
        for(int j=0;j<m; j++)
        {
            dfs(0,j);
        }
        
        for(int i=0;i<n; i++)
        {
            dfs(i,0);
        }
        
         for(int j=0;j<m; j++)
        {
            dfs(n-1, j);
        }
        
         for(int i=0;i<n; i++)
        {
            dfs(i,m-1);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i][j] = (b[i][j] == 'b' )? 'O' : 'X';
            }
        }
        return ;
        
    }
    void dfs(int i, int j){
        if(i == N || j == M || i < 0 || j < 0)
            return;
         if(b[i][j] == 'X')
           return;
        if(b[i][j] == 'b')
           return;
        b[i][j]='b';
        dfs(i,j+1);
        dfs(i,j-1);
        dfs(i+1,j);
        dfs(i-1,j);
    }
}