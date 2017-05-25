package model;

public class Empleado {
	private int noEmpleado;
	private String nombre;
	private int horasTrabajadas;
	private int precioHora;

	public Empleado(int noEmpleado) {
	        this.noEmpleado = noEmpleado;
	    }

	public int getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(int noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(int precioHora) {
		this.precioHora = precioHora;
	}

	@Override
	public String toString() {
		return "PagoEmpleado{" + "noEmpleado=" + noEmpleado + ", nombre=" + nombre + ", horasTrabajadas="
				+ horasTrabajadas + ", precioHora=" + precioHora + '}';
	}
}
