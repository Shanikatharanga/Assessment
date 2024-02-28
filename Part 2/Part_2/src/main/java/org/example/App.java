package org.example;

public class App 
{
    private int x, y;
    private char direction;

    public App(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void executeCommands(String commands, int width, int height) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    rotateLeft();
                    break;
                case 'R':
                    rotateRight();
                    break;
                case 'F':
                    moveForward(width, height);
                    break;
            }
        }
    }

    public String getPosition() {
        return x + " " + y;
    }

    private void rotateLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    private void rotateRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    private void moveForward(int width, int height) {
        switch (direction) {
            case 'N':
                if (y < height - 1) y++;
                break;
            case 'E':
                if (x < width - 1) x++;
                break;
            case 'S':
                if (y > 0) y--;
                break;
            case 'W':
                if (x > 0) x--;
                break;
        }
    }
}
