class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int row_end = n-1;                  // the control value to indicate the last row to fill up
        int col_end = n-1;                  // the control value to indicate the last col to fill up
        int row_start = 0;                  // the control value to indicate the first row to fill up
        int col_start = 0;                  // the control value to indicate the first col to fill up
        
        int i = 1;
        
        int signal = 0;                     // signal chanes 0 -> 1 -> 2 -> 3 -> 0 -> and so on
        while(true){
            switch(signal){
                case 0:                     // case 0 : fill up the row in row_start
                    for(int c = col_start; c <= col_end; c++){
                        result[row_start][c] = i;
                        i++;
                    }
                    row_start++;
                    signal = (signal+1)%4;  // renew the signal
                    break;
                case 1:                     // case 1 : fill up the column in col_end
                    for(int r = row_start; r <= row_end; r++){
                        result[r][col_end] = i;
                        i++;
                    }
                    col_end--;
                    signal = (signal+1)%4;  // renew the signal
                    break;
                case 2:                     // case 2 : fill up the row in row_end
                    for(int c = col_end; c >= col_start; c--){
                        result[row_end][c] = i;
                        i++;
                    }
                    row_end--;              
                    signal = (signal+1)%4;  // renew the signal
                    break;
                case 3:                     // case 3: fill up the col in col_start
                    for(int r = row_end; r >= row_start; r--){
                        result[r][col_start] = i;
                        i++;
                    }
                    col_start++;            
                    signal = (signal+1)%4;  // renew the signal
                    break;
            }
            if(i > n*n){break;}             // end condition of while loop (all cell is filled up)
        }
        return result;
    }
}