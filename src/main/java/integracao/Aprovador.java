package integracao;

public class Aprovador {
    private final String nome;
    private final NivelAprovacao nivel;
    private final Aprovador proximo;

    public Aprovador(String nome, NivelAprovacao nivel, Aprovador proximo) {
        this.nome = nome;
        this.nivel = nivel;
        this.proximo = proximo;
    }

    public String encaminhar(NivelAprovacao nivelNecessario) {
        if (nivel.ordinal() >= nivelNecessario.ordinal()) {
            return nome;
        }
        if (proximo != null) {
            return proximo.encaminhar(nivelNecessario);
        }
        return "Sem aprovador disponível";
    }

    public static Aprovador criarCadeiaPadrao() {
        Aprovador direcao = new Aprovador("Direção", NivelAprovacao.DIRECAO, null);
        Aprovador coordenacao = new Aprovador("Coordenação", NivelAprovacao.COORDENACAO, direcao);
        return new Aprovador("Secretaria", NivelAprovacao.SECRETARIA, coordenacao);
    }
}
