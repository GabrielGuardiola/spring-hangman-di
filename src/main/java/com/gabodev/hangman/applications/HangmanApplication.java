package com.gabodev.hangman.applications;

import com.gabodev.hangman.repositories.IHangmanRepository;
import com.gabodev.hangman.services.IGameManagerService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Component
public class HangmanApplication {

    private final IGameManagerService gameManagerService;
    private final IHangmanRepository hangmanRepository;
    private final Scanner reader;
    public HangmanApplication(IGameManagerService gameManagerService, IHangmanRepository hangmanRepository) {
        this.gameManagerService = gameManagerService;
        this.hangmanRepository = hangmanRepository;
        this.reader = new Scanner(System.in);
    }
    public void initialize() {
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("Bievenido al ahorcado!!");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            System.out.println("Selecciona una opción: ");
            int opt = reader.nextInt();
            switch(opt){
                case 1:
                    this.startRound();
                    break;
                case 2:
                    System.out.println("Programa terminado!");
                    isRunning = false;
                    break;
            }
        }
    }
    public void startRound(){
        this.selectNewRandomWord();
        while(!this.isGameOver() && !this.playerWon()) {
            //System.out.println("DEBUG: "+ Arrays.toString(this.DEBUG_getWord()));
            System.out.println("Palabra: " + Arrays.toString(this.getPlayerWord()));
            System.out.println("Intentos: " + this.getAttempts());
            System.out.println("Introduce una letra: ");
            String letter = reader.next();
            this.validatePlayerInput(letter);
            if(this.playerWon()) {
                System.out.println("HAS GANADO CAMPEÓN!!!");
                break;
            }
            if(this.isGameOver()) {
                System.out.println("HAS PERDIDO!");
                break;
            }
        }
    }
    public void selectNewRandomWord() {hangmanRepository.selectNewRandomWord();}
    public boolean isGameOver() {return gameManagerService.isGameOver();}
    public boolean playerWon() { return gameManagerService.playerWon(hangmanRepository.getCurrentWord(), hangmanRepository.getPlayerWord());}
    public String[] getPlayerWord() {return hangmanRepository.getPlayerWord();}
    public Integer getAttempts() {return gameManagerService.getAttempts();}
    public String[] DEBUG_getWord() {return hangmanRepository.getCurrentWord();}
    public void validatePlayerInput(String input){
        if(input.length() > 1)          gameManagerService.validatePlayerInputFullWord(input, hangmanRepository.getCurrentWord(), hangmanRepository.getPlayerWord());
        else if(input.length() == 1)    gameManagerService.validatePlayerInputLetter(input, hangmanRepository.getCurrentWord(), hangmanRepository.getPlayerWord());
    }

}
