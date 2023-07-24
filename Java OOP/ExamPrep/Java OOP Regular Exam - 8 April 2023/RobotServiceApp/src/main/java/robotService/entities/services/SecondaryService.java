package robotService.entities.services;

public class SecondaryService extends BaseService {
    public static final int CAPACITY = 15;

    private String name;


    public SecondaryService(String name) {
        super(name, CAPACITY);
    }
}
