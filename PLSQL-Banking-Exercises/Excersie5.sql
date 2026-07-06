SET SERVEROUTPUT ON;

-- Scenario 1
DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID,
               c.Name,
               t.TransactionID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a
          ON c.CustomerID = a.CustomerID
        JOIN Transactions t
          ON a.AccountID = t.AccountID
        WHERE t.TransactionDate >= TRUNC(SYSDATE, 'MM')
          AND t.TransactionDate <
              ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1);

BEGIN
    FOR stmt IN GenerateMonthlyStatements
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || stmt.Name
            || ', Transaction ID: ' || stmt.TransactionID
            || ', Type: ' || stmt.TransactionType
            || ', Amount: ' || stmt.Amount
            || ', Date: '
            || TO_CHAR(stmt.TransactionDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/


-- Scenario 2
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_AnnualFee NUMBER := 100;

BEGIN
    FOR acc IN ApplyAnnualFee
    LOOP
        UPDATE Accounts
        SET Balance = Balance - v_AnnualFee,
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee applied to Account ID: '
            || acc.AccountID
        );
    END LOOP;

    COMMIT;
END;
/


-- Scenario 3
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount
        FROM Loans;

    v_NewRate NUMBER;

BEGIN
    FOR loan_rec IN UpdateLoanInterestRates
    LOOP
        IF loan_rec.LoanAmount < 10000 THEN
            v_NewRate := 5;

        ELSIF loan_rec.LoanAmount <= 50000 THEN
            v_NewRate := 6;

        ELSE
            v_NewRate := 7;
        END IF;

        UPDATE Loans
        SET InterestRate = v_NewRate
        WHERE LoanID = loan_rec.LoanID;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ID ' || loan_rec.LoanID
            || ' updated to '
            || v_NewRate || '%'
        );
    END LOOP;

    COMMIT;
END;
/
