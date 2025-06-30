package co.dekoderpy.guessthenumber;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class MainController {
    public Label header;
    public TextField userGuess;
    public Label resultDisplay;
    public Label subheader;
    public Label guessCountLabel;
    Random random = new Random();
    int secretNumber = random.nextInt(100);
    int guessCount = 0;

    @FXML
    protected void restart() {
        resultDisplay.setText("");
        guessCount = 0;
        guessCountLabel.setText("");
        secretNumber = random.nextInt(100);
        userGuess.setText("");
    }

    @FXML
    protected void onGuessSubmit() {
        int guess;
        try {
            guess = Integer.parseInt(userGuess.getText().strip());
        } catch (NumberFormatException e) {
            resultDisplay.setText("Please only enter whole numbers.");
            userGuess.setText("");
            return;
        }
        guessCount++;
        if (guessCount != 1) {
            guessCountLabel.setText("You've made " + guessCount + " guesses.");
        } else {
            guessCountLabel.setText("You've made " + guessCount + " guess.");
        }
        if (guess == secretNumber) {
            resultDisplay.setText("You guessed it! The number was " + guess + "!");
        } else if (guess < secretNumber) {
            resultDisplay.setText("The number is bigger than " + guess + ".");
        } else {  // guess > secretNumber
            resultDisplay.setText("The number is smaller than " + guess + ".");
        }
        userGuess.setText("");

    }

}