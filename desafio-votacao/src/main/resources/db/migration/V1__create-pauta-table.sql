CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE pauta(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    statusPauta BOOLEAN NOT NULL
);