package HW3;
// Реализовать волновой алгоритм

import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        int startI = 1;
        int startJ = 1;
        int[][] lab = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, -1, 00, -1, -1, -1, -1, -1, -1, 00, -1},
                {-1, 00, -1, 00, 00, 00, -1, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, -1, 00, -1, -1, -1, -1},
                {-1, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, -1},
                {-1, 00, 00, 00, -1, 00, 00, -1, 00, -1, 00, -1},
                {-1, 00, -1, -1, -1, 00, 00, 00, 00, -1, -1, -1},
                {-1, 00, 00, -1, -1, 00, -1, 00, 00, 00, 00, -1},
                {-1, -1, 00, -1, 00, 00, 00, -1, 00, -1, 00, -1},
                {-1, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        tour(startI, startJ, lab);
        printArray(lab);

        int finishI = 10;
        int finishJ = 10;
        drawShortestPath(startI, startJ, finishI, finishJ, lab);
        System.out.println();
        printArray(lab);
    }

    public record Coordinates(int i, int j) { }

// possible directions
    static Coordinates[] steps = {new Coordinates(+1, 0), new Coordinates(-1, 0), new Coordinates(0, +1), new Coordinates(0, -1)};

    public static void tour(int startI, int startJ, int[][] lab) {
        Stack<Coordinates> stack = new Stack();
        stack.push(new Coordinates(startI, startJ));
        lab[startI][startJ] = 1;
        while (!stack.empty()) {
            Coordinates last = stack.peek();
            boolean isStep = false; // free step is not found
            for (Coordinates step : steps) {
                int newI = last.i + step.i;
                int newJ = last.j + step.j;
                if (lab[newI][newJ] != -1) {
                    if (lab[newI][newJ] == 0) {
                        lab[newI][newJ] = lab[last.i][last.j] + 1;
                        stack.push(new Coordinates(newI, newJ));
                        isStep = true;
                        break;
                    } else {
                        // if new path is shorter than existing one, then path length will be updated
                        if (lab[last.i][last.j] + 1 < lab[newI][newJ]) {
                            lab[newI][newJ] = lab[last.i][last.j] + 1;
                            stack.push(new Coordinates(newI, newJ));
                            isStep = true;
                            break;
                        }
                    }
                }
            }
            if (!isStep) {
                stack.pop();
            }
        }
    }

    public static void printArray(int[][] lab) {
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == -1) {
                    System.out.print('▓' + "\t");
                } else if (lab[i][j] == -2) {
                    System.out.print('╳' + "\t");
                } else {
                    System.out.print(lab[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
    public  static void drawShortestPath(int startI, int startJ, int finishI, int finishJ, int[][] lab) {
        Stack<Coordinates> path = new Stack();
        Coordinates current = new Coordinates(finishI, finishJ);
        path.push(current);
        while (!(current.i == startI && current.j == startJ)) {
            for (Coordinates step : steps) {
                int newI = current.i + step.i;
                int newJ = current.j + step.j;
                if (lab[newI][newJ] == lab[current.i][current.j] - 1) {
                    current = new Coordinates(newI, newJ);
                    path.push(current);

                }
            }
        }
        while (!path.empty()) {
            Coordinates top = path.pop();
            lab[top.i][top.j] = -2;
        }
    }
}




