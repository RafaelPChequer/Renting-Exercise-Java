import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class AluguelTest {
    private Cliente cliente;
    private Equipamento equipamento;
    private Date dataInicio;
    private Date dataTermino;

    @BeforeEach
    public void setUp() {
        // Configuração inicial para cada teste
        cliente = new Cliente("Cliente Teste", "12345678901");
        equipamento = new Equipamento("Equipamento001", "Equipamento de Teste", 50.0);
        // Configurar datas para os testes
        dataInicio = new Date();
        dataTermino = new Date(dataInicio.getTime() + TimeUnit.DAYS.toMillis(5)); // Adicionar 5 dias
    }

    @Test
    public void calcularValorTotalComDatasValidas() {
        // Teste para verificar se o cálculo do valor total está correto
        Aluguel aluguel = new Aluguel(cliente, equipamento, dataInicio, dataTermino, 20.0);
        double valorTotal = aluguel.calcularValorTotal();
        assertEquals(100.0, valorTotal, 0.01); // Espera-se que o valor total seja 100.0 com uma margem de erro de 0.01
    }

    @Test
    public void calcularValorTotalComDataTerminoAntesDeDataInicio() {
        // Teste para verificar se uma exceção é lançada quando a data de término é anterior à data de início
        dataTermino = new Date(dataInicio.getTime() - TimeUnit.DAYS.toMillis(2)); // Subtrair 2 dias para tornar a data de término anterior
        Aluguel aluguel = new Aluguel(cliente, equipamento, dataInicio, dataTermino, 20.0);
        assertThrows(IllegalArgumentException.class, () -> aluguel.calcularValorTotal());
        // Espera-se que uma exceção do tipo IllegalArgumentException seja lançada
    }
}
