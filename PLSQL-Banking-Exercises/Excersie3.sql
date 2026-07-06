
SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE UPPER(AccountType) = 'SAVINGS';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Monthly interest processed successfully.'
    );
END;
/


-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department      IN VARCHAR2,
    p_BonusPercentage IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary +
                 (Salary * p_BonusPercentage / 100)
    WHERE UPPER(Department) =
          UPPER(p_Department);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Employee bonus updated successfully.'
    );
END;
/


-- Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccountID;

    IF v_Balance >= p_Amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_Amount,
            LastModified = SYSDATE
        WHERE AccountID = p_FromAccountID;

        UPDATE Accounts
        SET Balance = Balance + p_Amount,
            LastModified = SYSDATE
        WHERE AccountID = p_ToAccountID;

        IF SQL%ROWCOUNT = 0 THEN
            ROLLBACK;

            DBMS_OUTPUT.PUT_LINE(
                'Destination account not found.'
            );

            RETURN;
        END IF;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Funds transferred successfully.'
        );

    ELSE
        DBMS_OUTPUT.PUT_LINE(
            'Insufficient balance.'
        );
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
            'Source account not found.'
        );
END;
/
