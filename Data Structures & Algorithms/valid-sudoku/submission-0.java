

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.')
                    continue;

                char num = board[r][c];

                if (!set.add("row" + r + num))
                    return false;

                if (!set.add("col" + c + num))
                    return false;

                int box = (r / 3) * 3 + (c / 3);

                if (!set.add("box" + box + num))
                    return false;
            }
        }

        return true;
    }
}

        
