class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0]==1) return -1;
        // get the number of rows and columns in $grid
        int N = grid.length;
        Deque<int[]> coord_step_q = new ArrayDeque<>();
        coord_step_q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;
        // define the eight directions
        int[][] directions = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        // perform BFS until the queue is empty
        while (!coord_step_q.isEmpty()) {
            int [] coord_step = coord_step_q.pollFirst();
            int row = coord_step[0];
            int col = coord_step[1];
            int step = coord_step[2];
            // if the bottom right corner has been reached, return the number of steps    
            if (row==N-1 && col==N-1) return step;
            for (int[] d: directions) {
                // all conditions of indeces and its cell value must be fulfilled
                int new_row = row+d[0];
                int new_col = col+d[1];
                if (new_row>=0 && new_row<N && new_col>=0 && new_col<N && grid[new_row][new_col]==0) {
                    coord_step_q.addLast(new int[] {new_row, new_col, step+1});
                    grid[new_row][new_col] = 1;
                }
            }   
        }
        // if all the attempts fail, there would be no available route
        return -1;
    }
}
