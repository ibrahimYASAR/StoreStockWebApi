package kodlamaio.northwind.core.utulities.results;

public class DataResult<T> extends Result{
    //Super()'lar Result'un constraktırı...
    private T data;

    //mesajlı data result
    public DataResult(T data,boolean success, String message) {
        super(success, message);
        this.data=data;
    }
    //mesajsız data result
    public DataResult(T data,boolean success) {
        super(success);
        this.data=data;
    }

    public T getData() {
        return this.data;
    }
}
