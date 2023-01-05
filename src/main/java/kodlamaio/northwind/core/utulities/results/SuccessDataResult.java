package kodlamaio.northwind.core.utulities.results;

public class SuccessDataResult<T> extends DataResult<T>{
    //data+işlem sonuç mesajı
    public SuccessDataResult(T data, String message) {
        super(data, true,message);
    }
    //mesaj göndermek istemeyebiliriz sadeece data göndermek ve true bilgisi
    public SuccessDataResult(T data){
        super(data,true);
    }
    //sadece mesajı versin mesaj ve true döndürmek isteyebiliriz
    public SuccessDataResult(String message) {
        super(null, true,message);
    }
    //null ve true bilgisi döndürmek
    public SuccessDataResult() {
        super(null, true);
    }
}
