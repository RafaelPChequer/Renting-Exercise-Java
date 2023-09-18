import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Controle {
    private List<Aluguel> alugueis;

    public Controle() {
        this.alugueis = new ArrayList<>();
    }

    public void registrarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public Aluguel consultarAlugueisCliente(Cliente cliente) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getCliente() == cliente) {
                return aluguel;
            }
        }
        return null;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void gerarRelatorioMensal() {
        // Obter o mês e o ano atual
        Calendar cal = Calendar.getInstance();
        int mesAtual = cal.get(Calendar.MONTH) + 1; // Adicionar 1 porque o mês começa em 0
        int anoAtual = cal.get(Calendar.YEAR);

        System.out.println("Relatório Mensal de Aluguéis - " + mesAtual + "/" + anoAtual);
        System.out.println("===============================================");

        for (Aluguel aluguel : alugueis) {
            Calendar dataInicioCal = Calendar.getInstance();
            dataInicioCal.setTime(aluguel.getDataInicio());
            int mesAluguel = dataInicioCal.get(Calendar.MONTH) + 1; // Adicionar 1 porque o mês começa em 0
            int anoAluguel = dataInicioCal.get(Calendar.YEAR);

            if (mesAluguel == mesAtual && anoAluguel == anoAtual) {
                System.out.println("Cliente: " + aluguel.getCliente().getNome());
                System.out.println("Equipamento: " + aluguel.getEquipamento().getDescricao());
                System.out.println("Data de Início: " + aluguel.getDataInicio());
                System.out.println("Data de Término: " + aluguel.getDataTermino());
                System.out.println("Valor Total: " + aluguel.calcularValorTotal());
                System.out.println("===============================================");
            }
        }
    }
}
