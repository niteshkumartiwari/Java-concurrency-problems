package fk;

@FunctionalInterface
public interface IAnimal<T> {
    public T apply();
}
