package app.models;

public class TemperaturaOra {
	private int ora;
	private double temperatura;
	
	public TemperaturaOra(int ora, double temperatura) {
		setOra(ora);
		setTemperatura(temperatura);
	}

	public int getOra() {
		return ora;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	@Override
	public String toString() {
		return "ORA: "+ora+"\nTEMPERATURA: "+temperatura;
	}
	
}
