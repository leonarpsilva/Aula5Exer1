package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class EventoController extends Thread{
    public static int quantidadeIngresso;
    public static Semaphore validaSemafaro = new Semaphore(1);
	public EventoController() {
		
	}
	
	public void run() {
		try {
			this.login();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login() throws InterruptedException {
		Random random = new Random();
		int tempLogin = random.nextInt((2000 -50)+ 1) + 50;
		Thread.sleep(tempLogin);
		if(tempLogin > 1000) {
			System.out.println("Impossivel realizar o Login");
			return;
		}
		System.out.println("Realizando Login");
		this.comprar();
	}
	
	public void comprar() throws InterruptedException {
		Random random = new Random();
		int tempCompra = random.nextInt((3000 - 1000)+ 1) + 1000;
		if(tempCompra > 2500) {
		System.out.println("Impossivel realizar a compra");
		return;
		}
		System.out.println("Realizando a compra");
		Random random2 = new Random();
		int ingressos = random2.nextInt((4-1)+1)+1;
		EventoController.validaSemafaro.acquire();
		this.validaCompra(ingressos);
		EventoController.validaSemafaro.release();
	}
	
	public void validaCompra(int ingressos) throws InterruptedException {
		if(EventoController.quantidadeIngresso == 0 || EventoController.quantidadeIngresso < ingressos) {
			System.out.println("Sem Ingressos Disponiveis");
			return;
		}
	}
}
