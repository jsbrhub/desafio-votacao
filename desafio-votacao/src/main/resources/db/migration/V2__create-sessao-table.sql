CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE sessao(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    dataHora TIMESTAMP NOT NULL,
    statusSessao BOOLEAN NOT NULL,
    pauta_id UUID,
    FOREIGN KEY (pauta_id) REFERENCES pauta(id) ON DELETE CASCADE
);