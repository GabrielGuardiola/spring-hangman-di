package com.gabodev.hangman.services;

public interface IGameManagerService {
    public boolean isGameOver();
    public void validatePlayerInputLetter(String letter, String[] currentWord, String[] playerWord);
    public void validatePlayerInputFullWord(String word, String[] currentWord, String[] playerWord);
    public Integer getAttempts();
    public void setCurrentAttemptsToZero();
    public boolean playerWon(String[] currentWord, String[] playerWord);
}
