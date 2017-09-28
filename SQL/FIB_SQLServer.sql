    CREATE FUNCTION fib(@VAR INT)
    RETURNS INT
    AS
    BEGIN
    DECLARE @ANS INT
    IF(@VAR=0)
    SET @ANS=0
    ELSE IF @VAR=1
    SET @ANS=1
    ELSE
    SET @ANS=dbo.fib(@VAR-1)+dbo.fib(@VAR-2)
    RETURN @ANS
    END


SELECT convert(varchar,dbo.fib(32))