import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ControleTest {
    private Controle controle;
    private Cliente cliente;
    private Equipamento equipamento;

    @Before
    public void setUp() {
        controle = new Controle();
        cliente = new Cliente("John Doe", "12345678901");
        equipamento = new Equipamento("E123", "Equipamento de teste", 10.0);
    }

    @Test
    public void testRegistrarAluguel() {
        Aluguel aluguel = new Aluguel(cliente, equipamento, new Date(), new Date(), 10.0);
        controle.registrarAluguel(aluguel);

        assertTrue(controle.getAlugueis().contains(aluguel));
    }

    @Test
    public void testConsultarAlugueisCliente() {
        Aluguel aluguel = new Aluguel(cliente, equipamento, new Date(), new Date(), 10.0);
        controle.registrarAluguel(aluguel);

        Aluguel resultado = controle.consultarAlugueisCliente(cliente);

        assertEquals(aluguel, resultado);
    }

    @Test
    public void testConsultarAlugueisClienteNaoEncontrado() {
        Aluguel aluguel = new Aluguel(cliente, equipamento, new Date(), new Date(), 10.0);
        controle.registrarAluguel(aluguel);

        Cliente clienteNaoRegistrado = new Cliente("Jane Doe", "98765432109");
        Aluguel resultado = controle.consultarAlugueisCliente(clienteNaoRegistrado);

        assertNull(resultado);
    }

    @Test
    public void testGerarRelatorioMensal() {
        Calendar cal = Calendar.getInstance();
        int mesAtual = cal.get(Calendar.MONTH) + 1; // Adicionar 1 porque o mês começa em 0
        int anoAtual = cal.get(Calendar.YEAR);

        Aluguel aluguel1 = new Aluguel(cliente, equipamento, new Date(), new Date(), 10.0);
        controle.registrarAluguel(aluguel1);

        // Simular um aluguel para o próximo mês
        cal.add(Calendar.MONTH, 1);
        Aluguel aluguel2 = new Aluguel(cliente, equipamento, cal.getTime(), cal.getTime(), 15.0);
        controle.registrarAluguel(aluguel2);

        // Simular um aluguel para o mês anterior
        cal.add(Calendar.MONTH, -2);
        Aluguel aluguel3 = new Aluguel(cliente, equipamento, cal.getTime(), cal.getTime(), 20.0);
        controle.registrarAluguel(aluguel3);

        // Capturar a saída do console durante a execução do método
        String consoleOutput = captureSystemOut(() -> controle.gerarRelatorioMensal());

        assertTrue(consoleOutput.contains("Relatório Mensal de Aluguéis - " + mesAtual + "/" + anoAtual));
        assertTrue(consoleOutput.contains("Cliente: " + cliente.getNome()));
        assertTrue(consoleOutput.contains("Equipamento: " + equipamento.getDescricao()));
        assertTrue(consoleOutput.contains("Valor Total: " + aluguel1.calcularValorTotal()));
        assertTrue(consoleOutput.contains("Valor Total: " + aluguel2.calcularValorTotal()));
    }

    // Função para capturar a saída do sistema (System.out.println)
    private String captureSystemOut(Runnable runnable) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        runnable.run();

        System.setOut(originalOut);
        return outContent.toString();
    }
}
