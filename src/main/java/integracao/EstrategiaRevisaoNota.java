package integracao;

public class EstrategiaRevisaoNota implements EstrategiaAprovacao {
    @Override
    public NivelAprovacao determinarNivel(Pedido pedido) {
        float diferenca = Math.abs(pedido.getValorSolicitado() - pedido.getValorAtual());
        return diferenca <= 1.0f ? NivelAprovacao.COORDENACAO : NivelAprovacao.DIRECAO;
    }
}
