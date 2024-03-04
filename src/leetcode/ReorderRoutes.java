package leetcode;

public class ReorderRoutes {
    public static int count;
    public static boolean [] isConnected;


    public static void main(String[] args) {
       int n = 6;
       int [][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
       System.out.println(minReorder(n, connections));
    }
    public static int minReorder(int n, int[][] connections) {
        isConnected = new boolean[n];
        isConnected[0] = true;
        count = 0;
        //incoming
            incomingCheck(0, connections);
        //outgoing
            outgoingCheck(0, connections);
        return count;
    }

    private static void outgoingCheck(int node, int[][] connections) {
        for (int i = 0; i < connections.length; i++) {
            if(connections[i][0] == node && !isConnected[connections[i][1]]){
                //mark connected
                isConnected[connections[i][1]] = true;
                //reverse the path
                int temp = connections[i][1];
                connections[i][1] = connections[i][0];
                connections[i][0] = temp;
                count++;
                //recursive calls
                incomingCheck(temp, connections);
                outgoingCheck(temp, connections);
            }
        }
    }

    private static void incomingCheck(int node, int[][] connections) {
        for (int i = 0; i < connections.length; i++) {
            if(connections[i][1] == node && !isConnected[connections[i][0]]){
                isConnected[connections[i][0]] = true;
                //recursive calls
                incomingCheck(connections[i][0], connections);
                outgoingCheck(connections[i][0], connections);
            }
        }
    }
}
