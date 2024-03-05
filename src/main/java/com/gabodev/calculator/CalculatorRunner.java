package com.gabodev.calculator;

import com.gabodev.calculator.applications.CalculatorApplication;
import com.gabodev.calculator.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CalculatorRunner {

	static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CalculatorApplication calculator = context.getBean(CalculatorApplication.class);
		Boolean isRunning = true;
		while(isRunning) {
			System.out.println("Bienvenido a la calculadora, selecciona una operación:");
			System.out.println("1. Sumar");
			System.out.println("2. Restar");
			System.out.println("3. Multiplicar");
			System.out.println("4. Dividir");
			System.out.println("5. Salir");
			System.out.println("Selecciona una operación (Default: 5): ");
			Integer opt = reader.nextInt();
			if(opt == 5){
				System.out.println("Programa terminado!");
				isRunning = false;
				break;
			}
			System.out.println("Introduce el primer operando:");
			Integer a = reader.nextInt();
			System.out.println("Introduce el segundo operando:");
			Integer b = reader.nextInt();

			switch(opt){
				case 1:
					Integer sum = calculator.add(a,b);
					System.out.println("Suma: " + sum);
					break;
				case 2:
					Integer sub = calculator.sub(a,b);
					System.out.println("Resta: " + sub);
					break;
				case 3:
					Integer mul = calculator.multiply(a,b);
					System.out.println("Multiplicación: " + mul);
					break;
				case 4:
					Integer div = calculator.divide(a,b);
					System.out.println("División: " + div);
					break;
			}

		}
	}

}
