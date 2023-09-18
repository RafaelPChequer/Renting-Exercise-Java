import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {

	  @Test
	    public void testGetNome() {
	        Cliente cliente = new Cliente("João Silva", "12345678901");
	        assertEquals("João Silva", cliente.getNome());
	    }
	  
	  @Test
	    public void testGetCpf() {
	        Cliente cliente = new Cliente("Maria Santos", "98765432109");
	        assertEquals("98765432109", cliente.getCpf());
	    }
	  
	 
}
