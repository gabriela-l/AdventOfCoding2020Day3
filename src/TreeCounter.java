import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeCounter {
    public static int countTrees(ArrayList<String> map, int right, int down) {
        int lengthOfARow = map.get(0).length();
        int countOfTrees = 0;
        // j = index of the starting position (col) and also the number of moves to right
        int j = right;
        // i = index of the starting position (row) and the number of moves down
        for (int i = down; i < map.size(); i+=down) {
            String row = map.get(i);
            // at the end of a row, overflow to the start
            if (j >= lengthOfARow) {
                j = j % lengthOfARow;
            }
            Character character = row.charAt(j);
            if (character.equals('#')) {
                countOfTrees ++;
            }
            j += right;
        }
        return countOfTrees;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> map = new ArrayList<>();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("src/Map.txt")));
        try {
            String row;
            while ((row = br.readLine()) != null) {
                map.add(row);
            }
        } finally {
            br.close();
        }
        int oneone = countTrees(map,1,1);
        int fiveone = countTrees(map,5, 1);
        int threeone = countTrees(map,3, 1);
        int sevenone = countTrees(map,7, 1);
        int onetwo = countTrees(map,1, 2);
        long answer = (long)oneone * fiveone * threeone * sevenone * onetwo;
        System.out.println("Answer for the first part: " + threeone);
        System.out.println("Answer for the second part: " + answer);
    }
}
