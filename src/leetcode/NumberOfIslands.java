package leetcode;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int nbrOfIslands = 0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    nbrOfIslands++;
                    searchIslands(i, j, grid);
                }
            }
        }
        return nbrOfIslands;
    }

    private static void searchIslands(int i, int j, char[][] grid){
        //bounds check
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;

        //return if it's a water cell
        if(grid[i][j] == '0')
            return;

        //mark this cell as water 0
        grid[i][j] = '0';

        //recursive checks on adjacent cells
        searchIslands(i-1, j, grid);
        searchIslands(i+1, j, grid);
        searchIslands(i, j-1, grid);
        searchIslands(i, j+1, grid);

    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }

}
