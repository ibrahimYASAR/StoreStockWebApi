package kodlamaio.northwind.core.utulities.results;
//başarısız işlemlerde kullanılacak
public class ErrorResult extends Result{
    //mesajsız başarısız işlem
    public ErrorResult(){
        super(false);
    }
    //mesajlı başarısız işlem
    public ErrorResult(String message){
        super(false,message);
    }
}
