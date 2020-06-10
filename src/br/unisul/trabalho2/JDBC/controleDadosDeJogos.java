package br.unisul.trabalho2.JDBC;

import java.sql.*;
import br.unisul.trabalho2.model.JogosEletronicos;
import java.util.ArrayList;

/**
 * Classe que realiza o controle do Banco de Dados e as Interações feitas com a
 * Tabela de JogosEletronicos
 *
 * Realiza os metodos que ira manipular a Tabela de JogosEletronicos e conectar
 * com o Banco. Possui as operações: Incluir, Listar (Lógica e Física), Excluir,
 * Pesquisa, Mostrar os Registros, limpar a tabela, criar a tabela, conectar o
 * banco de dados e desconectar o banco de dados
 *
 * @author Guilherme Noronha
 */
public class controleDadosDeJogos {

    String dbdriver = "com.mysql.cj.jdbc.Driver";
    String dburl = "jdbc:mysql://localhost:3306/trabalho2JDBC?useSSL=false&useTimezone=true&serverTimezone=UTC";
    String dbusuario = "root";
    String dbsenha = "root";
    Connection con;
    int bloqueioAltID = 0;
    String bloqueioAltNome = "NotValidStringCriadaComMaisDe32Caracteres";

    /**
     * Metodo que retorna o int que é usado para o controle do metodo de
     * alteração
     *
     * @return int
     */
    public int getBloqueioAltID() {
        return bloqueioAltID;
    }

    /**
     * Metodo que altera o int que é usado para o controle do metodo de
     * alteração
     *
     * @param bloqueioAltID
     */
    public void setBloqueioAltID(int bloqueioAltID) {
        this.bloqueioAltID = bloqueioAltID;
    }

    /**
     * Metodo que retorna a String que é usada para o controle do metodo de
     * alteração
     *
     * @return String
     */
    public String getBloqueioAltNome() {
        return bloqueioAltNome;
    }

    /**
     * Metodo que altera a String que é usada para o controle do metodo de
     * alteração
     *
     * @param bloqueioAltNome
     */
    public void setBloqueioAltNome(String bloqueioAltNome) {
        this.bloqueioAltNome = bloqueioAltNome;
    }

    /**
     * Construtor sem parametros
     */
    public controleDadosDeJogos() {
    }

    /**
     * Metodo que é usado para tentar a conexão com o banco de dados retorna
     * true caso de certo e false para os erros
     *
     * @return boolean
     */
    public boolean conectarBanco() {
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(dburl, dbusuario, dbsenha);

            System.out.println("Conexão bem sucedida, Criando SCHEMA");

            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE SCHEMA trabalho2");
            stmt.executeUpdate("USE trabalho2");

            System.out.println("SCHEMA trabalho2 criado, pronto para uso");

            stmt.close();
            return true;
        } catch (ClassNotFoundException e) { //Falha em carregar o DRIVER 
            System.out.println("Falha no Driver = " + e);
            return false;
        } catch (SQLException e) { // Falha na Conexão ou no SQL  
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que é usado para cortar a conexão com o banco de dados retorna
     * true caso de certo e false para os erros
     *
     * @return boolean
     */
    public boolean desconectarBanco() {
        try {
            con.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL  
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que cria a Tabela de JogosEletronicos Retorna True para se criar a
     * tabela com sucesso Retorna False caso o corra um erro
     *
     * @return boolean
     */
    public boolean criarTabela() {
        try {
            Statement smtm = con.createStatement();
            smtm.execute("create table JOGOS_ELETRONICOS ("
                    + "id INTEGER PRIMARY KEY not null,"
                    + "nome VARCHAR(32) not null,"
                    + "plataforma VARCHAR(32) not null,"
                    + "tipo VARCHAR(16) not null,"
                    + "quantidade_de_jogadores INTEGER not null,"
                    + "CHECK(1000>quantidade_de_jogadores AND quantidade_de_jogadores>= 1))");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL  
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que adiciona um registro a Tabela de JogosEletronicos apartir das
     * informações que foram passadas pelo usuario Retorna True para sucesso e
     * False para erros
     *
     * @param id
     * @param nome
     * @param plataforma
     * @param tipo
     * @param quantidade
     * @return boolean
     */
    public boolean incluirNoBanco(int id, String nome, String plataforma, String tipo, int quantidade) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("insert into jogos_eletronicos values (" + id + ", "
                    + "'" + nome + "', "
                    + "'" + plataforma + "', "
                    + "'" + tipo + "'"
                    + "," + quantidade + ")");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que usa o ID que o usuario escolheu para procurar por um registro
     * especifico na tabela Caso encontre o jogo com o Id especifico retorna ele
     * se não retorna um objeto JogoEletronicos Vazio
     *
     * @param chave
     * @return JogosEletronicos
     */
    public JogosEletronicos consultarDoBancoChave(int chave) {
        JogosEletronicos jogo = new JogosEletronicos();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from jogos_eletronicos where id = " + chave);
            while (rs.next()) {
                int id = rs.getInt("id");
                if (id == chave) {
                    jogo.setId(id);
                    jogo.setNome(rs.getString("nome"));
                    jogo.setPlataforma(rs.getString("plataforma"));
                    jogo.setTipo(rs.getString("tipo"));
                    jogo.setQuantidade_de_jogadores(rs.getInt("quantidade_de_jogadores"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return jogo;

    }

    /**
     * Metodo que usa o Nome que o usuario escolheu para procurar por um
     * registro especifico na tabela Caso encontre o jogo com o Nome especifico
     * retorna ele se não retorna um objeto JogoEletronicos Vazio
     *
     * @param nome
     * @return JogosEletronicos
     */
    public JogosEletronicos consultarDoBancoDescritivo(String nome) {
        JogosEletronicos jogo = new JogosEletronicos();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from jogos_eletronicos where nome = '" + nome + "'");
            while (rs.next()) {
                String descritivo = rs.getString("nome");
                if (descritivo.equals(nome)) {
                    jogo.setId(rs.getInt("id"));
                    jogo.setNome(descritivo);
                    jogo.setPlataforma(rs.getString("plataforma"));
                    jogo.setTipo(rs.getString("tipo"));
                    jogo.setQuantidade_de_jogadores(rs.getInt("quantidade_de_jogadores"));
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return jogo;
    }

    /**
     * Troca o ID para um valor negativo indicando que ele esta marcado para
     * exclusão o registro a ser trocado é encontrado pelo ID fornecido pelo
     * usuario Retorna True se ocorreu a mudança que indica a exclusão logica
     * Retorna False se não ocorreu a mudança
     *
     * @param chave
     * @return boolean
     */
    public boolean marcarExclusaoDoBancoChave(int chave) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("update jogos_eletronicos set id= " + -chave + " where id= " + chave);
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Troca o ID para um valor negativo indicando que ele esta marcado para
     * exclusão o registro a ser trocado é encontrado pelo Nome fornecido pelo
     * usuario Retorna True se ocorreu a mudança que indica a exclusão logica
     * Retorna False se não ocorreu a mudança
     *
     * @param nome
     * @return boolean
     */
    public boolean marcarExclusaoDoBancoDescritivo(String nome) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("update jogos_eletronicos set id= -id where nome = '" + nome + "'");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que recebe um ID que o usuario forneceu que contem o registro que
     * se deseja alterar, alem de fornecer as informações que serão alteradas no 
     * registro dentro de um objeto da classe JogosEletronicos
     * Retorna True para uma alteração bem sucedida
     * Retorna False para caso ocorra um erro
     * 
     * @param chave
     * @param altera
     * @return boolean
     */
    public boolean alterarDoBancoChave(int chave, JogosEletronicos altera) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("update jogos_eletronicos set id= " + altera.getId()
                    + ", nome = '" + altera.getNome()
                    + "' , plataforma = '" + altera.getPlataforma()
                    + "' , tipo = '" + altera.getTipo()
                    + "' , quantidade_de_jogadores =" + altera.getQuantidade_de_jogadores()
                    + " where id= " + chave);
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que recebe um Nome que o usuario forneceu que contem o registro que
     * se deseja alterar, alem de fornecer as informações que serão alteradas no 
     * registro dentro de um objeto da classe JogosEletronicos
     * Retorna True para uma alteração bem sucedida
     * Retorna False para caso ocorra um erro
     * 
     * @param nome
     * @param altera
     * @return boolean
     */
    public boolean alterarDoBancoDescritivo(String nome, JogosEletronicos altera) {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("update jogos_eletronicos set id= " + altera.getId()
                    + ", nome = '" + altera.getNome()
                    + "' , plataforma = '" + altera.getPlataforma()
                    + "' , tipo = '" + altera.getTipo()
                    + "' , quantidade_de_jogadores =" + altera.getQuantidade_de_jogadores()
                    + " where nome= '" + nome + "'");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

    /**
     * Metodo que obtem todos os registros
     * Assim o retorno é uma lista com todos os JogosEletronicos que estão
     * na tabela
     * 
     * @return ArrayList
     */
    public ArrayList<JogosEletronicos> listarDadosFisico() {
        ArrayList<JogosEletronicos> lista = new ArrayList<JogosEletronicos>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from jogos_eletronicos");
            while (rs.next()) {
                JogosEletronicos novoJogo = new JogosEletronicos(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("plataforma"), rs.getString("tipo"), rs.getInt("quantidade_de_jogadores"));
                lista.add(novoJogo);
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return lista;
    }

    /**
     * Metodo que obtem todos os registros, e apresenta apenas os que não estão marcados para exclusão
     * Assim o retorno é uma lista de JogosEletronicos que não apresentam o ID negativo, e não estao
     * marcados para exclusão
     * 
     * @return ArrayList
     */
    public ArrayList<JogosEletronicos> listarDadosLogicos() {
        ArrayList<JogosEletronicos> lista = new ArrayList<JogosEletronicos>();
        try {
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from jogos_eletronicos");
            while (rs.next()) {
                int id = rs.getInt("id");
                if (id >= 1) {
                    JogosEletronicos novoJogo = new JogosEletronicos(id, rs.getString("nome"),
                            rs.getString("plataforma"), rs.getString("tipo"), rs.getInt("quantidade_de_jogadores"));
                    lista.add(novoJogo);
                }
            }
            smtm.close();
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
        }
        return lista;
    }

    /**
     * Metodo que utiliza da lista fisica que é obtida dos registros da tabela
     * para conseguir o numero total de registros encontrados na tabela
     * 
     * @return int 
     */
    public int numeroDeRegistros() {
        ArrayList<JogosEletronicos> lista = this.listarDadosFisico();
        if (lista.isEmpty()) {
            return 0;
        } else {
            return lista.size();
        }
    }

    /**
     * Metodo que realiza o truncamento da tabela, deletando todos os registros
     * encontrados nela
     * 
     * @return boolrsn 
     */
    public boolean limparTabela() {
        try {
            Statement smtm = con.createStatement();
            smtm.executeUpdate("truncate jogos_eletronicos");
            smtm.close();
            return true;
        } catch (SQLException e) { // Falha na Conexão ou no SQL 
            System.out.println("Falha no Sql = " + e);
            return false;
        }
    }

}
