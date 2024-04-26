CREATE TABLE operations (
    id          INTEGER NOT NULL,
    description VARCHAR2(100) NOT NULL,
    type        NUMBER(1) NOT NULL
);

COMMENT ON COLUMN operations.type IS
    '1- Expensive
2- Revenue';

CREATE UNIQUE INDEX operations__idx ON
    operations (
        id
    ASC );

ALTER TABLE operations ADD CONSTRAINT operations_pk PRIMARY KEY ( id );

CREATE TABLE operations_type (
    id             INTEGER NOT NULL,
    code           INTEGER NOT NULL,
    description    VARCHAR2(100 CHAR) NOT NULL,
    enabled        NUMBER(1) NOT NULL,
    type_operation INTEGER NOT NULL
);

CREATE UNIQUE INDEX operations_type__idx ON
    operations_type (
        id
    ASC );

ALTER TABLE operations_type ADD CONSTRAINT operations_type_pk PRIMARY KEY ( id );

CREATE TABLE operators (
    id                       INTEGER NOT NULL,
    first_name               VARCHAR2(100 CHAR) NOT NULL,
    last_name                VARCHAR2(100 CHAR) NOT NULL,
    email                    VARCHAR2(100 CHAR) NOT NULL,
    password                 VARCHAR2(100 CHAR) NOT NULL,
    passcode_expiry_date     DATE NOT NULL,
    passwd_failure_retry     NUMBER(2) NOT NULL,
    last_passwd_failure_date DATE,
    permission_profile_id    INTEGER NOT NULL
);

COMMENT ON COLUMN operators.id IS
    'User ID from table users';

COMMENT ON COLUMN operators.first_name IS
    'First Name user';

COMMENT ON COLUMN operators.last_name IS
    'Last Name User';

COMMENT ON COLUMN operators.email IS
    'user email';

CREATE UNIQUE INDEX operators__idx ON
    operators (
        id
    ASC );

ALTER TABLE operators ADD CONSTRAINT user_pk PRIMARY KEY ( id );

CREATE TABLE password_histories (
    id                   INTEGER NOT NULL,
    operator_id          INTEGER NOT NULL,
    change_operator_id   INTEGER NOT NULL,
    password             VARCHAR2(100 CHAR) NOT NULL,
    password_change_date DATE NOT NULL
);

CREATE INDEX password_histories__idx ON
    password_histories (
        id
    ASC );

ALTER TABLE password_histories ADD CONSTRAINT password_histories_pk PRIMARY KEY ( id );

CREATE TABLE password_policies (
    id                          INTEGER NOT NULL,
    code                        NUMBER(15) NOT NULL,
    description                 VARCHAR2(100 CHAR) NOT NULL,
    password_length             NUMBER(3) NOT NULL,
    number_alpha_characters     NUMBER(2),
    number_numeric_characters   NUMBER(2),
    number_special_characters   NUMBER(2),
    number_uppercase_characters NUMBER(2),
    password_reuse_history      NUMBER(2),
    password_expiration_days    NUMBER(3),
    failed_login_attempts       NUMBER(2)
);

CREATE UNIQUE INDEX password_policies__idx ON
    password_policies (
        id
    ASC );

ALTER TABLE password_policies ADD CONSTRAINT password_policies_pk PRIMARY KEY ( id );

CREATE TABLE payment (
    id          INTEGER NOT NULL,
    code        NUMBER(15) NOT NULL,
    description VARCHAR2(100 CHAR) NOT NULL,
    enabled     NUMBER(1) NOT NULL
);

CREATE UNIQUE INDEX payment__idx ON
    payment (
        id
    ASC );

ALTER TABLE payment ADD CONSTRAINT payment_pk PRIMARY KEY ( id );

CREATE TABLE permission_profiles (
    id                   INTEGER NOT NULL,
    code                 VARCHAR2(50) NOT NULL,
    description          VARCHAR2(100) NOT NULL,
    access_level         NUMBER(1) NOT NULL,
    password_policies_id INTEGER NOT NULL
);

COMMENT ON COLUMN permission_profiles.access_level IS
    '1 - Admin
2 - Proprietario
3 - View and edit
4 - View only';

CREATE UNIQUE INDEX permission_profiles__idx ON
    permission_profiles (
        id
    ASC );

ALTER TABLE permission_profiles ADD CONSTRAINT permission_profiles_pk PRIMARY KEY ( id );

CREATE TABLE transactions (
    id                INTEGER NOT NULL,
    transaction_num   NUMBER(15) NOT NULL,
    operation_id      INTEGER NOT NULL,
    trans_datetime    DATE NOT NULL,
    total             NUMBER(15, 3) NOT NULL,
    payment_id        INTEGER NOT NULL,
    operator_id       INTEGER NOT NULL,
    type_operation_id INTEGER NOT NULL
);

CREATE INDEX transactions__idx ON
    transactions (
        id
    ASC );

ALTER TABLE transactions ADD CONSTRAINT transactions_pk PRIMARY KEY ( id );

ALTER TABLE operations_type
    ADD CONSTRAINT operations_type_operations_fk FOREIGN KEY ( type_operation )
        REFERENCES operations ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE operators
    ADD CONSTRAINT operators_permission_profiles_fk FOREIGN KEY ( permission_profile_id )
        REFERENCES permission_profiles ( id )
            ON DELETE CASCADE;

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE password_histories
    ADD CONSTRAINT password_histories_operators_fk FOREIGN KEY ( operator_id )
        REFERENCES operators ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE permission_profiles
    ADD CONSTRAINT permission_profiles_password_policies_fk FOREIGN KEY ( password_policies_id )
        REFERENCES password_policies ( id );

ALTER TABLE transactions
    ADD CONSTRAINT transactions_operations_fk FOREIGN KEY ( operation_id )
        REFERENCES operations ( id )
            ON DELETE CASCADE;

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE transactions
    ADD CONSTRAINT transactions_operations_type_fk FOREIGN KEY ( type_operation_id )
        REFERENCES operations_type ( id );

ALTER TABLE transactions
    ADD CONSTRAINT transactions_operators_fk FOREIGN KEY ( operator_id )
        REFERENCES operators ( id )
            ON DELETE CASCADE;

ALTER TABLE transactions
    ADD CONSTRAINT transactions_payment_fk FOREIGN KEY ( payment_id )
        REFERENCES payment ( id );

CREATE OR REPLACE TRIGGER fkntm_operations_type BEFORE
    UPDATE OF type_operation ON operations_type
BEGIN
    raise_application_error(-20225, 'Non Transferable FK constraint  on table operations_type is violated');
END;
/