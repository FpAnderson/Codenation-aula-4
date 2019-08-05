package challenge;

import java.util.Objects;

public class Carro {

    private String placa;

    private Cor cor;

    private Motorista motorista;

    public Carro(Builder builder) {
        this.placa = builder.placa;
        this.cor = builder.cor;
        this.motorista = builder.motorista;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(placa, carro.placa) &&
                cor == carro.cor &&
                Objects.equals(motorista, carro.motorista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, cor, motorista);
    }

    public static final class Builder {
        private String placa;
        private Cor cor;
        private Motorista motorista;

        public Builder withPlaca(String placa) {
            if (placa == null){
                throw new NullPointerException();
            }
            this.placa = placa;
            return this;
        }

        public Builder withCor(Cor cor) {
            if(cor == null){
                throw new NullPointerException();
            }
            this.cor = cor;
            return this;
        }

        public Builder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public Carro build() {

            if(this.cor == null){
                throw new NullPointerException();
            }else if (this.placa == null){
                throw new NullPointerException();
            }

            return new Carro(this);
        }
    }


    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

