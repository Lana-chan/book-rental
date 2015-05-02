package entidades;

public enum Unidade {
	EACH(0),
	IME(1),
	MED(2),
	POLI(3);
	
    private int _value;

    Unidade(int Value) {
        this._value = Value;
    }

    public int getValue() {
            return _value;
    }

    public static Unidade fromInt(int i) {
        for (Unidade b : Unidade .values()) {
            if (b.getValue() == i) { return b; }
        }
        return null;
    }
}
