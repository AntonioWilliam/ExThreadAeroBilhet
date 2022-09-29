package View;

import java.util.concurrent.Semaphore;

import controller.ThreadPistas;

public class Principal {

	public static void main(String[] args) {
		int liberacao =1;
		Semaphore pistaN = new Semaphore(liberacao);
		Semaphore pistaS = new Semaphore(liberacao);
		for (int Aviao=0; Aviao <12 ; Aviao++) {
			Thread decolar = new ThreadPistas(pistaN, pistaS, Aviao);
			decolar.start();
		}
	}

}
