
SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_FromAccountID IN NUMBER,
    p_ToAccountID   IN NUMBER,
    p_Amount        IN NUMBER
)
IS
    v_Balance NUMBER;
    v_ErrorMessage VARCHAR2(500);
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_FromAccountID;

    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Insufficient funds'
        );
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20002,
            'Destination account not found'
        );
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Funds transferred successfully.'
    );

EXCEPTION
    WHEN OTHERS THEN
        v_ErrorMessage := SQLERRM;

        ROLLBACK;

        INSERT INTO ErrorLog (
            ErrorMessage,
            LogDate
        )
        VALUES (
            'SafeTransferFunds: ' || v_ErrorMessage,
            SYSDATE
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer failed: ' || v_ErrorMessage
        );
END;
/


-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_EmployeeID IN NUMBER,
    p_Percentage IN NUMBER
)
IS
    v_ErrorMessage VARCHAR2(500);
BEGIN
    UPDATE Employees
    SET Salary = Salary +
                 (Salary * p_Percentage / 100)
    WHERE EmployeeID = p_EmployeeID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(
            -20003,
            'Employee ID does not exist'
        );
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Salary updated successfully.'
    );

EXCEPTION
    WHEN OTHERS THEN
        v_ErrorMessage := SQLERRM;

        ROLLBACK;

        INSERT INTO ErrorLog (
            ErrorMessage,
            LogDate
        )
        VALUES (
            'UpdateSalary: ' || v_ErrorMessage,
            SYSDATE
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Error: ' || v_ErrorMessage
        );
END;
/


-- Scenario 3
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name       IN VARCHAR2,
    p_DOB        IN DATE,
    p_Balance    IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers (
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified
    )
    VALUES (
        p_CustomerID,
        p_Name,
        p_DOB,
        p_Balance,
        SYSDATE
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Customer added successfully.'
    );

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;

        INSERT INTO ErrorLog (
            ErrorMessage,
            LogDate
        )
        VALUES (
            'Duplicate Customer ID: '
            || p_CustomerID,
            SYSDATE
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Error: Customer ID already exists.'
        );
END;
/

