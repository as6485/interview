package leetcode;

import java.util.Arrays;

public class SpellsAndPotions {
    public static void main(String[] args) {
        int[] spells = new int[] {3,1,2};
        int[] potions = new int[] {8,5,8};
        long success = 16;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }

    private static int valid_pos(int[] potions, long success, int spell) {
        long potion_needed = (success + spell - 1) / spell;
        int l = 0, r = potions.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] >= potion_needed)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            res[i] = potions.length - valid_pos(potions, success, spells[i]);
        }
        return res;
    }
}
