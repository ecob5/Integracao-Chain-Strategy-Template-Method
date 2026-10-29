package integracao;

public interface EstrategiaAprovacao {
    NivelAprovacao determinarNivel(Pedido pedido);
}
