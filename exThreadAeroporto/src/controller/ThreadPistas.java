package controller;

import java.util.concurrent.Semaphore;

public class ThreadPistas extends Thread {
	private int idAviao;
	private Semaphore pistaN;
	private Semaphore pistaS;

	public ThreadPistas( Semaphore pistaN, Semaphore pistaS, int idAviao ) {
		this.idAviao= idAviao;
		this.pistaN=pistaN;
		this.pistaN=pistaS;
		
	}
	public void run() {
		if ((idAviao % 2) == 0) {
			try {
				pistaN.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				System.err.println("#Avião:" + idAviao + " entra na pista" + "Norte");
				manobra();
				taxiar();
				decolagem();
				afastamento();
				System.err.println("#Avião" +idAviao+ " se afastou");
				pistaN.release();
			}
	}else if ((idAviao % 2) != 0){
		try {
			pistaS.acquire();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.err.println("#Avião:" + idAviao + " entrou na pista" + "Sul");
			manobra();
			taxiar();
			decolagem();
			afastamento();
			System.err.println("#Avião" +idAviao+ " se afastou");
			pistaS.release();
		}
	}
	}
	private void manobra() {
		//System.out.println("#Avião" +idAviao+ " :está manobando na pista");
	int tempo = (int) (Math.random() * 4001) + 3000;
	try {
		sleep(tempo);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		
	}
	private void taxiar() {
		//System.out.println("#Avião" +idAviao+ " :está taxiando");
		int tempo = (int) (Math.random() * 5001) + 5000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private void decolagem() {
		//System.out.println("#Avião" +idAviao+ " :está decolando");
		int tempo = (int) (Math.random() * 3001) + 1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	private void afastamento() {
		//System.err.println("#Avião" +idAviao+ " se afastou");
		int tempo = (int) (Math.random() * 5001) + 5000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	}
