class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int row_end = n-1;
        int col_end = n-1;
        int row_start = 0;
        int col_start = 0;
        
        int i = 1;
        
        int signal = 0;
        while(true){
            switch(signal){
                case 0:
                    for(int c = col_start; c <= col_end; c++){
                        result[row_start][c] = i;
                        i++;
                    }
                    row_start++;
                    signal = (signal+1)%4;
                    break;
                case 1:
                    for(int r = row_start; r <= row_end; r++){
                        result[r][col_end] = i;
                        i++;
                    }
                    col_end--;
                    signal = (signal+1)%4;
                    break;
                case 2:
                    for(int c = col_end; c >= col_start; c--){
                        result[row_end][c] = i;
                        i++;
                    }
                    row_end--;
                    signal = (signal+1)%4;
                    break;
                case 3:
                    for(int r = row_end; r >= row_start; r--){
                        result[r][col_start] = i;
                        i++;
                    }
                    col_start++;
                    signal = (signal+1)%4;
                    break;
            }
            if(i > n*n){break;}
        }
        return result;
    }
}