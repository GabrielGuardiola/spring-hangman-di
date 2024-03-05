package com.gabodev.hangman.services;
import org.springframework.stereotype.Service;
@Service
public class GameManagerService implements IGameManagerService {
    private final Integer MAX_ATTEMPTS = 8;
    private Integer currentAttempts = 0;

    @Override
    public boolean isGameOver() {
        if(MAX_ATTEMPTS.equals(currentAttempts)) {
            setCurrentAttemptsToZero();
            return true;
        } else return false;
    }
    public boolean playerWon(String[] currentWord, String[] playerWord) {
        boolean sameWord = false;
        for (int i = 0; i < currentWord.length; i++) {
            if (currentWord[i].equals(playerWord[i])) sameWord = true;
            else return false;
        }
        if(sameWord) setCurrentAttemptsToZero();
        return sameWord;
    }
    @Override
    public void validatePlayerInputLetter(String letter, String[] currentWord, String[] playerWord) {
        boolean isInWord = false;
        for (int i = 0; i < currentWord.length; i++) {
            if (currentWord[i].equals(letter)) {
                playerWord[i] = letter;
                isInWord = true;
            }
        }
        if (!isInWord) currentAttempts++;
    }

    @Override
    public void validatePlayerInputFullWord(String word, String[] currentWord, String[] playerWord) {
        if (word.equals(String.join("", currentWord))) {
            for (int i = 0; i < currentWord.length; i++) playerWord[i] = currentWord[i];
        } else currentAttempts++;
    }
    @Override
    public Integer getAttempts() {return MAX_ATTEMPTS - currentAttempts;}
    public void setCurrentAttemptsToZero() {currentAttempts = 0;}

}
