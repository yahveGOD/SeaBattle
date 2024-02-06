import Classes.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        SinglePlayer singlePlayer = new SinglePlayer();
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        player.Name = scanner.nextLine();
        System.out.println("Выберите режим игры: Одиночная или Мультиплеер(1 или 2)");
        int gameType = scanner.nextInt();
        if (gameType ==1)
        {
            int autocheck;
            while (true) {
                System.out.println("Хотите автоматически расоложить корабли?(1 - да , 2 - нет)");
                autocheck =scanner.nextInt();
                if (autocheck ==1)
                {
                    break;
                }
                else if(autocheck==2)
                {
                    break;
                }

            }
            Player bot = new Player();
            Field botField = new Field();
            if(autocheck ==2) {
                PlaceShips(field, player, scanner);
            }
            if(autocheck ==1) {
                BotPlaceShips(player,field);
            }
            BotPlaceShips(bot,botField);
            singlePlayer.Start(player,field,scanner,bot);
        }
    }
        public static void BotPlaceShips(Player bot,Field field)
        {
            Random random = new Random();
            int deck = 6;
            int counter=1;
            while (deck >=1){
                if(deck ==5)
                {counter = 2;}
                if(deck ==4)
                {counter = 3;}
                if(deck ==3)
                {counter = 4;}
                if(deck ==2)
                {counter = 5;}
                if(deck ==1)
                {counter = 6;}
                while (counter>0) {
                    boolean check = true;
                    while (check == true) {
                        Boat six_boat = new Boat();
                        six_boat.y = random.nextInt(16);
                        six_boat.x = random.nextInt(16);
                        six_boat.direction = random.nextInt(2)+1;
                        if(six_boat.direction == 2 &&(six_boat.y+deck>=16))
                        {
                            continue;
                        }
                        if (six_boat.direction == 1 &&(six_boat.x+deck>=16))
                        {

                            continue;
                        }
                        if (IsShipCrossed(deck,bot, six_boat.direction,six_boat.x, six_boat.y) && IsShipNear(deck, six_boat.direction, six_boat.x, six_boat.y,bot)) {
                            for (int i = 0; i < deck; i++) {
                                if (six_boat.direction == 1) {
                                    bot.field[six_boat.x + i][six_boat.y] = 1;
                                }
                                if (six_boat.direction == 2) {
                                    bot.field[six_boat.x][six_boat.y + i] = 1;
                                }
                            }
                            check = false;
                        }
                    }
                    counter--;
                }
                deck--;
            }
        }
        public static boolean IsShipNear(int deck,int rotation,int x,int y,Player player) {
                for (int i = 0; i < deck; i++) {
                    int xi = 0;
                    int yi = 0;
                    if (rotation == 1) {
                        xi = i;
                    } else {
                        yi = i;
                    }
                    if (x - 1 >= 0 && y+1 < 16) {
                        if (player.field[x - 1][y + 1] != 0) {
                            return false;
                        }
                    }
                    if (x + 1 < 16 && y+1 < 16) {
                        if (player.field[x + 1][y + 1] != 0) {
                            return false;
                        }
                    }
                    if (x - 1 >= 0 && y-1>=0) {
                        if (player.field[x - 1][y - 1] != 0) {
                            return false;
                        }
                    }
                    if (x + 1 < 16 && y-1>=0) {
                        if (player.field[x + 1][y - 1] != 0) {
                            return false;
                        }
                    }
                    if (x + 1 + xi < 16 && x + 1 + xi >= 0 ) {
                        if (player.field[x + 1 + xi][y + yi] != 0) {
                            return false;
                        }
                    }
                    if (x - 1 + xi < 16 && x - 1 + xi >= 0) {
                        if (player.field[x - 1 + xi][y + yi] != 0) {
                            return false;
                        }
                    }
                    if (y + 1 + yi < 16 && y + 1 + yi >= 0 ) {
                        if (player.field[x + xi][y + 1 + yi] != 0) {
                            return false;
                        }
                    }
                    if (y - 1 + yi < 16 && y - 1 + yi >= 0) {
                        if (player.field[x + xi][y - 1 + yi] != 0) {
                            return false;
                        }
                    }
                }
                return true;
        }
        public static boolean IsShipCrossed(int deck,Player player,int rotation,int x,int y)
        {
                for (int i = 0; i < deck; i++) {
                    if(rotation == 1)
                    {
                        if(player.field[x + i][y]==1)
                        {
                            return false;
                        }
                    }
                    if (rotation ==2)
                    {
                        if(player.field[x][y+i]==1)
                        {
                            return false;
                        }
                    }
                }
            return true;
        }
        public static void PlaceShips(Field field,Player player,Scanner scanner)
        {
            int deck = 6;
            int counter=1;
            String Letter = "";
            while (deck >=1){
                if(deck ==5)
                {counter = 2;}
                if(deck ==4)
                {counter = 3;}
                if(deck ==3)
                {counter = 4;}
                if(deck ==2)
                {counter = 5;}
                if(deck ==1)
                {counter = 6;}
                while (counter>0) {
                    boolean check = true;
                    while (check == true) {
                        System.out.println("Разместите " + deck + " палубный корабль.Введите координаты носа коробля");
                        field.DrawField(player.field);
                        System.out.println("Введите Букву");
                        Boat six_boat = new Boat();
                        Letter = scanner.next();
                        switch (Letter) {
                            case "A":
                                six_boat.x = 0;
                                check = false;
                                break;
                            case "B":
                                six_boat.x = 1;
                                check = false;
                                break;
                            case "C":
                                six_boat.x = 2;
                                check = false;
                                break;
                            case "D":
                                six_boat.x = 3;
                                check = false;
                                break;
                            case "E":
                                six_boat.x = 4;
                                check = false;
                                break;
                            case "F":
                                six_boat.x = 5;
                                check = false;
                                break;
                            case "G":
                                six_boat.x = 6;
                                check = false;
                                break;
                            case "H":
                                six_boat.x = 7;
                                check = false;
                                break;
                            case "I":
                                six_boat.x = 8;
                                check = false;
                                break;
                            case "J":
                                six_boat.x = 9;
                                check = false;
                                break;
                            case "K":
                                six_boat.x = 10;
                                check = false;
                                break;
                            case "L":
                                six_boat.x = 11;
                                check = false;
                                break;
                            case "M":
                                six_boat.x = 12;
                                check = false;
                                break;
                            case "N":
                                six_boat.x = 13;
                                check = false;
                                break;
                            case "O":
                                six_boat.x = 14;
                                check = false;
                                break;
                            case "P":
                                six_boat.x = 15;
                                check = false;
                                break;
                            default:
                                break;
                        }
                        if (check)
                        {
                            System.out.println("Неверное значение буквы");
                            continue;
                        }
                        System.out.println("Введите число");
                        six_boat.y = scanner.nextInt();
                        if(six_boat.y<0 || six_boat.y>=16)
                        {
                            System.out.println("Неверное значение числа");
                            check = true;
                            continue;
                        }
                        System.out.println("Как разместить корабль?(1 - горизонтально(Корабль будет расположен вправо от носа),2 - вертикально(Корабль будет расположен вниз от носа))");
                        six_boat.direction = scanner.nextInt();
                        if(six_boat.direction == 2 &&(six_boat.y+deck>=16))
                        {
                            System.out.println("Корабль выходит за пределы поля!");
                            check=true;
                            continue;
                        }
                        if (six_boat.direction == 1 &&(six_boat.x+deck>=16))
                        {
                            System.out.println("Корабль выходит за пределы поля!");
                            check=true;
                            continue;
                        }
                        if ((six_boat.direction == 1 || six_boat.direction == 2) && IsShipCrossed(deck,player, six_boat.direction,six_boat.x, six_boat.y) && IsShipNear(deck, six_boat.direction, six_boat.x, six_boat.y,player)) {
                            for (int i = 0; i < deck; i++) {
                                if (six_boat.direction == 1) {
                                    player.field[six_boat.x + i][six_boat.y] = 1;
                                }
                                else if (six_boat.direction == 2) {
                                    player.field[six_boat.x][six_boat.y + i] = 1;
                                }
                                else
                                {
                                    System.out.println("Корабль выходит за пределы поля!");
                                    check=true;
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Неверный ввод");
                            check = true;
                        }

                    }
                    counter--;
                }
                deck--;
            }
        }
    }