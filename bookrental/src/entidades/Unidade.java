package entidades;

public enum Unidade {
	each(0),
	ime(1),
	med(2),
	poli(3);
	
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
