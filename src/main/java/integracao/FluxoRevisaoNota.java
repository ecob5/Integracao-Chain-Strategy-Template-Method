package integracao;

public class FluxoRevisaoNota extends FluxoSolicitacao {
    public FluxoRevisaoNota(Aprovador cadeia) {
        super(cadeia);
    }

    @Override
    protected void validar(Pedido pedido) {
        if (pedido.getValorAtual() < 0 || pedido.getValorAtual() > 10
                || pedido.getValorSolicitado() < 0 || pedido.getValorSolicitado() > 10) {
            throw new IllegalArgumentException("As notas devem estar entre 0 e 10");
        }
    }

    @Override
    protected EstrategiaAprovacao estrategia() {
        return new EstrategiaRevisaoNota();
    }

    @Override
    protected String tipoPedido() {
        return "Solicitação de revisão de nota";
    }
}
