package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class cd {
    private int id;
    private String nome;
    private float duracao;
    private String genero;
    private LocalDateTime dataFabricacao;
    private LocalDate dataLancamento;

    public cd() {
        id = -1;
        nome = "";
        duracao = 0.00F;
        genero = "";
        dataFabricacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        dataLancamento = LocalDate.now().plusMonths(6); // O default é uma validade de 6 meses.
    }

    public cd(int id, String nome, float duracao, String genero, LocalDateTime fabricacao, LocalDate lancamento) {
        setId(id);
        setNome(nome);
        setDuracao(duracao);
        setGenero(genero);
        setDataFabricacao(fabricacao);
        setDataLancamento(lancamento);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public LocalDateTime getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDateTime dataFabricacao) {

        LocalDateTime agora = LocalDateTime.now();

        if (agora.compareTo(dataFabricacao) >= 0)
            this.dataFabricacao = dataFabricacao;
    }

    public void setDataLancamento(LocalDate dataLancamento) {

        if (getDataFabricacao().isBefore(dataLancamento.atStartOfDay()))
            this.dataLancamento = dataLancamento;
    }

    public boolean emLancamento() {
        return LocalDate.now().isBefore(this.getDataLancamento());
    }

    /**
     * Método sobreposto da classe Object. É executado quando um objeto precisa
     * ser exibido na forma de String.
     */
    @Override
    public String toString() {
        return "Filme ID: " + id + "   Nome: " + nome + "   Duração: " + duracao + " minutos   Gênero: " + genero
                + "   Fabricação: "
                + dataFabricacao + "   Data de Lançamento: " + dataLancamento;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.getId() == ((cd) obj).getId() &&
                this.getNome().equals(((cd) obj).getNome()));
    }
}
