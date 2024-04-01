package reserva.notes.notes.exception;

import java.io.Serial;

public class RegistroNaoEncontradoException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public RegistroNaoEncontradoException(String message) {
        super(message);
    }

    public RegistroNaoEncontradoException(String message, Throwable t) {
        super(message, t);
    }
}
