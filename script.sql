CREATE TABLE account_tb (
                            identifier VARCHAR(255) PRIMARY KEY,
                            username VARCHAR(255) NOT NULL,
                            email VARCHAR(255) NOT NULL,
                            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            updated_at TIMESTAMP
);

CREATE TABLE installment_tb (
                                identifier VARCHAR(255) PRIMARY KEY,
                                account_identifier VARCHAR(255) NOT NULL,
                                value DECIMAL(19, 2) NOT NULL,
                                due_date DATE NOT NULL,
                                enabled BOOLEAN,
                                type VARCHAR(50),
                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP
);

CREATE INDEX idx_installment_account_identifier ON installment_tb(account_identifier);
