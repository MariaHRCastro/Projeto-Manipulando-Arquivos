package entidade;

public class Individuo {

	private String nome;
	private String cpf;
	private String telefone;
	private Integer idade;
	
	public Individuo() {
		
	}

	public Individuo(String nome, String cpf, String telefone, Integer idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public String toString() {
		return "Nome: "+ nome + "\n"+ "CPF: "+ cpf+ "\n"+ "Telefone: "+ telefone+"\n"+"Idade: "+idade;
	}
	
	
}
