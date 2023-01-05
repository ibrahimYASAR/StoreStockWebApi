package kodlamaio.northwind.api.controlles;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utulities.results.DataResult;
import kodlamaio.northwind.core.utulities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }


    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
    //ResponseEntity: 200-300-400-500 gibi hatalı veya olumlu dönmemize yarayan bir spring işlemi,
        //-ok: ok işlemi ise olumluysa yap anlamına gelir.
    //?: anlamı hatalı olursa 400,500 dön, olumluysa 200 dönmesine olanak sağlayan hangisi olursa,
        //-esnek olarak onu çalıştırmasına yarayar.

    public DataResult<User> findByEmail(String email){
        return this.userService.findByEmail(email);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors=new HashMap<String,String>();
        for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors=new ErrorDataResult<>(validationErrors
                ,"Dogrulama hatalari");

        return errors;
    }

}
