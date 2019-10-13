package pl.horus.rekrutacja;

/**
 * Wyjątek rzucany w metodach MyStructure w przypadku braku wyniku.
 */
public class INodeNotFound extends RuntimeException{
    public INodeNotFound(String message){
        super(message);
    }
}
