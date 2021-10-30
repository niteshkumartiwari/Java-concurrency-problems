package kachra;

import java.util.Optional;

public class B<T> extends AsyncResult<Optional<T>> {

    @Override
    public Optional<T> invoke() {
        T tmp=null;

        return Optional.ofNullable(tmp);
    }
}
