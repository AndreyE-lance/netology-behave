package task2;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        int pNew = position + steps;
        if ((pNew <= MAX_POSITION) && (pNew >= MIN_POSITION)) {
            position = pNew;
            return true;
        } else {
            return false;
        }
    }

    //...


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX_POSITION; i++) {
            if (i == position) {
                sb.append("F");
            } else {
                sb.append("*");
            }
        }
        return sb.toString();
    }
}
