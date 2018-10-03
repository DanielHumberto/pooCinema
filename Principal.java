package cinema;
import java.util.Scanner;
public class Principal {
	public static Scanner in = new Scanner(System.in);
	public static void main(String args[]) {
		Cinema sala = new Cinema();
		System.out.print("Digite quantas cadeiras terá no cinema: ");
		String qtd = in.nextLine();
		sala.iniciar(Integer.parseInt(qtd));
		String help = "\t============= help =====================\n"+
				  "\tiniciar x: Iniciar com uma quantidade x de cadeiras\n"+
				  "\treservar id fone indice: Reserva uma cadeira na sala\n"+
				  "\tcancelar id: Cansela sua reserva pelo id\n"+
				  "\tshow: Mostra o estado da sala\n"+
				  "\tsair: sai do programa\n"+
				  "\t========================================\n";
		while(true){
			System.out.print("Digite um comando"+
					"(help para ver os comandos): ");
			String comando = in.nextLine();
			if(comando.equals("help")){
				System.out.println(help);
			} else if(comando.equals("sair")){
				System.out.println("\tAté a próxima :)");
				break;
			} else {
				String c[] = comando.split(" ");
				switch(c[0]) {
					case "iniciar":
						sala.iniciar(Integer.parseInt(c[1]));
						break;
					case "reservar":
						if(Integer.parseInt(c[3]) < sala.cadeiras.length) {	
							boolean res = sala.reservar(c[1], c[2], Integer.parseInt(c[3]));
							if(res == true) {
								System.out.println("Reserva feita com sucesso");
							}else {
								if(sala.cadeiras[Integer.parseInt(c[3])] != null) {
									System.out.println("Erro: Cadeira ja está reservada");
								}else {
									System.out.println("Erro: Cliente ja está no cinema");
								}
							}
						}else {
							System.out.println("Índice inválido");
						}
						break;
					case "cancelar":
						boolean res = sala.cancelar(c[1]);
						if(res == true) {
							System.out.println("Cancelado com sucesso");
						}else {
							System.out.println("Cliente não etá no cinema");
						}
						break;
					case "show":
						System.out.println(sala.show());
						break;
					default:
						System.out.println("Comando inválido!");
				}
			}
		}
	}
}
