package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.BingoGame.BingoGame;
import com.github.zipcodewilmington.casino.games.BingoGame.BingoPlayer;
import com.github.zipcodewilmington.casino.games.ChoHan.ChoHanGame;
import com.github.zipcodewilmington.casino.games.ChoHan.ChoHanPlayer;
import com.github.zipcodewilmington.casino.games.Craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.SimplifiedWar.SimplifiedWarGame;
import com.github.zipcodewilmington.casino.games.SimplifiedWar.SimplifiedWarPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select game".equalsIgnoreCase(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equalsIgnoreCase("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer(casinoAccount));
                    } else if (gameSelectionInput.equalsIgnoreCase("BLACKJACK")) {
                        play(new NumberGuessGame(), new NumberGuessPlayer());
                    } else if (gameSelectionInput.equalsIgnoreCase("CHOHAN")) {
                        play(new ChoHanGame(), new ChoHanPlayer(casinoAccount));
                    } else if (gameSelectionInput.equalsIgnoreCase("WAR")) {
                        play(new SimplifiedWarGame(), new SimplifiedWarPlayer(casinoAccount));
                    } else if (gameSelectionInput.equalsIgnoreCase("CRAPS")) {
                        play(new CrapsGame(), new com.github.zipcodewilmington.casino.games.Craps.CrapsPlayer(casinoAccount));
                    } else if (gameSelectionInput.equalsIgnoreCase("BINGO")) {
                        play(new BingoGame(), new BingoPlayer(casinoAccount));
                    } else {
                        // TODO - implement better exception handling
                        System.out.println(arcadeDashBoardInput + " is an invalid game selection");
//                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    System.out.println("No account found with name of " + accountName + " and password of " + accountPassword);
//                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create account".equalsIgnoreCase(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                if (newAccount != null){
                    casinoAccountManager.registerAccount(newAccount);
                } else {
                    System.out.println("This accounts exists, please try again");
                }
            }
        } while (!"logout".equalsIgnoreCase(arcadeDashBoardInput));
        casinoAccountManager.saveToFile();
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                        .append("\n" +
                                "  ______    __                          __  __                                   ______                       __                     \n" +
                                " /      \\  /  |                        /  |/  |                                 /      \\                     /  |                    \n" +
                                "/$$$$$$  |_$$ |_     ______    ______  $$ |$$/  _______    ______              /$$$$$$  |  ______    _______ $$/  _______    ______  \n" +
                                "$$ \\__$$// $$   |   /      \\  /      \\ $$ |/  |/       \\  /      \\             $$ |  $$/  /      \\  /       |/  |/       \\  /      \\ \n" +
                                "$$      \\$$$$$$/    $$$$$$  |/$$$$$$  |$$ |$$ |$$$$$$$  |/$$$$$$  |            $$ |       $$$$$$  |/$$$$$$$/ $$ |$$$$$$$  |/$$$$$$  |\n" +
                                " $$$$$$  | $$ | __  /    $$ |$$ |  $$/ $$ |$$ |$$ |  $$ |$$ |  $$ |            $$ |   __  /    $$ |$$      \\ $$ |$$ |  $$ |$$ |  $$ |\n" +
                                "/  \\__$$ | $$ |/  |/$$$$$$$ |$$ |      $$ |$$ |$$ |  $$ |$$ \\__$$ |            $$ \\__/  |/$$$$$$$ | $$$$$$  |$$ |$$ |  $$ |$$ \\__$$ |\n" +
                                "$$    $$/  $$  $$/ $$    $$ |$$ |      $$ |$$ |$$ |  $$ |$$    $$ |            $$    $$/ $$    $$ |/     $$/ $$ |$$ |  $$ |$$    $$/ \n" +
                                " $$$$$$/    $$$$/   $$$$$$$/ $$/       $$/ $$/ $$/   $$/  $$$$$$$ |             $$$$$$/   $$$$$$$/ $$$$$$$/  $$/ $$/   $$/  $$$$$$/  \n" +
                                "                                                         /  \\__$$ |                                                                  \n" +
                                "                                                         $$    $$/                                                                   \n" +
                                "                                                          $$$$$$/                                                                    \n")
                .append("\nWelcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create account ], [ select game ], [ logout ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ slots ], [ blackjack ], [ bingo ], [ chohan ], [ craps ], [ war ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
