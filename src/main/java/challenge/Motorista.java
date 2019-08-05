package challenge;

import java.util.Objects;

public class Motorista {

    private String nome;

    private int idade;

    private int pontos;

    private String habilitacao;

    public Motorista(Builder builder) {
        this.nome = builder.nome;
        this.idade = builder.idade;
        this.pontos = builder.pontos;
        this.habilitacao = builder.habilitacao;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return idade == motorista.idade &&
                pontos == motorista.pontos &&
                Objects.equals(nome, motorista.nome) &&
                Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, pontos, habilitacao);
    }

    public static final class Builder {

        private int idade;
        private int pontos;
        private String habilitacao;
        private String nome;

        public Builder withIdade(int idade) {
            if(idade < 0){
                throw new IllegalArgumentException();
            }
            this.idade = idade;
            return this;
        }

        public Builder withPontos(int pontos) {
            if(pontos < 0){
                throw new IllegalArgumentException("não pode ter idade negativo!");
            }
            this.pontos = pontos;
            return this;
        }

        public Builder withHabilitacao(String habilitacao) {
            if(habilitacao == null){
                throw new NullPointerException();
            }
            this.habilitacao = habilitacao;
            return this;
        }

        public Builder withNome(String nome) {
            if(nome == null){
                throw new NullPointerException();
            }
            this.nome = nome;
            return this;
        }


        public Motorista build() {
            if(this.nome == null){
                throw new NullPointerException();
            }else if(this.idade < 0){
                throw new IllegalArgumentException();
            }else if(this.habilitacao == null){
                throw new NullPointerException();
            }else if(this.pontos < 0){
                throw new IllegalArgumentException();
            }
            return new Motorista(this);
        }
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }
}
