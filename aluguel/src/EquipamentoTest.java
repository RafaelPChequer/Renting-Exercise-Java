import org.junit.Test;
import static org.junit.Assert.*;

public class EquipamentoTest {

    @Test
    public void testConstrutorEquipamento() {
        Equipamento equipamento = new Equipamento("123", "Descrição do equipamento", 1000.0);

        assertEquals("123", equipamento.getCodigoIdentificacao());
        assertEquals("Descrição do equipamento", equipamento.getDescricao());
        assertEquals(1000.0, equipamento.getValor(), 0.001); // Usando delta para lidar com imprecisão de ponto flutuante
    }
    @Test
    public void testGetSetCodigoIdentificacao() {
        Equipamento equipamento = new Equipamento("123", "Descrição", 1000.0);

        equipamento.setCodigoIdentificacao("456");
        assertEquals("456", equipamento.getCodigoIdentificacao());
    }

    @Test
    public void testGetSetDescricao() {
        Equipamento equipamento = new Equipamento("123", "Descrição", 1000.0);

        equipamento.setDescricao("Nova Descrição");
        assertEquals("Nova Descrição", equipamento.getDescricao());
    }

    @Test
    public void testGetSetValor() {
        Equipamento equipamento = new Equipamento("123", "Descrição", 1000.0);

        equipamento.setValor(1500.0);
        assertEquals(1500.0, equipamento.getValor(), 0.001);
    }
    @Test
    public void testEquals() {
        Equipamento equipamento1 = new Equipamento("123", "Descrição 1", 1000.0);
        Equipamento equipamento2 = new Equipamento("123", "Descrição 2", 2000.0);
        Equipamento equipamento3 = new Equipamento("456", "Descrição 3", 3000.0);

        assertTrue(equipamento1.equals(equipamento2));
        assertFalse(equipamento1.equals(equipamento3));
    }
    @Test
    public void testValorNegativo() {
        Equipamento equipamento = new Equipamento("123", "Descrição", 1000.0);

        equipamento.setValor(-500.0);
        assertEquals(1000.0, equipamento.getValor(), 0.001);
    }
    @Test
    public void testToString() {
        Equipamento equipamento = new Equipamento("123", "Descrição do equipamento", 1000.0);
        String expectedString = "Equipamento{codigoIdentificacao='123', descricao='Descrição do equipamento', valor=1000.0}";

        assertEquals(expectedString, equipamento.toString());
    }
}

