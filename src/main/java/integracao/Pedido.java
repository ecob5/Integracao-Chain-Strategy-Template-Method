package integracao;

public class Pedido {
    private final float valorAtual;
    private final float valorSolicitado;
    private final int diasDesdeSolicitacao;

    public Pedido(float valorAtual, float valorSolicitado, int diasDesdeSolicitacao) {
        this.valorAtual = valorAtual;
        this.valorSolicitado = valorSolicitado;
        this.diasDesdeSolicitacao = diasDesdeSolicitacao;
    }

    public float getValorAtual() {
        return valorAtual;
    }

    public float getValorSolicitado() {
        return valorSolicitado;
    }

    public int getDiasDesdeSolicitacao() {
        return diasDesdeSolicitacao;
    }
}
