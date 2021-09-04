package ru.matveykenya;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
        // сделаем прыжок, если прыжок слишком большой
        // для поля, то не прыгнем и вернём false
        int newPosition = position + steps;
        if (newPosition <= MAX_POSITION && newPosition >= MIN_POSITION){
            position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = MIN_POSITION; i <= MAX_POSITION; i++){
            s.append(i != position ? '-' : 'F');
        }
        return s.toString();
    }
}
