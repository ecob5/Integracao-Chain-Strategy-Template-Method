package integracao;

public class FluxoTrancamento extends FluxoSolicitacao {
    public FluxoTrancamento(Aprovador cadeia) {
        super(cadeia);
    }

    @Override
    protected void validar(Pedido pedido) {
        if (pedido.getDiasDesdeSolicitacao() < 0) {
            throw new IllegalArgumentException("A quantidade de dias não pode ser negativa");
        }
    }

    @Override
    protected EstrategiaAprovacao estrategia() {
        return new EstrategiaTrancamento();
    }

    @Override
    protected String tipoPedido() {
        return "Solicitação de trancamento";
    }
}
