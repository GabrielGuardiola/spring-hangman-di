package com.gabodev.hangman;

import com.gabodev.hangman.applications.HangmanApplication;
import com.gabodev.hangman.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class HangmanRunner {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HangmanApplication hangmanApplication = context.getBean(HangmanApplication.class);
		hangmanApplication.initialize();
	}
}
