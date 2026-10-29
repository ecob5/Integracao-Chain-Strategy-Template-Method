package integracao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FluxoSolicitacaoTest {
    @Test
    void revisaoPequenaSegueParaCoordenacao() {
        FluxoSolicitacao fluxo = new FluxoRevisaoNota(Aprovador.criarCadeiaPadrao());
        assertEquals("Solicitação de revisão de nota encaminhada para Coordenação",
                fluxo.processar(new Pedido(7.0f, 7.5f, 0)));
    }

    @Test
    void revisaoGrandeSegueParaDirecao() {
        FluxoSolicitacao fluxo = new FluxoRevisaoNota(Aprovador.criarCadeiaPadrao());
        assertEquals("Solicitação de revisão de nota encaminhada para Direção",
                fluxo.processar(new Pedido(5.0f, 8.0f, 0)));
    }

    @Test
    void trancamentoDentroDoPrazoSegueParaSecretaria() {
        FluxoSolicitacao fluxo = new FluxoTrancamento(Aprovador.criarCadeiaPadrao());
        assertEquals("Solicitação de trancamento encaminhada para Secretaria",
                fluxo.processar(new Pedido(0, 0, 5)));
    }

    @Test
    void trancamentoForaDoPrazoSegueParaDirecao() {
        FluxoSolicitacao fluxo = new FluxoTrancamento(Aprovador.criarCadeiaPadrao());
        assertEquals("Solicitação de trancamento encaminhada para Direção",
                fluxo.processar(new Pedido(0, 0, 45)));
    }

    @Test
    void revisaoComNotaForaDaFaixaERejeitada() {
        FluxoSolicitacao fluxo = new FluxoRevisaoNota(Aprovador.criarCadeiaPadrao());
        assertThrows(IllegalArgumentException.class,
                () -> fluxo.processar(new Pedido(7, 11, 0)));
    }
}
