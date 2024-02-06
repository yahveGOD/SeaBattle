package Classes;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void PlayerTurn(Player player, Field field, Scanner scanner,Player bot)
    {

        int FireX=0;
        int FireY;
        while (true) {
            System.out.println("Ход игрока " + player.Name);
            field.DrawField(player.field);
            field.DrawEnemyField(player.enemyField);
            boolean check = true;
            while (check) {
                System.out.println("Введите координаты для стрельбы.Введите букву");
                String letter = scanner.nextLine();
                switch (letter) {
                    case "A":
                        FireX = 0;
                        check = false;
                        break;
                    case "B":
                        FireX = 1;
                        check = false;
                        break;
                    case "C":
                        FireX = 2;
                        check = false;
                        break;
                    case "D":
                        FireX = 3;
                        check = false;
                        break;
                    case "E":
                        FireX = 4;
                        check = false;
                        break;
                    case "F":
                        FireX = 5;
                        check = false;
                        break;
                    case "G":
                        FireX = 6;
                        check = false;
                        break;
                    case "H":
                        FireX = 7;
                        check = false;
                        break;
                    case "I":
                        FireX = 8;
                        check = false;
                        break;
                    case "J":
                        FireX = 9;
                        check = false;
                        break;
                    case "K":
                        FireX = 10;
                        check = false;
                        break;
                    case "L":
                        FireX = 11;
                        check = false;
                        break;
                    case "M":
                        FireX = 12;
                        check = false;
                        break;
                    case "N":
                        FireX = 13;
                        check = false;
                        break;
                    case "O":
                        FireX = 14;
                        check = false;
                        break;
                    case "P":
                        FireX = 15;
                        check = false;
                        break;
                    default:
                        break;
                }
            }
            while (true) {
                System.out.println("Введите число");
                FireY = scanner.nextInt();
                if (FireY >= 0 && FireY < 16) {
                    break;
                } else {
                    System.out.println("Неверный ввод");
                }
            }
            if (bot.field[FireX][FireY] == 1 && !IsKilled(FireX,FireY,bot)) {
                System.out.println("Попал!");
                player.enemyField[FireX][FireY]=1;
                bot.field[FireX][FireY] = 2;
                continue;
            }
            if (bot.field[FireX][FireY] == 1 && IsKilled(FireX,FireY,bot)){
                System.out.println("Убил!");
                player.enemyField[FireX][FireY]=1;
                bot.field[FireX][FireY] = 2;
                bot.NumberOfShips--;
                continue;
            }
            if (player.enemyField[FireX][FireY] == 2 ||player.enemyField[FireX][FireY] == 1)
            {
                System.out.println("Вы сюда уже стреляли!");
                continue;
            }
            if (bot.field[FireX][FireY] == 0)
            {
                System.out.println("Мимо!");
                player.enemyField[FireX][FireY]=2;
                break;
            }
        }
    }
    public boolean IsKilled(int x,int y,Player bot)
    {
        int counter = 0;
        for (int i = 1; i <6; i++) {
            if (x + i < 16) {
                if (bot.field[x + i][y] == 2) {
                    continue;
                }
                if(bot.field[x + i][y] == 0 || bot.field[x + i][y]==3) {
                    counter++;
                    break;
                }
                if(bot.field[x + i][y] == 1)
                {
                    return false;
                }
            }
            else
            {
                counter++;
                break;
            }
        }
        for (int i = 1; i <6; i++) {
            if (x - i >= 0) {
                if (bot.field[x - i][y] == 2) {
                    continue;
                }
                if(bot.field[x - i][y] == 0|| bot.field[x - i][y]==3) {
                    counter++;
                    break;
                }
                if(bot.field[x - i][y] == 1)
                {
                    return false;
                }
            }
            else
            {
                counter++;
                break;
            }
        }
        for (int i = 1; i <6; i++) {
            if (y + i < 16) {
                if (bot.field[x][y+i] == 2) {
                    continue;
                }
                if(bot.field[x][y+i] == 0|| bot.field[x ][y+i]==3) {
                    counter++;
                    break;
                }
                if(bot.field[x][y+i] == 1)
                {
                    return false;
                }
            }
            else
            {
                counter++;
                break;
            }
        }
        for (int i = 1; i <6; i++)
        {
            if (y-i>=0)
            {
                if (bot.field[x][y-i] == 2) {
                    continue;
                }
                if(bot.field[x][y-i] == 0|| bot.field[x][y-i]==3) {
                    counter++;
                    break;
                }
                if(bot.field[x][y-i] == 1)
                {
                    return false;
                }
            }
            else
            {
                counter++;
                break;
            }
        }
        if(counter ==4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void BotTurn(Player bot,Field field,Player player)
    {
        int FireX=0;
        int FireY=0;

        while (true) {
            Random random = new Random();
            System.out.println("Ход игрока " + bot.Name);
            field.DrawField(player.field);
            field.DrawEnemyField(player.enemyField);
            if (bot.GotThem == false)
            {
                FireX = random.nextInt(16);
                FireY = random.nextInt(16);
            }
            if(bot.GotThem == true)
            {
                while (true) {
                    if(bot.Direction == 4) {
                         bot.Direction = random.nextInt(4);
                    }
                    if (bot.Direction == 0) {
                        if (bot.LastFireY + 1 < 16) {
                            FireX = bot.LastFireX;
                            FireY = bot.LastFireY+1;

                            break;
                        }
                        else
                        {
                            bot.Direction=4;
                            continue;
                        }
                    }
                    if (bot.Direction == 1) {
                        if (bot.LastFireX + 1 < 16 ) {
                            FireX = bot.LastFireX+1;
                            FireY = bot.LastFireY;
                            break;
                        }
                        else
                        {
                            bot.Direction=4;
                            continue;
                        }
                    }
                    if (bot.Direction == 2) {
                        if (bot.LastFireY - 1 >= 0 ) {
                            FireX = bot.LastFireX;
                            FireY = bot.LastFireY-1;
                             break;
                        }
                        else
                        {
                            bot.Direction=4;
                            continue;
                        }
                    }
                    if (bot.Direction == 3) {
                        if (bot.LastFireX - 1 >= 0 ) {
                            FireX = bot.LastFireX-1;
                            FireY = bot.LastFireY;
                            break;
                        }
                        else
                        {
                            bot.Direction=4;
                            continue;
                        }
                    }
                }
            }
            if (player.field[FireX][FireY] == 1 && !IsKilled(FireX,FireY,player)) {
                System.out.println("Попал!");
                bot.enemyField[FireX][FireY]=1;
                player.field[FireX][FireY] = 2;
                bot.GotThem = true;
                bot.LastFireX = FireX;
                bot.LastFireY = FireY;
                continue;
            }
            if (player.field[FireX][FireY] == 1 && IsKilled(FireX,FireY,player)){
                System.out.println("Убил!");
                bot.enemyField[FireX][FireY]=1;
                player.field[FireX][FireY] = 2;
                player.NumberOfShips--;
                bot.GotThem = false;
                bot.Direction=4;
                continue;
            }
            if (bot.enemyField[FireX][FireY] == 2 ||bot.enemyField[FireX][FireY] == 1)
            {
                bot.Direction = 4;
                System.out.println("Вы сюда уже стреляли!");
                continue;
            }
            if (player.field[FireX][FireY] == 0)
            {
                System.out.println("Мимо!");
                bot.Direction = 4;
                bot.enemyField[FireX][FireY]=2;
                player.field[FireX][FireY] = 3;
                break;
            }
        }
    }
}
