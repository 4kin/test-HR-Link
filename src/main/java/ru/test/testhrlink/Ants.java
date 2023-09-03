package ru.test.testhrlink;

public class Ants {
    public int runAnts(int dimension, int leftPosition, int rightPosition) {
        int result = -1;
        if (leftPosition < rightPosition) {
            // левый стоит с лева
            return Integer.min(leftPosition, dimension - rightPosition) + 1;
        } else {
            // левый стоит с права и будет столкновение
            Ant leftAnt = new Ant();
            leftAnt.setPosition(leftPosition);
            leftAnt.setLeftDirection();
            Ant rightAnt = new Ant();
            rightAnt.setPosition(rightPosition);
            rightAnt.setRightDirection();
            int count = 0;
            while (true) {
                count++;
//                System.out.println(count);
                if (leftAnt.isLeftDirection()) {
                    // левый идет на лево
                    if (leftAnt.isNextPositionExist(rightAnt)) {
                        leftAnt.increasePosition();
                    } else {
                        // столкновение
                        leftAnt.setRightDirection();
                    }
                } else {
                    // левый пошел на право
                    if (leftAnt.getPosition() != dimension) {
                        leftAnt.increasePosition();
                    }
                }


                if (rightAnt.isRightDirection()) {
                    // правый пошел на право
                    if (rightAnt.isNextPositionExist(leftAnt)) {
                        rightAnt.increasePosition();
                    } else {
                        rightAnt.setLeftDirection();
                    }
                } else {
                    // правый пошел на лево
                    if (rightAnt.getPosition() != 0) {
                        rightAnt.increasePosition();
                    }
                }

                if (leftAnt.getPosition() == dimension || rightAnt.getPosition() == 0) {
                    // кто-то оказался на конечной точке
                    return count;
                    // упал
                }

            }
        }
    }
}


class Ant {
    private int position;
    private String direction;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void increasePosition() {
        if (isLeftDirection()) {
            position = position - 1;
        } else {
            position = position + 1;
        }
    }


    public boolean isNextPositionExist(Ant anotherAnt) {
        if (isLeftDirection()) {
            return (position - 1 == anotherAnt.getPosition()) ? false : true;
        } else {
            return (position + 1 == anotherAnt.getPosition()) ? false : true;
        }
    }

    public boolean isLeftDirection() {
        return direction.equals("left");
    }

    public boolean isRightDirection() {
        return direction.equals("right");
    }

    public void setRightDirection() {
        this.direction = "right";
    }

    public void setLeftDirection() {
        this.direction = "left";
    }

}