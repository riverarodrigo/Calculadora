import java.math.BigDecimal;

public class CalcModel {
    // Valor inicial = 1 (elemento neutro de la multiplicación).
    // Si fuera 0, todo producto daría 0.
    public static final String INITIAL_VALUE = "1";

    private BigDecimal m_total;

    CalcModel() {
        reset();
    }

    public void reset() {
        m_total = new BigDecimal(INITIAL_VALUE);
    }

    /** Multiplica el total por un número (acepta decimales; coma o punto). */
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigDecimal(operand.trim().replace(',', '.')));
    }

    public void setValue(String value) {
        m_total = new BigDecimal(value.trim().replace(',', '.'));
    }

    /** toPlainString evita la notación científica (1E+3, etc.). */
    public String getValue() {
        return m_total.toPlainString();
    }
}
