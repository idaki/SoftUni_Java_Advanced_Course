package robotService.entities.services;

public class MainService extends BaseService {
    public static final int CAPACITY = 30;

    private String name;

    public MainService(String name) {
        super(name, CAPACITY);
    }
}
