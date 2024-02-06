package Classes;

public class Player {
    public String Name;
    public int [] [] field = new int[16][16];
    public int [] [] enemyField = new int [16][16];
    public int NumberOfShips;
    boolean GotThem;
    int LastFireX;
    int LastFireY;
    int Direction;
}
