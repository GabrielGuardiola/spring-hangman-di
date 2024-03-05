package com.gabodev.hangman.repositories;

public interface IHangmanRepository {

    public String getRandomWord();
    public void selectNewRandomWord();
    public String[] getCurrentWord();
    public String[] getPlayerWord();
    public void setPlayerWord(String[] playerWord);
    public void fillPlayerPlaceholder();

}
