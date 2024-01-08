package leetcode;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>(4);
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        System.out.println("Can visit all rooms : "+canVisitAllRooms(rooms));

    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for(int i=0;i<visited.length;i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        List<Integer> keysInRoom = rooms.get(room);
        visited[room] = true;

        for(Integer i: keysInRoom) {
            if(!visited[i]) {
                dfs(i, rooms, visited);
            }
        }
    }

    /*public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keys = new TreeSet<>();
        Set<Integer> newKeys = new TreeSet<>();
        keys.addAll(rooms.get(0));
        rooms.set(0, null);
        while(!keys.isEmpty()) {
            Iterator<Integer> itr = keys.iterator();
            while (itr.hasNext()) {
                Integer key = itr.next();
                if(rooms.get(key) != null && !rooms.get(key).isEmpty()) {
                    newKeys.addAll(rooms.get(key));
                }
                itr.remove();
                rooms.set(key, new ArrayList<>());
            }
            keys.addAll(newKeys);
            newKeys.removeAll(keys);
        }

        for(List<Integer> room : rooms){
            if(room != null && !room.isEmpty()){
                return false;
            }
        }

        return true;
    }*/
}
