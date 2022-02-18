// Any symbol can be used inside the <>.
// Here, the T stands for "type" -- the dependent type.
public class GenericType<T> {
    // The field's type varies between instance.
    // Each instance can have its own type.
    public T value;
}