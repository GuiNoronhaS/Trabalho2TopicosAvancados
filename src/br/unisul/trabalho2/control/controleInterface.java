package br.unisul.trabalho2.control;

import br.unisul.trabalho2.JDBC.controleDadosDeJogos;
import br.unisul.trabalho2.model.JogosEletronicos;
import br.unisul.trabalho2.view.Ajuda;
import br.unisul.trabalho2.view.AlterarID;
import br.unisul.trabalho2.view.AlterarNome;
import br.unisul.trabalho2.view.ConsultarID;
import br.unisul.trabalho2.view.ConsultarNome;
import br.unisul.trabalho2.view.ExcluirID;
import br.unisul.trabalho2.view.ExcluirNome;
import br.unisul.trabalho2.view.Incluir;
import br.unisul.trabalho2.view.ListarTabela;
import br.unisul.trabalho2.view.Tela;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Classe que realiza o controle da Interface e as Interações dela
 *
 * Realiza os metodos que ira manipular a Interface.
 *
 * @author Guilherme Noronha
 */
public class controleInterface {

    private controleDadosDeJogos manipulador;

    private Tela tela;
    private Ajuda ajuda;
    private AlterarID altID;
    private AlterarNome altNome;
    private ConsultarID conID;
    private ConsultarNome conNome;
    private ExcluirID exID;
    private ExcluirNome exNome;
    private Incluir incluir;
    private ListarTabela listarTabela;

    /**
     * Construtor da Interface Cria todos os eventos necessarios para o Trabalho
     * funcionar
     */
    public controleInterface() {
        setManipulador(new controleDadosDeJogos());
        setTela(new Tela());
        setAjuda(new Ajuda());
        setAltID(new AlterarID());
        setAltNome(new AlterarNome());
        setConID(new ConsultarID());
        setConNome(new ConsultarNome());
        setExID(new ExcluirID());
        setExNome(new ExcluirNome());
        setIncluir(new Incluir());
        setListarTabela(new ListarTabela());

        getTela().jMenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fechar_action(e);
            }
        });
        getTela().jMenuItem13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirAjuda_action(e);
            }
        });
        getTela().jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirIncluir_action(e);
            }
        });
        getTela().jMenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirListarTabela_action(e);
            }
        });
        getTela().jMenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirExcluirID_action(e);
            }
        });
        getTela().jMenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirExcluirNome_action(e);
            }
        });
        getTela().jMenuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirAlterarID_action(e);
            }
        });
        getTela().jMenuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirAlterarNome_action(e);
            }
        });
        getTela().jMenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirConsultarID_action(e);
            }
        });
        getTela().jMenuItem10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirConsultarNome_action(e);
            }
        });
        getTela().jMenuItem11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numeroDeRegistros_action(e);
            }
        });
        getTela().jMenuItem14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarTabela_action(e);
            }
        });
        getTela().jMenuItem12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparTabela_action(e);
            }
        });
        getAjuda().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getIncluir().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getIncluir().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incluirRegistro_action(e);
            }
        });
        getListarTabela().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getListarTabela().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarFisico_action(e);
            }
        });
        getListarTabela().jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarLogico_action(e);
            }
        });
        getExID().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getExID().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirPorID_action(e);
            }
        });
        getExID().jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPorID_action(e);
            }
        });
        getExNome().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getExNome().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirPeloNome_action(e);
            }
        });
        getExNome().jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPorNome_action(e);
            }
        });
        getConID().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getConID().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPorID_action(e);
            }
        });
        getConNome().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getConNome().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPorNome_action(e);
            }
        });
        getAltID().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getAltID().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPorID_action(e);
            }
        });
        getAltID().jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarPorID_action(e);
            }
        });
        getAltNome().jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarTelaInicial_action(e);
            }
        });
        getAltNome().jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarPorNome_action(e);
            }
        });
        getAltNome().jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarPorNome_action(e);
            }
        });
    }

    /**
     * Metodo que inicia a Interface na "Tela Principal"
     */
    public void execute() {
        getTela().setVisible(true);
        if (manipulador.conectarBanco()) {
            getTela().jLabel1.setText("Conexão com o Banco de Dados foi bem sucedida.");
        } else {
            getTela().jLabel1.setText("Erro na conexão com o Banco de Dados ou na criação do Schema.");
        }
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public controleDadosDeJogos getManipulador() {
        return manipulador;
    }

    /**
     * Metodo SET
     *
     * @param manipulador
     */
    public void setManipulador(controleDadosDeJogos manipulador) {
        this.manipulador = manipulador;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public Tela getTela() {
        return tela;
    }

    /**
     * Metodo SET
     *
     * @param tela
     */
    public void setTela(Tela tela) {
        this.tela = tela;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public Ajuda getAjuda() {
        return ajuda;
    }

    /**
     * Metodo SET
     *
     * @param ajuda
     */
    public void setAjuda(Ajuda ajuda) {
        this.ajuda = ajuda;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public AlterarID getAltID() {
        return altID;
    }

    /**
     * Metodo SET
     *
     * @param altID
     */
    public void setAltID(AlterarID altID) {
        this.altID = altID;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public AlterarNome getAltNome() {
        return altNome;
    }

    /**
     * Metodo SET
     *
     * @param altNome
     */
    public void setAltNome(AlterarNome altNome) {
        this.altNome = altNome;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public ConsultarID getConID() {
        return conID;
    }

    /**
     * Metodo SET
     *
     * @param conID
     */
    public void setConID(ConsultarID conID) {
        this.conID = conID;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public ConsultarNome getConNome() {
        return conNome;
    }

    /**
     * Metodo SET
     *
     * @param conNome
     */
    public void setConNome(ConsultarNome conNome) {
        this.conNome = conNome;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public ExcluirID getExID() {
        return exID;
    }

    /**
     * Metodo SET
     *
     * @param exID
     */
    public void setExID(ExcluirID exID) {
        this.exID = exID;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public ExcluirNome getExNome() {
        return exNome;
    }

    /**
     * Metodo SET
     *
     * @param exNome
     */
    public void setExNome(ExcluirNome exNome) {
        this.exNome = exNome;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public Incluir getIncluir() {
        return incluir;
    }

    /**
     * Metodo SET
     *
     * @param incluir
     */
    public void setIncluir(Incluir incluir) {
        this.incluir = incluir;
    }

    /**
     * Metodo GET
     *
     * @return
     */
    public ListarTabela getListarTabela() {
        return listarTabela;
    }

    /**
     * Metodo SET
     *
     * @param listarTabela
     */
    public void setListarTabela(ListarTabela listarTabela) {
        this.listarTabela = listarTabela;
    }

    /**
     * Metodo para fechar e sair do programa pela "Tela Principal"
     *
     * @param e
     */
    void Fechar_action(ActionEvent e) {
        manipulador.desconectarBanco();
        System.exit(0);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Ajuda
     *
     * @param e
     */
    void abrirAjuda_action(ActionEvent e) {
        getTela().setVisible(false);
        getAjuda().setVisible(true);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Incluir
     *
     * @param e
     */
    void abrirIncluir_action(ActionEvent e) {
        getTela().setVisible(false);
        getIncluir().setVisible(true);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Excluir usando ID
     *
     * @param e
     */
    void abrirExcluirID_action(ActionEvent e) {
        getTela().setVisible(false);
        getExID().setVisible(true);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Excluir usando Nome
     *
     * @param e
     */
    void abrirExcluirNome_action(ActionEvent e) {
        getTela().setVisible(false);
        getExNome().setVisible(true);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Consulta usando ID
     *
     * @param e
     */
    void abrirConsultarID_action(ActionEvent e) {
        getTela().setVisible(false);
        getConID().setVisible(true);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Consulta usando Nome
     *
     * @param e
     */
    void abrirConsultarNome_action(ActionEvent e) {
        getTela().setVisible(false);
        getConNome().setVisible(true);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Alterar usando ID
     * Reseta os dados para pesquisa e a Label que indicao resultado
     *
     * @param e
     */
    void abrirAlterarID_action(ActionEvent e) {
        getTela().setVisible(false);
        getAltID().setVisible(true);
        getAltID().jLabel6.setText("Valores para Alterar: ");
        manipulador.setBloqueioAltID(0);
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Alterar usando Nome
     * Reseta os dados para pesquisa e a Label que indicao resultado
     *
     * @param e
     */
    void abrirAlterarNome_action(ActionEvent e) {
        getTela().setVisible(false);
        getAltNome().setVisible(true);
        getAltNome().jLabel6.setText("Valores para Alterar: ");
        manipulador.setBloqueioAltNome("NotValidStringCriadaComMaisDe32Caracteres");
    }

    /**
     * Metodo para Navegar da Tela Principal para a Tela de Listar Tabela
     *
     * @param e
     */
    void abrirListarTabela_action(ActionEvent e) {
        getTela().setVisible(false);
        getListarTabela().setVisible(true);
    }

    /**
     * Metodo para informar o numero de registros encontrados na Tabela
     *
     * @param e
     */
    void numeroDeRegistros_action(ActionEvent e) {
        int n = manipulador.numeroDeRegistros();
        if (n == 0) {
            getTela().jLabel1.setText("Não existe registros na Tabela.");
        } else {
            getTela().jLabel1.setText("Numero de registros Fisicos atualmente na tabela: " + n);
        }
    }

    /**
     * Metodo que controla a ação de Limpar a Tabela, chamando o controlador da
     * persistencia para esvaziar a tabela.
     *
     * @param e
     */
    void limparTabela_action(ActionEvent e) {
        if (manipulador.limparTabela()) {
            getTela().jLabel1.setText("Tabela foi Limpa.");
        } else {
            getTela().jLabel1.setText("Erro durante a limpeza da tabela.");
        }
    }

    /**
     * Metodo que controla a ação de Criar a Tabela, chamando o controlador da
     * persistencia para criar a tabela necessaria para os registros.
     *
     * @param e
     */
    void criarTabela_action(ActionEvent e) {
        if (manipulador.criarTabela()) {
            getTela().jLabel1.setText("Tabela foi Criada.");
        } else {
            getTela().jLabel1.setText("Erro na criação da tabela.");
        }
    }

    /**
     * Metodo criado para navegar de qualquer uma das Telas de volta para a
     * "Tela Principal"
     *
     * @param e
     */
    void voltarTelaInicial_action(ActionEvent e) {
        getAjuda().setVisible(false);
        getIncluir().setVisible(false);
        getExID().setVisible(false);
        getExNome().setVisible(false);
        getConID().setVisible(false);
        getConNome().setVisible(false);
        getAltID().setVisible(false);
        getAltNome().setVisible(false);
        getListarTabela().setVisible(false);
        getTela().jLabel1.setText("");
        getTela().setVisible(true);
    }

    /**
     * Metodo que pega todos dados fornecidos na Tela de Inclusão criando o
     * registro que sera passado para controle de persistencia para ser inserido
     * na Tabela. Faz o tratamento dos atributos ID e Nome para conferir se não
     * estão repetidos.
     *
     * @param e
     */
    void incluirRegistro_action(ActionEvent e) {
        int nID = (Integer) getIncluir().jSpinner2.getValue();
        String nNome = getIncluir().jTextField1.getText();
        nNome = nNome.trim();
        boolean pc = getIncluir().jCheckBox1.isSelected();
        boolean xbox = getIncluir().jCheckBox2.isSelected();
        boolean ps4 = getIncluir().jCheckBox3.isSelected();
        String nPlataforma = "Vazio";
        if (pc && xbox && ps4) {
            nPlataforma = "PC, Xbox One, PS4";
        } else if (pc && xbox) {
            nPlataforma = "PC, Xbox One";
        } else if (pc && ps4) {
            nPlataforma = "PC, PS4";
        } else if (xbox && ps4) {
            nPlataforma = "Xbox One, PS4";
        } else if (pc) {
            nPlataforma = "PC";
        } else if (xbox) {
            nPlataforma = "Xbox One";
        } else if (ps4) {
            nPlataforma = "PS4";
        }
        String nTipo = getIncluir().jTextField2.getText();
        int nQuantia = (Integer) getIncluir().jSpinner1.getValue();
        boolean retorno;
        if (nNome.isEmpty()) {
            retorno = false;
        } else if (nID == 0) {
            retorno = false;
        } else {
            retorno = false;
            if (manipulador.consultarDoBancoChave(nID).getId() == 0) {
                if (manipulador.consultarDoBancoDescritivo(nNome).getId() == 0) {
                    retorno = manipulador.incluirNoBanco(nID, nNome, nPlataforma, nTipo, nQuantia);
                }
            }
        }
        if (retorno == true) {
            getIncluir().jLabel6.setText("Resultado da Inclusão: Registro foi Incluido");
        } else {
            getIncluir().jLabel6.setText("Resultado da Inclusão: ERRO! Inclusão não foi efetuada, conferir ID e Nome");
        }
    }

    /**
     * Metodo utilizado para exibir a Lista Logica na Tela Mostrando na tela
     * todos os registros que tem ID diferente de valores negativo
     *
     * @param e
     */
    void listarLogico_action(ActionEvent e) {
        ArrayList<JogosEletronicos> logico = manipulador.listarDadosLogicos();
        DefaultTableModel dm = (DefaultTableModel) getListarTabela().jTable1.getModel();
        dm.setRowCount(0);
        for (int i = 0; i < logico.size(); i++) {
            dm.addRow(new Object[]{logico.get(i).getId(),
                logico.get(i).getNome(),
                logico.get(i).getPlataforma(),
                logico.get(i).getTipo(),
                logico.get(i).getQuantidade_de_jogadores()
            });
        }
    }

    /**
     * Metodo utilizado para exibir a Lista Fisica na Tela Mostrando na Tela
     * todos os registros presentes na tabela
     *
     * @param e
     */
    void listarFisico_action(ActionEvent e) {
        ArrayList<JogosEletronicos> fisico = manipulador.listarDadosFisico();
        DefaultTableModel dm = (DefaultTableModel) getListarTabela().jTable1.getModel();
        dm.setRowCount(0);
        for (int i = 0; i < fisico.size(); i++) {
            dm.addRow(new Object[]{fisico.get(i).getId(),
                fisico.get(i).getNome(),
                fisico.get(i).getPlataforma(),
                fisico.get(i).getTipo(),
                fisico.get(i).getQuantidade_de_jogadores()
            });
        }
    }

    /**
     * Metodo que pega o ID fornecido pelo usuario e chama o controle do arquivo
     * de Persistencia para excluir logicamente o registro. Informa o usuario se
     * a exclusão foi bem sucedida ou não. So pode ser excluido caso o valor
     * usado na pesquisa e o valor no atualmente no spinner sao iguais
     *
     * @param e
     */
    void excluirPorID_action(ActionEvent e) {
        int excluir = (Integer) getExID().jSpinner1.getValue();
        if (excluir == Integer.parseInt(getExID().jLabel8.getText())) {
            if (manipulador.marcarExclusaoDoBancoChave(excluir)) {
                getExID().jLabel2.setText("Resultado: O registro com esse ID foi excluido");
            } else {
                getExID().jLabel2.setText("Resultado: Não foi possivel realizar excluisão");
            }
        } else {
            getExID().jLabel2.setText("Resultado: ID consultado e ID para exclusão diferentes");
        }
    }

    /**
     * Metodo que pega o Nome fornecido pelo usuario e chama o controle do
     * arquivo de Persistencia para excluir logicamente o registro. Informa o
     * usuario se a exclusão foi bem sucedida ou não.
     *
     * @param e
     */
    void excluirPeloNome_action(ActionEvent e) {
        String excluir = getExNome().jTextField1.getText();
        if (excluir.equals(getExNome().jLabel9.getText())) {
            if (manipulador.marcarExclusaoDoBancoDescritivo(excluir)) {
                getExNome().jLabel4.setText("Resultado: O registro com esse ID foi excluido");
            } else {
                getExNome().jLabel4.setText("Resultado: Não foi possivel realizar excluisão");
            }
        } else {
            getExNome().jLabel4.setText("Resultado: Nome consultado e Nome para exclusão diferentes");
        }
    }

    /**
     * Metodo que utiliza o ID fornecido pelo usuario e chama o controle do
     * arquivo de Persistencia para realizar a pesquisa na tabela Informa o
     * usuario se o registro foi encontrado ou não. No caso de encontrar o
     * arquivo fornece os dados dele. Usado no Menu de consultar ID, no Menu de
     * exclusão por ID e no Menu de Alterar por ID
     *
     * @param e
     */
    void consultarPorID_action(ActionEvent e) {
        int consultar = 0;
        if (getConID().isVisible()) {
            consultar = (Integer) getConID().jSpinner1.getValue();
        } else if (getExID().isVisible()) {
            consultar = (Integer) getExID().jSpinner1.getValue();
        } else if (getAltID().isVisible()) {
            consultar = (Integer) getAltID().jSpinner3.getValue();
        }
        JogosEletronicos jogoPesquisado = manipulador.consultarDoBancoChave(consultar);
        if (jogoPesquisado.getId() == consultar) {
            if (getConID().isVisible()) {
                getConID().jLabel13.setText("Encontrado.");
                getConID().jLabel8.setText(Integer.toString(jogoPesquisado.getId()));
                getConID().jLabel9.setText(jogoPesquisado.getNome());
                getConID().jLabel10.setText(jogoPesquisado.getPlataforma());
                getConID().jLabel11.setText(jogoPesquisado.getTipo());
                getConID().jLabel12.setText(Integer.toString(jogoPesquisado.getQuantidade_de_jogadores()));
            } else if (getExID().isVisible()) {
                getExID().jLabel14.setText("Encontrado.");
                getExID().jLabel8.setText(Integer.toString(jogoPesquisado.getId()));
                getExID().jLabel9.setText(jogoPesquisado.getNome());
                getExID().jLabel10.setText(jogoPesquisado.getPlataforma());
                getExID().jLabel11.setText(jogoPesquisado.getTipo());
                getExID().jLabel12.setText(Integer.toString(jogoPesquisado.getQuantidade_de_jogadores()));
            } else if (getAltID().isVisible()) {
                getAltID().jLabel6.setText("Valores para Alterar: Registro Encontrado");
                manipulador.setBloqueioAltID(consultar);
                getAltID().jSpinner2.setValue((Integer) jogoPesquisado.getId());
                getAltID().jTextField1.setText(jogoPesquisado.getNome());
                getAltID().jTextField2.setText(jogoPesquisado.getTipo());
                getAltID().jSpinner1.setValue((Integer) jogoPesquisado.getQuantidade_de_jogadores());
                String trataCheckbox = jogoPesquisado.getPlataforma();
                if (trataCheckbox.equals("PC, Xbox One, PS4")) {
                    getAltID().jCheckBox1.setSelected(true);
                    getAltID().jCheckBox2.setSelected(true);
                    getAltID().jCheckBox3.setSelected(true);
                } else if (trataCheckbox.equals("PC, Xbox One")) {
                    getAltID().jCheckBox1.setSelected(true);
                    getAltID().jCheckBox2.setSelected(true);
                    getAltID().jCheckBox3.setSelected(false);
                } else if (trataCheckbox.equals("PC, PS4")) {
                    getAltID().jCheckBox1.setSelected(true);
                    getAltID().jCheckBox2.setSelected(false);
                    getAltID().jCheckBox3.setSelected(true);
                } else if (trataCheckbox.equals("Xbox One, PS4")) {
                    getAltID().jCheckBox1.setSelected(false);
                    getAltID().jCheckBox2.setSelected(true);
                    getAltID().jCheckBox3.setSelected(true);
                } else if (trataCheckbox.equals("PC")) {
                    getAltID().jCheckBox1.setSelected(true);
                    getAltID().jCheckBox2.setSelected(false);
                    getAltID().jCheckBox3.setSelected(false);
                } else if (trataCheckbox.equals("Xbox One")) {
                    getAltID().jCheckBox1.setSelected(false);
                    getAltID().jCheckBox2.setSelected(true);
                    getAltID().jCheckBox3.setSelected(false);
                } else if (trataCheckbox.equals("PS4")) {
                    getAltID().jCheckBox1.setSelected(false);
                    getAltID().jCheckBox2.setSelected(false);
                    getAltID().jCheckBox3.setSelected(true);
                } else {
                    getAltID().jCheckBox1.setSelected(false);
                    getAltID().jCheckBox2.setSelected(false);
                    getAltID().jCheckBox3.setSelected(false);
                }
            }
        } else {
            if (getConID().isVisible()) {
                getConID().jLabel13.setText("Não Encontrado.");
                getConID().jLabel8.setText(".");
                getConID().jLabel9.setText(".");
                getConID().jLabel10.setText(".");
                getConID().jLabel11.setText(".");
                getConID().jLabel12.setText(".");
            } else if (getExID().isVisible()) {
                getExID().jLabel14.setText("Não Encontrado.");
                getExID().jLabel8.setText(".");
                getExID().jLabel9.setText(".");
                getExID().jLabel10.setText(".");
                getExID().jLabel11.setText(".");
                getExID().jLabel12.setText(".");
            } else if (getAltID().isVisible()) {
                getAltID().jLabel6.setText("Valores para Alterar: Registro Não Encontrado");
                getAltID().jSpinner2.setValue((Integer) 1);
                getAltID().jTextField1.setText("Nome");
                getAltID().jTextField2.setText("Vazio");
                getAltID().jSpinner1.setValue((Integer) 1);
                getAltID().jCheckBox1.setSelected(false);
                getAltID().jCheckBox2.setSelected(false);
                getAltID().jCheckBox3.setSelected(false);
            }
        }
    }

    /**
     * Metodo que utiliza o Nome fornecido pelo usuario e chama o controle do
     * arquivo de Persistencia para realizar a pesquisa na tabela. Informa o
     * usuario se o registro foi encontrado ou não. No caso de encontrar o
     * arquivo fornece os dados dele. Usado no Menu de consultar Nome, no Menu
     * de exclusão por Nome e no Menu de Alterar por Nome
     *
     * @param e
     */
    void consultarPorNome_action(ActionEvent e) {
        String consultar = "";
        if (getConNome().isVisible()) {
            consultar = getConNome().jTextField1.getText();
        } else if (getExNome().isVisible()) {
            consultar = getExNome().jTextField1.getText();
        } else if (getAltNome().isVisible()) {
            consultar = getAltNome().jTextField3.getText();
        }
        JogosEletronicos jogoPesquisado = manipulador.consultarDoBancoDescritivo(consultar);
        if (jogoPesquisado.getId() == 0) {
            if (getConNome().isVisible()) {
                getConNome().jLabel15.setText("Não Encontrado.");
                getConNome().jLabel14.setText(".");
                getConNome().jLabel9.setText(".");
                getConNome().jLabel11.setText(".");
                getConNome().jLabel12.setText(".");
                getConNome().jLabel13.setText(".");
            } else if (getExNome().isVisible()) {
                getExNome().jLabel15.setText("Resultado da consulta: Não Encontrado.");
                getExNome().jLabel14.setText(".");
                getExNome().jLabel9.setText(".");
                getExNome().jLabel11.setText(".");
                getExNome().jLabel12.setText(".");
                getExNome().jLabel13.setText(".");
            } else if (getAltNome().isVisible()) {
                getAltNome().jLabel6.setText("Valores para Alterar: Registro Não Encontrado");
                getAltNome().jSpinner2.setValue((Integer) 1);
                getAltNome().jTextField1.setText("Nome");
                getAltNome().jTextField2.setText("Vazio");
                getAltNome().jSpinner1.setValue((Integer) 1);
                getAltNome().jCheckBox1.setSelected(false);
                getAltNome().jCheckBox2.setSelected(false);
                getAltNome().jCheckBox3.setSelected(false);
            }
        } else {
            if (getConNome().isVisible()) {
                getConNome().jLabel15.setText("Encontrado.");
                getConNome().jLabel14.setText(Integer.toString(jogoPesquisado.getId()));
                getConNome().jLabel9.setText(jogoPesquisado.getNome());
                getConNome().jLabel11.setText(jogoPesquisado.getPlataforma());
                getConNome().jLabel12.setText(jogoPesquisado.getTipo());
                getConNome().jLabel13.setText(Integer.toString(jogoPesquisado.getQuantidade_de_jogadores()));
            } else if (getExNome().isVisible()) {
                getExNome().jLabel15.setText("Resultado da consulta: Encontrado.");
                getExNome().jLabel14.setText(Integer.toString(jogoPesquisado.getId()));
                getExNome().jLabel9.setText(jogoPesquisado.getNome());
                getExNome().jLabel11.setText(jogoPesquisado.getPlataforma());
                getExNome().jLabel12.setText(jogoPesquisado.getTipo());
                getExNome().jLabel13.setText(Integer.toString(jogoPesquisado.getQuantidade_de_jogadores()));
            } else if (getAltNome().isVisible()) {
                getAltNome().jLabel6.setText("Valores para Alterar: Registro Encontrado");
                manipulador.setBloqueioAltNome(consultar);
                getAltNome().jSpinner2.setValue((Integer) jogoPesquisado.getId());
                getAltNome().jTextField1.setText(jogoPesquisado.getNome());
                getAltNome().jTextField2.setText(jogoPesquisado.getTipo());
                getAltNome().jSpinner1.setValue((Integer) jogoPesquisado.getQuantidade_de_jogadores());
                String trataCheckbox = jogoPesquisado.getPlataforma();
                if (trataCheckbox.equals("PC, Xbox One, PS4")) {
                    getAltNome().jCheckBox1.setSelected(true);
                    getAltNome().jCheckBox2.setSelected(true);
                    getAltNome().jCheckBox3.setSelected(true);
                } else if (trataCheckbox.equals("PC, Xbox One")) {
                    getAltNome().jCheckBox1.setSelected(true);
                    getAltNome().jCheckBox2.setSelected(true);
                    getAltNome().jCheckBox3.setSelected(false);
                } else if (trataCheckbox.equals("PC, PS4")) {
                    getAltNome().jCheckBox1.setSelected(true);
                    getAltNome().jCheckBox2.setSelected(false);
                    getAltNome().jCheckBox3.setSelected(true);
                } else if (trataCheckbox.equals("Xbox One, PS4")) {
                    getAltNome().jCheckBox1.setSelected(false);
                    getAltNome().jCheckBox2.setSelected(true);
                    getAltNome().jCheckBox3.setSelected(true);
                } else if (trataCheckbox.equals("PC")) {
                    getAltNome().jCheckBox1.setSelected(true);
                    getAltNome().jCheckBox2.setSelected(false);
                    getAltNome().jCheckBox3.setSelected(false);
                } else if (trataCheckbox.equals("Xbox One")) {
                    getAltNome().jCheckBox1.setSelected(false);
                    getAltNome().jCheckBox2.setSelected(true);
                    getAltNome().jCheckBox3.setSelected(false);
                } else if (trataCheckbox.equals("PS4")) {
                    getAltNome().jCheckBox1.setSelected(false);
                    getAltNome().jCheckBox2.setSelected(false);
                    getAltNome().jCheckBox3.setSelected(true);
                } else {
                    getAltNome().jCheckBox1.setSelected(false);
                    getAltNome().jCheckBox2.setSelected(false);
                    getAltNome().jCheckBox3.setSelected(false);
                }
            }
        }
    }

    /**
     * Metodo que utiliza o ID para alterar os dados do registro na Tabela.
     * Pegando os dados fornecido pelo usuario e pela consulta caso o usuario
     * nao altere eles para a alteração. Faz o tratamento para evitar IDs e
     * Nomes repetidos.
     *
     * @param e
     */
    void alterarPorID_action(ActionEvent e) {
        int pesquisar = (Integer) getAltID().jSpinner3.getValue();
        if (manipulador.getBloqueioAltID() != pesquisar) {
            getAltID().jLabel10.setText("Resultado: ID para alterar e ultimo ID Pesquisado são diferentes");
        } else if (pesquisar == 0) {
            getAltID().jLabel10.setText("Resultado: ID para alterar igual a 0 não é valido");
        } else {
            int idAlterar = (Integer) getAltID().jSpinner2.getValue();
            String nomeAlterar = getAltID().jTextField1.getText();
            boolean pc = getAltID().jCheckBox1.isSelected();
            boolean xbox = getAltID().jCheckBox2.isSelected();
            boolean ps4 = getAltID().jCheckBox3.isSelected();
            String platAlterar = "Vazio";
            if (pc && xbox && ps4) {
                platAlterar = "PC, Xbox One, PS4";
            } else if (pc && xbox) {
                platAlterar = "PC, Xbox One";
            } else if (pc && ps4) {
                platAlterar = "PC, PS4";
            } else if (xbox && ps4) {
                platAlterar = "Xbox One, PS4";
            } else if (pc) {
                platAlterar = "PC";
            } else if (xbox) {
                platAlterar = "Xbox One";
            } else if (ps4) {
                platAlterar = "PS4";
            }
            String tipoAlterar = getAltID().jTextField2.getText();
            int quantiaAlterar = (Integer) getAltID().jSpinner1.getValue();
            boolean retorno;
            if (nomeAlterar.isEmpty() || idAlterar == 0) {
                retorno = false;
            } else {
                retorno = false;
                if (manipulador.consultarDoBancoChave(idAlterar).getId() == 0 || pesquisar == idAlterar) {
                    if (manipulador.consultarDoBancoDescritivo(nomeAlterar).getId() == 0 || pesquisar == manipulador.consultarDoBancoDescritivo(nomeAlterar).getId()) {
                        JogosEletronicos alterar = new JogosEletronicos(idAlterar, nomeAlterar, platAlterar, tipoAlterar, quantiaAlterar);
                        retorno = manipulador.alterarDoBancoChave(pesquisar, alterar);
                    }
                }
            }
            if (retorno == true) {
                getAltID().jLabel10.setText("Resultado: Registro Alterado com Sucesso");
            } else {
                getAltID().jLabel10.setText("Resultado: ERRO! Alteração não foi efetuada, conferir IDs e Nome");
            }
        }
    }

    /**
     * Metodo que utiliza o Nome para alterar os dados do registro na tabela.
     * Pegando os dados fornecido pelo usuario e pela consulta caso o usuario
     * nao altere eles para a alteração. Faz o tratamento para evitar IDs e
     * Nomes repetidos.
     *
     * @param e
     */
    void alterarPorNome_action(ActionEvent e) {
        String pesquisar = getAltNome().jTextField3.getText();
        if (pesquisar.equals(manipulador.getBloqueioAltNome())) {
            int idAlterar = (Integer) getAltNome().jSpinner2.getValue();
            String nomeAlterar = getAltNome().jTextField1.getText();
            boolean pc = getAltNome().jCheckBox1.isSelected();
            boolean xbox = getAltNome().jCheckBox2.isSelected();
            boolean ps4 = getAltNome().jCheckBox3.isSelected();
            String platAlterar = "Vazio";
            if (pc && xbox && ps4) {
                platAlterar = "PC, Xbox One, PS4";
            } else if (pc && xbox) {
                platAlterar = "PC, Xbox One";
            } else if (pc && ps4) {
                platAlterar = "PC, PS4";
            } else if (xbox && ps4) {
                platAlterar = "Xbox One, PS4";
            } else if (pc) {
                platAlterar = "PC";
            } else if (xbox) {
                platAlterar = "Xbox One";
            } else if (ps4) {
                platAlterar = "PS4";
            }
            String tipoAlterar = getAltNome().jTextField2.getText();
            int quantiaAlterar = (Integer) getAltNome().jSpinner1.getValue();
            boolean retorno;
            if (nomeAlterar.isEmpty() || idAlterar == 0) {
                retorno = false;
            } else {
                retorno = false;
                if (manipulador.consultarDoBancoChave(idAlterar).getId() == 0 || idAlterar == manipulador.consultarDoBancoDescritivo(pesquisar).getId()) {
                    if (manipulador.consultarDoBancoDescritivo(nomeAlterar).getId() == 0 || nomeAlterar.equals(pesquisar)) {
                        JogosEletronicos alterar = new JogosEletronicos(idAlterar, nomeAlterar, platAlterar, tipoAlterar, quantiaAlterar);
                        retorno = manipulador.alterarDoBancoDescritivo(pesquisar, alterar);
                    }
                }
            }
            if (retorno == true) {
                getAltNome().jLabel10.setText("Resultado: Registro Alterado com Sucesso");
            } else {
                getAltNome().jLabel10.setText("Resultado: ERRO! Alteração não foi efetuada, conferir IDs e Nome");
            }

        } else if (pesquisar.isEmpty()) {
            getAltNome().jLabel10.setText("Resultado: Nome para alterar Vazio não é valido");
        } else {
            getAltNome().jLabel10.setText("Resultado: Nome para alterar e ultimo Nome Pesquisado são diferentes");
        }
    }
}
