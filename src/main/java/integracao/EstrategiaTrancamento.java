package integracao;

public class EstrategiaTrancamento implements EstrategiaAprovacao {
    @Override
    public NivelAprovacao determinarNivel(Pedido pedido) {
        int dias = pedido.getDiasDesdeSolicitacao();
        if (dias <= 7) {
            return NivelAprovacao.SECRETARIA;
        }
        if (dias <= 30) {
            return NivelAprovacao.COORDENACAO;
        }
        return NivelAprovacao.DIRECAO;
    }
}
