/**
 * Operacao.java
 *
 * @author João Eduardo Montandon
 */

import java.io.Serializable;
import java.util.Date;

/**
 * Classe responsável por registrar operações de saque e depósitos realizados em contas correntes.
 */
public abstract class Operacao implements ITaxas, Comparable<Operacao>, Serializable {

    /* Data de realização da operação */
    private Date data;

    /* Tipo da operação */
    private char tipo;

    /* Valor da operação */
    private double valor;

    private static int TOTAL_OPERACOES = 0;

    /**
     * Construtor. Inicializa uma nova instância da classe Operacao onde a data da operação é exatamente a data
     * da criação da classe.
     *
     * Exemplos de uso:
     *
     * > Operacao op1 = new Operacao('d', 2500); // Operação de depósito de 2500 reais
     * > Operacao op2 = new Operacao('s', 1000); // Operação de saque de 1000 reais
     *
     * @param tipo Tipo da operação, podendo ser 'd' ou 's'
     * @param valor Valor da operação
     */
    public Operacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = new Date();

        TOTAL_OPERACOES++;
    }

    @Override
    public int compareTo(Operacao o) {
        return this.getTipo() - o.getTipo();
    }

    public String toString() {
        return this.getData() + "\t" + this.getTipo() + "\t" + this.getValor();
    }

    public Date getData() {
        return data;
    }

    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public static double getTotalOperacoes() {
        return Operacao.TOTAL_OPERACOES;
    }
}