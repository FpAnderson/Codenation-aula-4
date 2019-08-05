package challenge;

public enum Cor {

    PRETO("Preto"), BRANCO("Branco"), COLORIDO("Colorido");

    private final String descricao;

    Cor(String descricao){
        this.descricao = descricao;
    }

    public String getCor() {
        return descricao;
    }
}
