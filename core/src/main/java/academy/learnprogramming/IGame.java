package academy.learnprogramming;

public interface IGame {

    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRenge();

    boolean isGameWon();

    boolean isGameLose();

}
