package Classes;

import java.util.Scanner;

public class SinglePlayer extends Game {
    public void Start(Player player, Field field, Scanner scanner,Player bot)
    {

        System.out.println("Игра началась!");
        player.NumberOfShips = 6;
        bot.NumberOfShips = 6;
        bot.Direction =4;
        while(player.NumberOfShips!=0 || bot.NumberOfShips != 0)
        {
            PlayerTurn(player,field,scanner,bot);
            BotTurn(bot,field,player);
        }
    }
}
