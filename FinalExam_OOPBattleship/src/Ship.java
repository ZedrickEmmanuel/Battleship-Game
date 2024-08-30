public class Ship {
    private int size;
    private int[] position;
    private boolean[] hit;

    public Ship(int size) {
        this.size = size;
        this.position = new int[size];
        this.hit = new boolean[size];
    }

    public int getSize() {
        return size;
    }

    public void setPosition(int[] position) {
        if (position.length == size) {
            this.position = position;
        }
    }

    public int[] getPosition() {
        return position;
    }

    public boolean isHit(int index) {
        if (index >= 0 && index < size) {
            hit[index] = true;
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        for (boolean h : hit) {
            if (!h) {
                return false;
            }
        }
        return true;
    }
}
