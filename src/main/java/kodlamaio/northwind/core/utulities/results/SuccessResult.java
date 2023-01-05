package kodlamaio.northwind.core.utulities.results;
//işlem sonucu başarılı olan demek
public class SuccessResult extends Result{
    //mesajsız olan
    public SuccessResult(){
        super(true);
    }
    //mesajlı olan
    public SuccessResult(String message){
        super(true,message);
    }
}
