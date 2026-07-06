SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE FUNCTION CalculateAge (
    p_DOB IN DATE
)
RETURN NUMBER
IS
    v_Age NUMBER;
BEGIN
    v_Age := TRUNC(
        MONTHS_BETWEEN(SYSDATE, p_DOB) / 12
    );

    RETURN v_Age;
END;
/



-- Scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_LoanAmount IN NUMBER,
    p_InterestRate IN NUMBER,
    p_DurationYears IN NUMBER
)
RETURN NUMBER
IS
    v_Rate NUMBER;
    v_Months NUMBER;
    v_EMI NUMBER;
BEGIN
    v_Rate := p_InterestRate / 1200;
    v_Months := p_DurationYears * 12;

    IF v_Rate = 0 THEN
        v_EMI := p_LoanAmount / v_Months;
    ELSE
        v_EMI := (p_LoanAmount * v_Rate *
                 POWER(1 + v_Rate, v_Months)) /
                 (POWER(1 + v_Rate, v_Months) - 1);
    END IF;

    RETURN ROUND(v_EMI, 2);
END;
/



-- Scenario 3
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_AccountID IN NUMBER,
    p_Amount IN NUMBER
)
RETURN BOOLEAN
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_Balance
    FROM Accounts
    WHERE AccountID = p_AccountID;

    IF v_Balance >= p_Amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
