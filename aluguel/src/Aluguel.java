import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Aluguel {
    private Cliente cliente;                 // Cliente que está alugando o equipamento.
    private Equipamento equipamento;         // Equipamento que está sendo alugado.
    private Date dataInicio;                 // Data de início do aluguel.
    private Date dataTermino;                // Data de término do aluguel.
    private double valorAluguelDiario;       // Valor do aluguel diário do equipamento.

    public Aluguel(Cliente cliente, Equipamento equipamento, Date dataInicio, Date dataTermino, double valorAluguelDiario) {
        // Construtor da classe Aluguel que inicializa os atributos.
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorAluguelDiario = valorAluguelDiario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public double getValorAluguelDiario() {
        return valorAluguelDiario;
    }

    public double calcularValorTotal() {
        long diferencaEmMillis = dataTermino.getTime() - dataInicio.getTime();
        long diferencaEmDias = TimeUnit.DAYS.convert(diferencaEmMillis, TimeUnit.MILLISECONDS);

        // Verificar se a diferença em dias é negativa (por exemplo, se a data de término é anterior à data de início)
        if (diferencaEmDias < 0) {
            throw new IllegalArgumentException("A data de término deve ser posterior à data de início.");
        }

        double valorTotal = valorAluguelDiario * diferencaEmDias;
        return valorTotal;
    }
}
