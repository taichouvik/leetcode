public class Solution {
    //https://leetcode.com/problems/number-of-islands/
    //simple do a lot of dfs at every vertex to find connected components
    //amortized O(m*n)
    int n = 0;
    int m = 0;
    char[][] g;
    public int numIslands(char[][] grid) {
        g = grid;
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        for(int i=0; i< n;i++){
            for(int j =0;j<m;j++){
                ans +=dfs(i,j);
            }
        }
        
            return ans;
    }
    int dfs(int i, int j){
        if(i==n || i<0 || j < 0 || j == m)
            return 0;
        if(g[i][j] == '0')
            return 0;
        g[i][j] = '0';
        dfs(i,j+1);
        dfs(i,j-1);
        dfs(i+1,j);
        dfs(i-1,j);
        return 1;
    }
}