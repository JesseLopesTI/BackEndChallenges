package com.br.imposto;

public class InformarImposto {

	public static void main(String[] args) {

		CalcularImposto informar = new CalcularImposto();

		informar.informarDados();
		informar.calcularDependentes();
		informar.calcularInss();
		informar.calcularIrpf();
		informar.imprimirResultado();
	}
}
