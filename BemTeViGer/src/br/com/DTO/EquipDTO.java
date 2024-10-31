package br.com.DTO;

/**
 * @author Kassio Dias Monteiro
 */
public class EquipDTO {
    private int id;
    private String tipoEquipamento; 
    private String status; 
    private String observacao; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(String tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
    private int laboratorioId; 
    private String identificacao; 
    
}
