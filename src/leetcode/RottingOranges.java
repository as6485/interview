package leetcode;

import java.util.Arrays;
import java.util.List;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1}, {0,1,1}, {1,0,1}};
        System.out.println("Minutes : "+orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int rotten = 2;
        int minute = 0;
        int [][] visited = new int[grid.length][grid[0].length];
        minute = dfs(grid, visited, minute, rotten);

        //check all fresh oranges are visited
        List<Integer> flatIntArr = Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .toList();
        if(flatIntArr.contains(1))
            return -1;
        else
            return minute;
    }

    private static int dfs(int[][] grid, int[][] visited, int minute, int rotten) {
        boolean adjRotted = false;
        //loop through grid to find rotten oranges
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] != 1) {
                    if (grid[i][j] == 0) {
                        visited[i][j] = 1;
                    }
                    //rotten orange found
                    else if (grid[i][j] == rotten) {
                        visited[i][j] = 1;
                        //left
                        if ((j - 1 >= 0) && visited[i][j - 1] != 1 && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = rotten+1;
                            adjRotted=true;
                        }
                        //right
                        if ((j + 1 < grid[i].length) && visited[i][j + 1] != 1 && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = rotten+1;
                            adjRotted=true;
                        }
                        //top
                        if ((i - 1 >= 0) && visited[i - 1][j] != 1 && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = rotten+1;
                            adjRotted=true;
                        }
                        //down
                        if ((i + 1 < grid.length) && visited[i + 1][j] != 1 && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = rotten+1;
                            adjRotted=true;
                        }
                    }
                }
            }
        }
        //check all fresh oranges are visited
        if(adjRotted) {
            minute++;
            rotten++;
            minute = Math.max(minute, dfs(grid, visited, minute, rotten));
        }
        return minute;
    }
}
