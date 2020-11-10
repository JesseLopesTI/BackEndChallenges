package com.br.imposto;

import java.util.Scanner;

public class CalcularImposto {

	private Double salarioBruto;
	private Integer quantidadeDependentes;
	private Double aliquotaInss;
	private Double deducaoInss;
	private Double valorDependentes;
	private Double deducaoDependentes;
	private Double salarioLiquido;
	private Double aliquotaIrpf;
	private Double deducaoIrpf;
	private Double deducao;
	private Integer despesa;

	public Double getSalarioBruto() {
		return salarioBruto;
	}
	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	public Double getDeducaoDependentes() {
		return deducaoDependentes;
	}
	public void setDeducaoDependentes(Double deducaoDependentes) {
		this.deducaoDependentes = deducaoDependentes;
	}
	public Double getAliquotaInss() {
		return aliquotaInss;
	}
	public void setAliquotaInss(Double aliquotaInss) {
		this.aliquotaInss = aliquotaInss;
	}
	public Double getDeducaoInss() {
		return deducaoInss;
	}
	public void setDeducaoInss(Double deducaoInss) {
		this.deducaoInss = deducaoInss;
	}
	public Integer getQuantidadeDependentes() {
		return quantidadeDependentes;
	}
	public void setQuantidadeDependentes(Integer quantidadeDependentes) {
		this.quantidadeDependentes = quantidadeDependentes;
	}
	public Double getValorDependentes() {
		return valorDependentes;
	}
	public void setValorDependentes(Double valorDependentes) {
		this.valorDependentes = valorDependentes;
	}
	public Double getSalarioLiquido() {
		return salarioLiquido;
	}
	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}
	public Double getAliquotaIrpf() {
		return aliquotaIrpf;
	}
	public void setAliquotaIrpf(Double aliquotaIrpf) {
		this.aliquotaIrpf = aliquotaIrpf;
	}
	public Double getDeducaoIrpf() {
		return deducaoIrpf;
	}
	public void setDeducaoIrpf(Double deducaoIrpf) {
		this.deducaoIrpf = deducaoIrpf;
	}
	public Double getDeducao() {
		return deducao;
	}
	public void setDeducao(Double deducao) {
		this.deducao = deducao;
	}
	public Integer getDespesa() {
		return despesa;
	}
	public void setDespesa(Integer despesa) {
		this.despesa = despesa;
	}

	Scanner input = new Scanner(System.in);

	public void informarDados() {
		System.out.print("Salário Bruto: ");
		salarioBruto = input.nextDouble();

		System.out.print("\nQuantidade de dependentes: ");
		quantidadeDependentes = input.nextInt();

		System.out.print("\nPossui outras despesas?" + "\nDigite 1 (sim) ou 2 (não): ");
		despesa = input.nextInt();

		while (despesa != 1 && despesa != 2) {
			System.out.print("\nDigite 1 (sim) ou 2 (não): ");
			despesa = input.nextInt();
		}

		deducao = 0.0;

		if (despesa == 1) {
			System.out.print("Valor da dedução: ");
			deducao = input.nextDouble();
		} else {
			System.out.print("Valor da dedução: " + deducao);
		}
	}

	public void calcularDependentes() {
		valorDependentes = 179.71;

		if (quantidadeDependentes == 1) {
			System.out.println("\nValor a ser deduzido dos dependentes: R$ " + valorDependentes);
		} else {
			deducaoDependentes = quantidadeDependentes * valorDependentes;
			System.out.println("\nValor a ser deduzido dos dependentes: R$ " + deducaoDependentes);
		}
	}

	public void calcularInss() {
		if (salarioBruto <= 1045.00) {
			System.out.println("\nValor a ser deduzido do INSS: Insento.");
		} else if (salarioBruto > 1045.00 && salarioBruto < 2089.60) {
			aliquotaInss = 9.0 / 100;
			deducaoInss = (aliquotaInss * salarioBruto) - 15.675;
			System.out.println("\nValor a ser deduzido do INSS: R$ " + deducaoInss);
		} else if (salarioBruto > 2089.60 && salarioBruto < 3134.40) {
			aliquotaInss = 12.0 / 100;
			deducaoInss = (aliquotaInss * salarioBruto) - 78.363;
			System.out.println("\nValor a ser deduzido do INSS: R$ " + deducaoInss);
		} else {
			aliquotaInss = 14.0 / 100;
			deducaoInss = (aliquotaInss * salarioBruto) - 141.051;
			System.out.println("\nValor a ser deduzido do INSS: R$ " + deducaoInss);
		}
	}

	public void calcularIrpf() {
		salarioLiquido = (salarioBruto - deducaoDependentes - deducaoInss - deducao);

		if (salarioLiquido <= 1903.98) {
			System.out.println("\nValor a ser deduzido do IRPF: Insento");
		} else if (salarioLiquido > 1903.98 && salarioLiquido < 2826.65) {
			aliquotaIrpf = 7.5 / 100;
			deducaoIrpf = (salarioLiquido * aliquotaIrpf) - 142.80;
			System.out.println("\nValor a ser deduzido do IRPF: R$ " + deducaoIrpf);
		} else if (salarioLiquido > 2826.65 && salarioLiquido < 3751.05) {
			aliquotaIrpf = 15.0 / 100;
			deducaoIrpf = (salarioLiquido * aliquotaIrpf) - 354.80;
			System.out.println("\nValor a ser deduzido do IRPF: R$ " + deducaoIrpf);
		} else if (salarioLiquido > 3751.05 && salarioLiquido < 4664.68) {
			aliquotaIrpf = 22.5 / 100;
			deducaoIrpf = (salarioLiquido * aliquotaIrpf) - 636.13;
			System.out.println("\nValor a ser deduzido do IRPF: R$ " + deducaoIrpf);
		} else {
			aliquotaIrpf = 27.5 / 100;
			deducaoIrpf = (salarioLiquido * aliquotaIrpf) - 839.36;
			System.out.println("\nValor a ser deduzido do IRPF: R$ " + deducaoIrpf);
		}
	}

	public void imprimirResultado() {
		System.out.println("\nSalário bruto: R$ " + salarioBruto
			+ "\nDedução dos dependentes: R$ " + deducaoDependentes
			+ "\nDeducação do INSS: R$ " + deducaoInss
			+ "\nDedução do IRPF: R$ " + deducaoIrpf
			+ "\nOutras deduções: R$ " + deducao
			+ "\nSalário Líquido: R$ " + salarioLiquido);
	}
}
