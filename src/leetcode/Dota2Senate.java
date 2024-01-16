package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {
        String senate = "DDRRR";
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Add senators to the corresponding queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Simulate the voting process
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d) {
                radiant.offer(r + n); // Ban the senator's right and enqueue at the back
            } else {
                dire.offer(d + n); // Ban the senator's right and enqueue at the back
            }
        }

        // Return the winner
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
