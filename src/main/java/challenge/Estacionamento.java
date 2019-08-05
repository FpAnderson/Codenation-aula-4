package challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Estacionamento {

    List<Carro> vagas = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(carro.getMotorista() == null || carro.getMotorista().getIdade() < 18 ||
            carro.getMotorista().getPontos() > 20){
            throw new EstacionamentoException();
        }

        if(vagas.size() < 10) {
            vagas.add(carro);
        }else{
          Carro car = vagas.stream().filter(c -> c.getMotorista().getIdade() < 55).findFirst()
                        .orElseThrow(() -> new EstacionamentoException());
          vagas.set(vagas.indexOf(car), carro);
        }
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carroBranco) {
        return vagas.stream().anyMatch(carro -> carroBranco.equals(carro));
    }
}
