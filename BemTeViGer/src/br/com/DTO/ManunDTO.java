package br.com.DTO;

/**
 * @author Kassio Dias Monteiro
 */
public class ManunDTO {

    private int id;
    private int equipamentoId;
    private int pecaId;
    private int laboratorioId;
    private String problema;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipamentoId() {
        return equipamentoId;
    }

    public void setEquipamentoId(int equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public int getPecaId() {
        return pecaId;
    }

    public void setPecaId(int pecaId) {
        this.pecaId = pecaId;
    }

    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

}
