CREATE DATABASE beemtevi;
USE beemtevi;

-- Tabela de usuários
CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_usuario VARCHAR(100) NOT NULL,
    senha_usuario VARCHAR(8) NOT NULL
);

-- Tabela de laboratórios
CREATE TABLE laboratorio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_laboratorio VARCHAR(100) NOT NULL
);

-- Tabela de equipamentos
CREATE TABLE equipamento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    tipo_equipamento ENUM('pc', 'notebook', 'mouse', 'teclado', 'fonte', 'cabo') NOT NULL,
    status ENUM('em uso', 'em manutencao', 'fora de uso') NOT NULL,
    observacao VARCHAR(100),
    laboratorio_id INT NULL, 
    identificacao VARCHAR(50) NOT NULL,
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id) ON DELETE SET NULL
);

-- Tabela de peças
CREATE TABLE peca (
    id INT PRIMARY KEY AUTO_INCREMENT,
    peca ENUM('HD', 'SSD', 'MEMORIA', 'FONTE', 'CABO', 'PLACA_MAE', 'COOLER', 'PROCESSADOR', 'PLACA_DE_VIDEO', 'GABINETE', 'MONITOR', 'MOUSE', 'TECLADO') NOT NULL,
    modelo VARCHAR(50),
    capacidade VARCHAR(10), 
    potencia VARCHAR(10), 
    status ENUM('disponivel', 'em manutencao') NOT NULL,
    observacoes VARCHAR(100) NOT NULL
);

-- Tabela de manutenção
CREATE TABLE manutencao (
    id INT PRIMARY KEY AUTO_INCREMENT,
    equipamento_id INT,
    peca_id INT,
    laboratorio_id INT, -- Relacionado apenas se for um equipamento de um laboratório
    problema VARCHAR(100) NOT NULL,
    FOREIGN KEY (equipamento_id) REFERENCES equipamento(id) ON DELETE SET NULL,
    FOREIGN KEY (peca_id) REFERENCES peca(id) ON DELETE SET NULL,
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id) ON DELETE SET NULL
);

-- Trigger para atualizar automaticamente a quantidade de equipamentos em um laboratório ao inserir um novo equipamento
DELIMITER //
CREATE TRIGGER atualizar_quantidade_equipamentos AFTER INSERT ON equipamento
FOR EACH ROW
BEGIN
    IF NEW.laboratorio_id IS NOT NULL THEN
        UPDATE laboratorio
        SET quantidade_equipamentos = (
            SELECT COUNT(*)
            FROM equipamento
            WHERE laboratorio_id = NEW.laboratorio_id
        )
        WHERE id = NEW.laboratorio_id;
    END IF;
END;
//
DELIMITER ;
