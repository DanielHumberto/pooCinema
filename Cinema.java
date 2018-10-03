package cinema;

public class Cinema {
	public Cliente[] cadeiras;
	
	public boolean reservar(String id, String fone, int indice) {
		boolean r = false;
		if(cadeiras[indice] == null) {
			for(Cliente cadeira : cadeiras){
				if(cadeira == null) {
					r = false;
				}else if(cadeira.id.equals(id)){
					r = true;
					break;
				}
			}
			if(r == true) {
				return false;				
			}else {
				Cliente cli = new Cliente(id,fone);
				cadeiras[indice] = cli;
				return true;
			}
		}else {
			return false;
		}
	}
	public boolean cancelar(String id) {
		for(int i=0; i<cadeiras.length; i++) {
			
		}
		return false;
	}
	public Cliente[] iniciar(int qtd){
		cadeiras = new Cliente[qtd];
		return cadeiras;
	}
	public String show(){
		String res = "[";
		for(Cliente cadeira : cadeiras){
			if(cadeira == null) {
				res += "-";
			}else {
				res += cadeira.id+":"+cadeira.fone;
			}
		}
		res += "]";
		return res;
	}

}
