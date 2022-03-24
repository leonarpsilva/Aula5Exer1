package view;

import controller.EventoController;

public class Main {

	public static void main(String[] args) {
		for(int i = 0; i<300; i++) {
			new EventoController().start();
		}				

	}

}
