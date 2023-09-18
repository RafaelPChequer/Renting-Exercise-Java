import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        
    }

    public void setCpf(String cpf) {
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        do {
            System.out.print("Digite o nome do cliente: ");
            nome = scanner.nextLine();
            if (!nome.contains(" ")) {
                System.out.println("Nome inválido. O nome deve ser composto por pelo menos um espaço.");
            }
        } while (!nome.contains(" "));

        String cpf;
        do {
            System.out.print("Digite o CPF do cliente (11 dígitos): ");
            cpf = scanner.nextLine();
            if (cpf.length() != 11) {
                System.out.println("CPF inválido. O CPF deve ter exatamente 11 dígitos.");
            }
        } while (cpf.length() != 11);

        Cliente cliente = new Cliente(nome, cpf);

        System.out.println("\nDados do Cliente:");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        scanner.close();
    }
}

