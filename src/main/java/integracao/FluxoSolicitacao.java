package integracao;

public abstract class FluxoSolicitacao {
    private final Aprovador cadeia;

    protected FluxoSolicitacao(Aprovador cadeia) {
        this.cadeia = cadeia;
    }

    public final String processar(Pedido pedido) {
        validar(pedido);
        NivelAprovacao nivel = estrategia().determinarNivel(pedido);
        String responsavel = cadeia.encaminhar(nivel);
        return tipoPedido() + " encaminhada para " + responsavel;
    }

    protected abstract void validar(Pedido pedido);
    protected abstract EstrategiaAprovacao estrategia();
    protected abstract String tipoPedido();
}
