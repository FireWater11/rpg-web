CREATE TABLE users (
    id UUID get_random_uuid() PRIMARY KEY, /* temos um sql padrão, usando uma função do postgres para gerar um UUID, sendo a PK da tabela */
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    active boolean default=false
);