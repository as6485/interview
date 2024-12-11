package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    //my partial solution
    /*public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int result = w;

        if(k==0 || profits.length == 0 || capital.length == 0)
            return 0;

        for(int i = 0; i < capital.length; i++){
            if(capital[i] <= w && profits[i]>0){
                result = w+profits[i];
                profits[i] = 0;
                result = Math.max(result, findMaximizedCapital(k-1, result, profits, capital));
            }
        }
        return result;
    }*/


    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        // Creating list of projects with capital and profits
        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        // Sorting projects by capital required
        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // Max-heap to store profits (using a min-heap with inverted values)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        // Main loop to select up to k projects
        for (int j = 0; j < k; j++) {
            // Add all profitable projects that we can afford
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            // If no projects can be funded, break out of the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Otherwise, take the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }


}
