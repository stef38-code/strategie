package stef.example.exemple.strategie;

public interface ServiceSoap<I,O>{
    default O send(I input) {
        throw new UnsupportedOperationException();
    }
}
