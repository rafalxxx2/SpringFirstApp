package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameImpl implements IGame {



    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    private INumbergenerator iNumbergenerator;
    private int guessCount = 10;
    private int numebr;
    private int guess;
    private int smallest;
    private int biggest;
    private  int remainingGuesses;
    private  boolean validNumberRange = true;


    // == constructors ==
    public GameImpl(INumbergenerator iNumbergenerator) {
        this.iNumbergenerator = iNumbergenerator;
    }

    // == public methods ==
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = iNumbergenerator.next();
        numebr = iNumbergenerator.next();
        log.debug("the number is {}",numebr);
    }


    @Override
    public int getNumber() {
        return numebr;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
            this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }


    @Override
    public void check() {
        checkValidNumberRenge();

        if (validNumberRange){
            if (guess > numebr){
                biggest = guess -1;
            }
            if (guess < numebr){
                smallest = guess +1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRenge() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == numebr;
    }

    @Override
    public boolean isGameLose() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    // == private methods ==

    private void checkValidNumberRenge(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
